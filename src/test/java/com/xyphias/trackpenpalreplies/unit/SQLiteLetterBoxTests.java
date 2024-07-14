package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.SQLiteLetterBox;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Disabled;

import java.io.IOException;
import java.nio.file.Files;

public class SQLiteLetterBoxTests extends LetterBoxContract {
    private final String dBFile;

    public SQLiteLetterBoxTests() throws IOException {
        dBFile = String.valueOf(Files.createTempFile("track-penpal-replies-letterbox", ".db"));

        Flyway flyway = Flyway.configure().dataSource("jdbc:sqlite:" + dBFile, null, null).load();
        flyway.migrate();
        
        this.letterBox = new SQLiteLetterBox(dBFile);
    }

    @Disabled
    public void it_stores_a_letter_that_is_added() {}
}
