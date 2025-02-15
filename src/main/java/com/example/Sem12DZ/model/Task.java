package com.example.Sem12DZ.model;



import lombok.Data;

import java.time.LocalDateTime;



@Data
public class Task {


    private  Long id;


    private String description;




    private TaskStatus status;





    private LocalDateTime createdAt;
    }

