package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.foundational.Failure;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;
import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

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

    public void run() { loop(CommandState.OK); }

    private void loop(CommandState state) {
        var result = readCommand(state);

        if (result instanceof Success<String, Command>(Quit _))
            return;

        if (result instanceof Failure<String, Command>(String error)) {
            outputWriter.writeLine(error);

            loop(CommandState.ERROR);
        } else {
            ((Success<?, Command>)result).value().execute();

            loop(CommandState.OK);
        }
    }

    private Result<String, Command> readCommand(CommandState state) {
        outputWriter.write(promptFor(state));

        var input = inputReader.readLine();

        return commandFactory.createFrom(input);
    }

    private String promptFor(CommandState state) {
        return switch (state) {
            case OK -> "\033[34m⮞ \033[0m";
            case ERROR -> "\033[31m⮞ \033[0m";
        };
    }
}

enum CommandState {
    OK,
    ERROR
}
