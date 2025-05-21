package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.infrastructure.storage.SQLiteLetterBox;
import com.xyphias.trackpenpalreplies.infrastructure.io.ConsoleOutputWriter;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        setUpLoggingToFile();

        String dbFile =
                System.getenv().getOrDefault(
                        "PENPAL_REPLY_TRACKER_DB_FILE",
                        System.getenv("HOME") + "/penpal_letterbox.db"
                );

        LetterBox letterBox = SQLiteLetterBox.createFor(dbFile);

        OutputWriter outputWriter = new ConsoleOutputWriter();

        CommandFactory commandFactory = new CommandFactory(letterBox, outputWriter);
        
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        System.console()::readLine,
                        outputWriter,
                        commandFactory
                );

        app.run();
    }

    private static void setUpLoggingToFile() {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        
        rootLogger.setLevel(Level.WARNING);
        
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
}
