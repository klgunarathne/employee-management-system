package com.example.server.loggin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class LOGS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String APPLICATION;
    private LocalDate LOG_DATE;
    private String LOGGER;
    private String LOG_LEVEL;
    private String MESSAGE;
}
