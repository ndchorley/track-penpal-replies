package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.util.stream.Stream;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final CommandFactory commandFactory;

    public TrackPenpalReplies(
            InputReader inputReader, OutputWriter outputWriter, CommandFactory commandFactory
    ) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.commandFactory = commandFactory;
    }

    public void run() {
        Stream
                .generate(this::readCommand)
                .flatMap(command -> {
                    if (command == null) {
                        outputWriter.writeLine("");
                        outputWriter.writeLine("usage: A <from>;<received on>");
                        return Stream.generate(this::readCommand);
                    }
                    else return Stream.of(command);
                })
                .takeWhile(command -> !(command instanceof Quit))
                .forEach(command -> {
                    outputWriter.writeLine("");
                    
                    command.execute();
                });
    }

    private Command readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();

        return commandFactory.createFrom(input);
    }
}
