package com.togojug.workshop.todo.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue
    private UUID id;

    private String assignee;

    private String description;

    private Date targetDate;

    private boolean isDone;
}
