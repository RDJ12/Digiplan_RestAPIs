package com.digiplan.servicesImpl;

import com.digiplan.entities.Cases;
import com.digiplan.entities.Logger;
import com.digiplan.entities.User;
import com.digiplan.repositories.CaseRepository;
import com.digiplan.repositories.LoggerRepository;
import com.digiplan.repositories.UserRepository;
import com.digiplan.services.CaseService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public List<Cases> getAllCases() {
        List<Cases> casesList = null;
        try {
            casesList = caseRepository.findAll();
        } catch (Exception exception) {
            System.out.println("@getAllCases Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getAllCases", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return casesList;
    }

    @Override
    public Cases addCase(Cases casesData) {
        Cases cases = null;
        try {
            cases = caseRepository.saveAndFlush(casesData);
        } catch (Exception exception) {
            System.out.println("@addCase Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "addCase", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return cases;
    }

    @Override
    public JSONArray myCases(String username) {
        List<String> userList_username = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        Boolean doctorAdminCheck = false;
        try {
            List<User> userList = userRepository.findAllUsersList(username);
            List<Cases> casesList = caseRepository.findAll();
            if (!userList.isEmpty() || userList != null) {
                doctorAdminCheck = true;
            }
            for (User user : userList) {
                userList_username.add(user.getUsername());
            }
            for (Cases cases : casesList) {
                JSONObject jsonObject = new JSONObject();
                JSONObject extractedData = (JSONObject) jsonParser.parse(cases.getFormData());
                String casesList_username = extractedData.get("user").toString();
                if (casesList_username != null && (casesList_username.equals(username) || (doctorAdminCheck && userList_username.contains(casesList_username)))) {
                    jsonObject.put("patientName", extractedData.get("PatientName"));
                    jsonObject.put("serialNumber", extractedData.get("serialnumber"));
                    jsonObject.put("dob", extractedData.get("DOB"));
                    jsonObject.put("date", extractedData.get("date"));
                    jsonObject.put("data", extractedData);
                    jsonArray.add(jsonObject);
                }
            }
        } catch (Exception exception) {
            System.out.println("@myCases Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "myCases", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return jsonArray;
    }

    @Override
    public ResponseEntity<Object> downloadReport(String caseId) {
        ResponseEntity<Object> responseEntity = null;
        try {
            String reportPath = environment.getProperty("report.download.path") + caseId + "/Report.pdf";
            File file = new File(reportPath);
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName() + "")
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(inputStreamResource);
        } catch (Exception exception) {
            System.out.println("@downloadReport Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "downloadReport", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<Map> getCaseDetails(String caseId) {
        HttpStatus status = null;
        Map<String, Object> map = new HashMap();
        Map<String, Object> data = new HashMap();
        try {
            String filePath = environment.getProperty("case.info.path") + caseId + "/patientprorperties.properties";
            File file = new File(filePath);
            if (file.exists()) {
                InputStream inputStream = new FileInputStream(new File(filePath));
                Properties properties = new Properties();
                properties.load(inputStream);
                Iterator iterator = properties.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    data.put(key, properties.getProperty(key));
                }
                map.put("status", 200);
                map.put("message", "Record Found");
                map.put("data", data);
                status = HttpStatus.OK;
            } else {
                map.put("status", 404);
                map.put("message", "Record Not Found");
                map.put("data", "");
                status = HttpStatus.NOT_FOUND;
            }
        } catch (Exception exception) {
            System.out.println("@getCaseDetails Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getCaseDetails", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
            map.put("status", 500);
            map.put("message", "Internal Server Error");
            map.put("error", exception.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

}
