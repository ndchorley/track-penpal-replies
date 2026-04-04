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

    public void run() { loop(); }

    private void loop() {
        var result = readCommand();

        if (result instanceof Success<String, Command>(Quit _))
            return;

        if (result instanceof Failure<String, Command>(String error)) {
            outputWriter.writeLine(error);

            loop();
        } else {
            ((Success<?, Command>)result).value().execute();

            loop();
        }
    }

    private Result<String, Command> readCommand() {
        outputWriter.write("enter command: ");

        var input = inputReader.readLine();

        return commandFactory.createFrom(input);
    }
}
