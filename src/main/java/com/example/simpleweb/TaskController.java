package com.example.simpleweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @GetMapping("/task/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());

        return "create";
    }

    @PostMapping("/task/create")
    public String createTask(@ModelAttribute Task task) {
        task.setId(System.currentTimeMillis());
        tasks.add(task);

        return "redirect:/";
    }

    @GetMapping("/task/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = findTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/task/edit")
    public String editTask(@ModelAttribute Task task) {
        Task existedTask = findTaskById((task.getId()));
        if (existedTask != null) {
            existedTask.setPriority((task.getPriority()));
            existedTask.setTitle(task.getTitle());
            existedTask.setDescription(task.getDescription());
        }
        return "redirect:/";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
        }
        return "redirect:/";
    }

    private Task findTaskById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

}
