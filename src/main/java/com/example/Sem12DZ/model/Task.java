package com.example.Sem12DZ.model;



import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;



@Entity
@Data
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column( name="description", nullable=false)
    private String description;



    @Column( name="status",  nullable=false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;




    @Column( name="created_at", nullable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}