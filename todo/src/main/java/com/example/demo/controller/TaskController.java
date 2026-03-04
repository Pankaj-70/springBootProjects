package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/task")
public class TaskController {
    private TaskService tsk;

    TaskController(TaskService serviceObj) {
        tsk = serviceObj;
    }

    @GetMapping
    public String getAllTask(Model model) {
        List< Task> tasks = tsk.sGetAllProducts();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/create")
    public String createTask(@RequestParam String name) {
        tsk.sCreateTask(name);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        tsk.sDeleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        tsk.sToggleTask(id);
        return "redirect:/";
    }
}
