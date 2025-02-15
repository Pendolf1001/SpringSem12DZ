package com.example.Sem12DZ.service;
import com.example.Sem12DZ.model.Task;
import com.example.Sem12DZ.model.TaskStatus;
import com.example.Sem12DZ.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service("db")
@AllArgsConstructor
public class TaskService implements SaveIService{


    private final TaskRepository repositoty;


    public List<Task> getAllTask() {

        return repositoty.findAll();

    }


    public Task getTaskById(Long id) {
//        Task foundTask = repositoty.findById(id).orElseThrow(() -> new TaskNotFoundException());
        Task foundTask = repositoty.findById(id).orElseThrow(null);
//        return repository.findById(id).
        return foundTask;
    }


    @Override
    public ResponseEntity<Task>  save(Task task) {
        repositoty.save(task);
        return new  ResponseEntity<>(HttpStatus.OK);
    }


    public List<Task> getTaskByStatus(TaskStatus status){
        return  repositoty.getTaskByStatus(status);
    }


    public void taskUpdateStatus(Long id, Task taskDetails) {

        Optional<Task> optionalTask = repositoty.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(taskDetails.getStatus());


            repositoty.save(task);

        } else {
            throw new IllegalArgumentException("Task not found with id : " + id);
        }


    }


    public void deleteTask(Long id){
        repositoty.deleteById(id);
    }


}