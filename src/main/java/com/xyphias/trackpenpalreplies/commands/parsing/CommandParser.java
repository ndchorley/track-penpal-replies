package com.xyphias.trackpenpalreplies.commands.parsing;

import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.infrastructure.Failure;
import com.xyphias.trackpenpalreplies.infrastructure.Result;
import com.xyphias.trackpenpalreplies.infrastructure.Success;

import java.util.regex.Matcher;

public abstract class CommandParser {
    public Result<String, Command> parse(String input) {
        Matcher matcher = matcherFor(input);

        if (!matcher.matches()) return new Failure<>(usageMessage());

        return new Success<>(commandFrom(matcher));
    }

    protected abstract Matcher matcherFor(String input);

    protected abstract Command commandFrom(Matcher matcher);

    private String usageMessage() {
        return "usage: " + commandFormat();
    }
    
    protected abstract String commandFormat();
}
