package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.SQLiteLetterBox;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.sqlite.SQLiteDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteLetterBoxTests extends LetterBoxContract {
    private final String dBFile;

    public SQLiteLetterBoxTests() throws IOException {
        dBFile = String.valueOf(Files.createTempFile("track-penpal-replies-letterbox", ".db"));

        Flyway flyway = Flyway.configure().dataSource("jdbc:sqlite:" + dBFile, null, null).load();
        flyway.migrate();
        
        this.letterBox = new SQLiteLetterBox(dBFile);
    }
    
    @BeforeEach
    public void emptyDatabase() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:" + dBFile);

        try (Connection connection = dataSource.getConnection()) {
            connection.prepareStatement("DELETE FROM Letters;").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
