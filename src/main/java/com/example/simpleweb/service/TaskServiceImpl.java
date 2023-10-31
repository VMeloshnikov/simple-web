package com.example.simpleweb.service;

import com.example.simpleweb.Task;
import com.example.simpleweb.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        log.debug("Call findAll in TaskServiceImp");
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        log.debug("Call findById in TaskServiceImp");
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task save(Task task) {
        log.debug("Call save in TaskServiceImp");

        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        log.debug("Call update in TaskServiceImp");

        return taskRepository.update(task);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call deleteById in TaskServiceImp");

        taskRepository.deleteById(id);
    }

    @Override
    public void batchInsert(List<Task> tasks) {
        log.debug("Call batchInsert in TaskServiceImp");

        taskRepository.batchInsert(tasks);
    }
}
