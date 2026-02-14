package com.lincoln.database.services;

import com.lincoln.database.entities.Record;
import com.lincoln.database.entities.Table;
import com.lincoln.database.exceptions.CreateRecordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class CreateService {

    private static final Logger log = LoggerFactory.getLogger(CreateService.class);

    @Value("${base-path}")
    private String basePath;

    public void createRecord(Table record) throws IOException {

        record.setId(UUID.randomUUID().toString());

        final var id = record.getId();
        final var tableName = record.getName();
        final var tablePath = basePath + File.separator + tableName + File.separator;

        Files.createDirectories(Paths.get(tablePath));

        record.getColumns().forEach(column -> {

            try {
                final var columnPath = Paths.get(tablePath + column.getName() + File.separator);
                Files.createDirectories(columnPath);

                var recordFilePath = columnPath.toRealPath() + File.separator + id;
                writeRecord(recordFilePath, column.getRecord());
            } catch (IOException e) {
                log.error("error while creating record with id: {} - {}", id, e.getMessage());
                throw new CreateRecordException(id, e);
            }

        });

        log.info("record created. id: {}", id);
    }

    private void writeRecord(String recordPath, Record record) throws IOException {
        var fos = new FileOutputStream(recordPath);
        fos.write(record.getValue().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

}
