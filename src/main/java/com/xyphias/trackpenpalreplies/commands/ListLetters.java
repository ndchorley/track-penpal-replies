package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Stream;

public final class ListLetters implements Command {
    private final LetterBox letterBox;
    private final OutputWriter outputWriter;

    public ListLetters(LetterBox letterBox, OutputWriter outputWriter) {
        this.letterBox = letterBox;
        this.outputWriter = outputWriter;
    }

    public void execute() {
        if (letterBox.isEmpty())
            displayNoRepliesNeededMessage();
        else
            allLetters().sorted(byReceivedOn).forEach(this::displayDetails);
    }

    private void displayNoRepliesNeededMessage() {
        outputWriter.writeLine("No letters need a reply");
    }

    private Stream<Letter> allLetters() {
        return letterBox.contents().stream();
    }
    
    private final Comparator<Letter> byReceivedOn = Comparator.comparing(Letter::receivedOn);

    private void displayDetails(Letter letter) {
        outputWriter.writeLine(
                letter.from().name() + ", " + letter.receivedOn().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        );
    }
}
