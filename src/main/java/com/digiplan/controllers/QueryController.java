package com.digiplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiplan.entities.Query;
import com.digiplan.services.QueryService;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/getQuery/{queryId}")
    public ResponseEntity<Query> getQuery(@PathVariable String queryId) {
        Query query = this.queryService.getQuery(queryId);
        if (query != null)
            return new ResponseEntity<Query>(query, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllQueries")
    public List<Query> getAllQueries() {
        return this.queryService.getAllQueries();
    }

    @PostMapping("/contactus")
    public ResponseEntity<Query> addQuery(@RequestBody Query queryData) {
        return new ResponseEntity<Query>(this.queryService.addQuery(queryData), HttpStatus.CREATED);
    }

    @PutMapping("/updateQuery/{queryId}")
    public ResponseEntity<Query> updateQuery(@PathVariable String queryId, @RequestBody Query queryData) {
        Query query = this.queryService.updateQuery(queryId, queryData);
        if (query != null)
            return new ResponseEntity<Query>(query, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteQuery/{queryId}")
    public ResponseEntity<String> deleteQuery(@PathVariable String queryId) {
        String status = this.queryService.deleteQuery(queryId);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
