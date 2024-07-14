package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        new InMemoryLetterBox(),
                        System.console()::readLine,
                        new ConsoleOutputWriter()
                );

        app.run();
    }
}
