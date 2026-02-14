package com.lincoln.database.entities;

import lombok.Data;

import java.util.List;

@Data
public class Table {

    private String id;
    private String name;
    private List<Column> columns;

}
