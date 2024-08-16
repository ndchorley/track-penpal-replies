package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.time.format.DateTimeFormatter;

public final class ListLetters implements Command {
    private final LetterBox letterBox;
    private final OutputWriter outputWriter;

    public ListLetters(LetterBox letterBox, OutputWriter outputWriter) {
        this.letterBox = letterBox;
        this.outputWriter = outputWriter;
    }
    
    public void execute() {
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
