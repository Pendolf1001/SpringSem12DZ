package com.example.Sem12DZ.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@AllArgsConstructor
public class SaveServiceFactory {

    @Autowired
    private Map<String, SaveIService> services;

    public SaveIService getService(String method){
        return services.get(method);
    }
}
