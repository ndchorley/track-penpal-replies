package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.io.*;

public class Main {
    public static void main(String[] args) {
        OutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        System.console()::readLine,
                        consoleOutputWriter
                );

        app.run();
    }
}
