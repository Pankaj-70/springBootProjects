package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo trp;

    public TaskService(TaskRepo trp) {
        this.trp = trp;
    }

    public List<Task> sGetAllProducts() {
        return trp.findAll();
    }

    public void sCreateTask(String name) {
        Task tsk = new Task();
        tsk.setName(name);
        tsk.setCompleted(true);
        trp.save(tsk);
    }

    public void sDeleteTask(Long id) {
        trp.deleteById(id);
    }

    public void sToggleTask(Long id) {
        Task tsk = trp.findById(id).orElse(null);
        if(tsk != null) {
            tsk.setCompleted(!tsk.isCompleted());
            trp.save(tsk);
        }
    }
}
