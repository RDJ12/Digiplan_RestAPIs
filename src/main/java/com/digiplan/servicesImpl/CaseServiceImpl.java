package com.digiplan.servicesImpl;

import com.digiplan.entities.Cases;
import com.digiplan.entities.User;
import com.digiplan.repositories.CaseRepository;
import com.digiplan.repositories.UserRepository;
import com.digiplan.services.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Cases> getAllCases() {
        log.info("@Start getAllCases");
        List<Cases> casesList = null;
        try {
            casesList = caseRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return casesList;
    }

    @Override
    public Cases addCase(Cases casesData) {
        log.info("@Start addCase");
        Cases cases = null;
        try {
            cases = caseRepository.saveAndFlush(casesData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return cases;
    }

    @Override
    public JSONArray myCases(String username) {
        log.info("@Start myCases");
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
            log.error("Exception = " + exception);
        }
        return jsonArray;
    }

}
