package com.example.simpleweb.repository;

import com.example.simpleweb.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@Slf4j
public class InMemoryTaskRepository implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        log.debug("Call findAll inMemoryTaskRepository");

        return tasks;
    }

    @Override
    public Optional<Task> findById(Long id) {
        log.debug("Call findById in inMemoryTaskRepository");

        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    @Override
    public Task save(Task task) {
        log.debug("Call save in inMemoryTaskRepository");

        task.setId(System.currentTimeMillis());
        tasks.add(task);

        return task;
    }

    @Override
    public Task update(Task task) {
        log.debug("Call update in inMemoryTaskRepository");
        Task existedTask = findById((task.getId())).orElse(null);
        if (existedTask != null) {
            existedTask.setPriority((task.getPriority()));
            existedTask.setTitle(task.getTitle());
            existedTask.setDescription(task.getDescription());
        }
        return existedTask;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call delete in inMemoryTaskRepository. ID is: {}", id);

        findById(id).ifPresent(tasks::remove);
    }
}
