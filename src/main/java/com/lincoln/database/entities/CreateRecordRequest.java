package com.lincoln.database.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRecordRequest {

    @NotNull
    private String tableName;

    @NotNull
    private String columnName;

    private String value;

}
