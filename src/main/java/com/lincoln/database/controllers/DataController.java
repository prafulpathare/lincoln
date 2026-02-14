package com.lincoln.database.controllers;

import com.lincoln.database.entities.Table;
import com.lincoln.database.services.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private CreateService createService;

    @GetMapping
    public ResponseEntity<Object> createRecord(Table record) throws IOException {

        createService.createRecord(record);

        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }

}
