package com.xyphias.trackpenpalreplies;

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
