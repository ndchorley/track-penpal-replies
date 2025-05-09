package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddLetterParser extends CommandParser {
    private final LetterBox letterBox;
    
    public AddLetterParser(LetterBox letterBox) {
        this.letterBox = letterBox;
    }

    @Override
    protected Matcher matcherFor(String input) {
        return
                Pattern
                        .compile("A ([\\w ]+);(\\d{2}/\\d{2}/\\d{4})")
                        .matcher(input);
    }
    
    @Override
    protected Command commandFrom(Matcher matcher) {
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
    
}
