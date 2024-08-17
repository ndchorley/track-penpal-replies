package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final LetterBox letterBox;
    private final CommandFactory commandFactory;

    public TrackPenpalReplies(
            LetterBox letterBox, InputReader inputReader, OutputWriter outputWriter, CommandFactory commandFactory
    ) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.letterBox = letterBox;
        this.commandFactory = commandFactory;
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

        Command command = commandFactory.createFrom(input);
        
        return command;
    }
}
