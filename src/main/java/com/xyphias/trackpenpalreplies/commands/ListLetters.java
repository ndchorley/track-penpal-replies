package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.time.format.DateTimeFormatter;

public record ListLetters() implements Command {
    public void execute(LetterBox letterBox, OutputWriter outputWriter) {
        if (letterBox.isEmpty())
            outputWriter.writeLine("No letters need a reply");
        else {
            Letter letter = letterBox.contents().getFirst();

            outputWriter.writeLine(
                    letter.from().name() + ", " + letter.receivedOn().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
            );
        }
    }
}
