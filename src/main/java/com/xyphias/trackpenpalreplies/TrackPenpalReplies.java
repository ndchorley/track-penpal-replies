package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.*;
import com.xyphias.trackpenpalreplies.io.*;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public TrackPenpalReplies(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() {
        boolean running = true;
        
        while (running) {
            outputWriter.write("enter command: ");

            Command command = CommandParser.parse(inputReader.readLine());
            
            outputWriter.writeLine("");
            
            switch (command) {
                case ListPenpals _ -> outputWriter.writeLine("No penpals need a reply");
                case Quit _ ->  running = false; 
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
