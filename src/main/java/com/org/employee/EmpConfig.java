package com.org.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConfig {
    @Value("${siri.name}")
    private String name;

    @Value("${siri.data}")
    private String datBase;
}
