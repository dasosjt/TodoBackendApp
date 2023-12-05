package com.dasosjt.todobackendapp.controller;

import com.dasosjt.todobackendapp.entity.TaskEntity;
import com.dasosjt.todobackendapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1/task/")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Flux<TaskEntity>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<TaskEntity>> createTask(@RequestBody TaskEntity task) {
        return taskService
            .create(task)
            .map(taskCreated ->
                ResponseEntity
                    .created(URI.create("http://localhost:8080/api/task/%s"
                        .formatted(taskCreated.getId())))
                        .header("Access-Control-Expose-Headers", "Location")
                        .body(taskCreated))
            .onErrorResume(e -> Mono.just(ResponseEntity.internalServerError().build()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TaskEntity>> getTaskById(@PathVariable Long id) {
        return taskService
                .findTaskById(id)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.internalServerError().build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<TaskEntity>> updateTask(@PathVariable Long id, @RequestBody TaskEntity updatedTask) {
        return ResponseEntity.ok().body(taskService.update(id, updatedTask));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteTaskById(@PathVariable Long id) {
        return taskService
            .findTaskById(id)
            .defaultIfEmpty(TaskEntity.builder().build())
            .flatMap(taskFound -> {
                if(taskFound.getId() != null) {
                    return taskService.delete(taskFound)
                            .then(Mono.just(ResponseEntity.noContent().build()));
                } else {
                    return Mono.just(ResponseEntity.notFound().build());
                }
            })
            .onErrorResume(e ->
                Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An unexpected error occurred while deleting the task."))
            );
    }

}
