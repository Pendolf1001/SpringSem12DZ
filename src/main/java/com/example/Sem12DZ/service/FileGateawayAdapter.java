package com.example.Sem12DZ.service;

import com.example.Sem12DZ.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Sem12DZ.service.FileGateaway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@Service("file")
public class FileGateawayAdapter implements SaveIService{


    @Autowired
    private final FileGateaway fileGateaway;



    @Override
    public ResponseEntity<Task>  save(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        fileGateaway.writeToFile(task.getDescription()+".txt", task.toString());
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
