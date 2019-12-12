package com.example.server.loggin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoggingService{

    @Autowired
    LoggingRepository loggingRepository;

    public void Save(LOGS logs) {
        logs.setAPPLICATION("Employee Management System");
        logs.setLOG_DATE(LocalDate.now());
        loggingRepository.save(logs);
    }
}
