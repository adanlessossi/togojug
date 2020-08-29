package com.togojug.workshop.todo.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private UUID id;

    private String assignee;

    private String description;

    private Date targetDate;

    private boolean isDone;
}
