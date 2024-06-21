package com.xyphias.trackpenpalreplies;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public TrackPenpalReplies(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() {
        while (true) {
            outputWriter.writeLine("enter command: ");

            String command = inputReader.readLine();

            if (command.equals("L")) {
                outputWriter.writeLine("No penpals need a reply");
            } else {
                break;
            }
        }
    }
}
