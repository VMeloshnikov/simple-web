package com.example.simpleweb;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class Task {

    private Long id;

    private String title;

    private String description;

    private int priority;
}
