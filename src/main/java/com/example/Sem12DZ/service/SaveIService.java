package com.example.Sem12DZ.service;

import com.example.Sem12DZ.model.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaveIService {
    ResponseEntity<Task>  save(Task task);
}
