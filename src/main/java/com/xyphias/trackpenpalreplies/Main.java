package com.xyphias.trackpenpalreplies;

public class Main {
    public static void main(String[] args) {
        TrackPenpalReplies app =
                new TrackPenpalReplies(
                        System.console()::readLine,
                        System.out::println
                );

        app.run();
    }
}
