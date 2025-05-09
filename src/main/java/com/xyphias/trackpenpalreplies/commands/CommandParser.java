package com.xyphias.trackpenpalreplies.commands;

import java.util.regex.Matcher;

public abstract class CommandParser {
    public Command parse(String input) {
        Matcher matcher = matcherFor(input);

        if (!matcher.matches()) return null;

        return commandFrom(matcher);
    }

    protected abstract Matcher matcherFor(String input);

    protected abstract Command commandFrom(Matcher matcher);
}
