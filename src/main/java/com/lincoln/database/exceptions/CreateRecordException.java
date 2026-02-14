package com.lincoln.database.exceptions;

import lombok.Data;

import java.io.IOException;

@Data
public class CreateRecordException extends RuntimeException {

    private String id;

    public CreateRecordException(String id, IOException e) {
        super(e);
        this.id = id;
    }

}
