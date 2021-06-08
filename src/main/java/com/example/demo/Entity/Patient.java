package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {

    private final Integer patientId;
    private final String patientName;

}
