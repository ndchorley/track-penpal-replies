package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.io.ConsoleOutputWriter;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        LetterBox letterBox = 
                createSQLiteLetterBox(
                        System.getenv("HOME") + "/penpal_letterbox.db"
                );
        
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        letterBox,
                        System.console()::readLine,
                        new ConsoleOutputWriter()
                );

        app.run();
    }

    private static LetterBox createSQLiteLetterBox(String dbFile) {
        String jdbcUrl = "jdbc:sqlite:" + dbFile;

        Flyway
                .configure()
                .dataSource(jdbcUrl, "", "")
                .load()
                .migrate();
        
        return new SQLiteLetterBox(dbFile);
    }
}
