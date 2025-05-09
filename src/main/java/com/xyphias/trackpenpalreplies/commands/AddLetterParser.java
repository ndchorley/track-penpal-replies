package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddLetterParser {
    private final LetterBox letterBox;

    public AddLetterParser(LetterBox letterBox) {
        this.letterBox = letterBox;
    }

    public Command parse(String input) {
        Matcher matcher = matcherFor(input);

        if (!matcher.matches()) return null;

        return commandFrom(matcher);
    }

    private Command commandFrom(Matcher matcher) {
        String name = matcher.group(1);
        LocalDate receivedOn =
                LocalDate.parse(
                        matcher.group(2),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")
                );

        return new AddLetter(
                new Letter(new Penpal(name), receivedOn),
                letterBox
        );
    }

    private static Matcher matcherFor(String input) {
        return 
                Pattern
                        .compile("A ([\\w ]+);(\\d{2}/\\d{2}/\\d{4})")
                        .matcher(input);
    }
}
