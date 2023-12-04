package com.dasosjt.todobackendapp.repository;

import com.dasosjt.todobackendapp.entity.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Long> {

}
