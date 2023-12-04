package com.dasosjt.todobackendapp.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("tasks")
@Data
@Builder
public class TaskEntity {

    @Id
    private Long id;

    private String title;

    private String content;

    private Boolean status;

    @Column("createdAt")
    private Instant createdAt;

    @Column("updatedAt")
    private Instant updatedAt;

}
