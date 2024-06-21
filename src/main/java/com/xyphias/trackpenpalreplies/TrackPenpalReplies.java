package com.xyphias.trackpenpalreplies;

public class TrackPenpalReplies {
    private final OutputWriter outputWriter;

    public TrackPenpalReplies(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void run() {
        outputWriter.writeLine("Tracking penpal replies");
    }
}
