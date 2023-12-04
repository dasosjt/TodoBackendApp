package com.dasosjt.todobackendapp.service;

import com.dasosjt.todobackendapp.entity.TaskEntity;
import com.dasosjt.todobackendapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.Nonnull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Mono<TaskEntity> findTaskById(@Nonnull Long id) {
        return taskRepository
                .findById(id);
    }

    public Flux<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Mono<TaskEntity> create(@Nonnull TaskEntity task) {
        task.setCreatedAt(Instant.now());

        return taskRepository.save(task);
    }

    public Mono<TaskEntity> update(@Nonnull Long id, @Nonnull TaskEntity task) {
        return findTaskById(id)
            .map(Optional::of)
            .defaultIfEmpty(Optional.empty())
            .flatMap(optionalTask -> {
                if(optionalTask.isPresent()) {
                    task.setId(id);
                    task.setUpdatedAt(Instant.now());
                    task.setCreatedAt(optionalTask.get().getCreatedAt());
                    return taskRepository.save(task);
                }

                return Mono.empty();
            });
    }

    public Mono<Void> delete(@Nonnull TaskEntity task) {
        return taskRepository.delete(task);
    }
}
