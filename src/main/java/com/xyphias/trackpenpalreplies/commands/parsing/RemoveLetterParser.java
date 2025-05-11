package com.xyphias.trackpenpalreplies.commands.parsing;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;
import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.RemoveLetter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveLetterParser extends CommandParser {
    private final LetterBox letterBox;

    public RemoveLetterParser(LetterBox letterBox) {
        this.letterBox = letterBox;
    }

    @Override
    protected Matcher matcherFor(String input) {
        return Pattern.compile("R ([\\w]+)").matcher(input);
    }

    @Override
    protected Command commandFrom(Matcher matcher) {
        String name = matcher.group(1);

        return new RemoveLetter(letterBox, new Penpal(name));
    }

    @Override
    protected String usageMessage() {
        return "";
    }
}
