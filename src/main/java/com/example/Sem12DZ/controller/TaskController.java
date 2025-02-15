package com.example.Sem12DZ.controller;

import com.example.Sem12DZ.model.Task;
import com.example.Sem12DZ.service.FileGateaway;
import com.example.Sem12DZ.service.SaveServiceFactory;
import com.example.Sem12DZ.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {


    private final SaveServiceFactory saveServiceFactory;

    private final TaskService taskService;




    @GetMapping
    public List<Task> getAllTask(){
        return  taskService.getAllTask();
    }

    @PostMapping("/{type}")
    public ResponseEntity<Task> createTask(@PathVariable String type, @RequestBody Task task){
        saveServiceFactory.getService(type).save(task);
        return new  ResponseEntity<>(HttpStatus.OK);
    }


}
