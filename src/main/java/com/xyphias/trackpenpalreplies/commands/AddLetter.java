package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;

public final class AddLetter implements Command {
    public final Letter letter;
    private final LetterBox letterBox;

    public AddLetter(Letter letter, LetterBox letterBox) {
        this.letter = letter;
        this.letterBox = letterBox;
    }
    
    public void execute() {
        letterBox.add(letter);
    }
}
