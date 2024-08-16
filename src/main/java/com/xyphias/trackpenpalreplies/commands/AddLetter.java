package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;

public final class AddLetter implements Command {
    public final Letter letter;
    public AddLetter(Letter letter) {
        this.letter = letter;
    }
    
    public void execute(LetterBox letterBox) {
        letterBox.add(letter);
    }
}
