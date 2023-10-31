package com.example.simpleweb.service;

import com.example.simpleweb.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll();

    Task findById(Long id);

    Task save(Task task);

    Task update(Task task);

    void deleteById(Long id);
}
