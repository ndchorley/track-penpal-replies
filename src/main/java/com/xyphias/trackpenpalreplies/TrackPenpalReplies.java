package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.foundational.Failure;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;
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
                .flatMap(result -> {
                    if (result instanceof Failure<String, Command>(String error)) {
                        outputWriter.writeLine("");
                        outputWriter.writeLine(error);

                        return Stream.generate(this::readCommand);
                    }
                    else return Stream.of(result);
                })
                .takeWhile(command -> 
                        !(command instanceof Success<String, Command>(Quit _))
                )
                .forEach(result -> {
                    outputWriter.writeLine("");

                    ((Success<?, Command>)result).value().execute();
                });
    }

    private Result<String, Command> readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();

        return commandFactory.createFrom(input);
    }
}
