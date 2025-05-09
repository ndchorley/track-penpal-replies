package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private final LetterBox letterBox;
    private final OutputWriter outputWriter;

    public CommandFactory(LetterBox letterBox, OutputWriter outputWriter) {
        this.letterBox = letterBox;
        this.outputWriter = outputWriter;
    }

    public Command createFrom(String input) {
        if (input.equals("L")) return new ListLetters(letterBox, outputWriter);
        
        else if (input.startsWith("A")) {
            return new AddLetterParser(letterBox).parse(input);
        } else if (input.startsWith("R")) {
            Matcher matcher = Pattern.compile("R ([\\w]+)").matcher(input);
            matcher.matches();
            
            String name = matcher.group(1);
            
            return new RemoveLetter(letterBox, new Penpal(name));
        }

        return new Quit();
    }
}
