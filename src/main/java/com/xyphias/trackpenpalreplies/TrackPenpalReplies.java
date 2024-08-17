package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import static com.xyphias.trackpenpalreplies.commands.Parsing.parse;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final LetterBox letterBox;

    public TrackPenpalReplies(
            LetterBox letterBox, InputReader inputReader, OutputWriter outputWriter
    ) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.letterBox = letterBox;
    }

    public void run() {
        while (true) {
            Command command = readCommand();

            outputWriter.writeLine("");
            
            if (command instanceof Quit) break;
            
            command.execute();
        }
    }

    private Command readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();
        
        Command command = parse(input, letterBox, outputWriter);
        
        return command;
    }
}
