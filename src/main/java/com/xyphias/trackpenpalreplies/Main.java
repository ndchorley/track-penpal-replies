package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.infrastructure.db.SQLiteLetterBox;
import com.xyphias.trackpenpalreplies.infrastructure.io.ConsoleOutputWriter;
import org.flywaydb.core.Flyway;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        setUpLoggingToFile();

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

    private static void setUpLoggingToFile() {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        
        Handler consoleHandler = rootLogger.getHandlers()[0];
        rootLogger.removeHandler(consoleHandler);
        
        try {
            Handler fileHandler = 
                    new FileHandler("track-penpal-replies.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            
            rootLogger.addHandler(fileHandler);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
