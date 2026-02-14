package com.lincoln.database.services;

import com.lincoln.database.entities.Column;
import com.lincoln.database.entities.Record;
import com.lincoln.database.entities.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
@TestPropertySource(properties = {
    "base-path=D:\\\\temp\\\\lincoln\\\\"
})
@ExtendWith(MockitoExtension.class)
public class CreateServiceTests {

    @InjectMocks
    private CreateService createService;

    @Test
    void testCreateRecord() throws IOException {

        var columns = new ArrayList<Column>();
        columns.add(new Column("name", new com.lincoln.database.entities.Record("Praful Pathare"), false));
        columns.add(new Column("location", new com.lincoln.database.entities.Record("Mumbai"), false));
        columns.add(new Column("is_active", new Record("Y"), false));

        var record = new Table();
        record.setName("employee");
        record.setColumns(columns);
        record.setId(UUID.randomUUID().toString());

        createService.createRecord(record);

    }

}
