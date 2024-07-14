package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.io.ConsoleOutputWriter;
import com.xyphias.trackpenpalreplies.io.OutputWriter;

public class Main {
    public static void main(String[] args) {
        OutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        new InMemoryLetterBox(),
                        System.console()::readLine,
                        consoleOutputWriter
                );

        app.run();
    }
}
