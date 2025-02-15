package com.example.Sem12DZ.controller;

import com.example.Sem12DZ.model.Task;
import com.example.Sem12DZ.service.FileGateaway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final FileGateaway fileGateaway;

    @PostMapping
    public ResponseEntity<Task> createNote(@RequestBody Task task){
        task.setCreatedAt(LocalDateTime.now());
        fileGateaway.writeToFile(task.getDescription()+".txt", task.toString());
        return new  ResponseEntity<>(HttpStatus.OK);
    }


}
