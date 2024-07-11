package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.*;
import com.xyphias.trackpenpalreplies.io.*;

import static com.xyphias.trackpenpalreplies.commands.Parsing.*;

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
            Command command = readCommand();

            outputWriter.writeLine("");
            
            switch (command) {
                case ListLetters _ -> outputWriter.writeLine("No letters need a reply");
                case Quit _ ->  running = false; 
            }
        }
    }

    private Command readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();
        
        Command command = parse(input);
        
        return command;
    }
}
