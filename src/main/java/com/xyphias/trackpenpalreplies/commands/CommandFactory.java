package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.commands.parsing.AddLetterParser;
import com.xyphias.trackpenpalreplies.commands.parsing.RemoveLetterParser;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

public class CommandFactory {
    private final LetterBox letterBox;
    private final OutputWriter outputWriter;

    public CommandFactory(LetterBox letterBox, OutputWriter outputWriter) {
        this.letterBox = letterBox;
        this.outputWriter = outputWriter;
    }

    public Result<String, Command> createFrom(String input) {
        if (input.equals("L"))
            return new Success<>(new ListLetters(letterBox, outputWriter));
        
        else if (input.startsWith("A")) {
            return new AddLetterParser(letterBox).parse(input);
        } else if (input.startsWith("R")) {
            return new RemoveLetterParser(letterBox).parse(input);
        }

        return new Success<>(new Quit());
    }
}
