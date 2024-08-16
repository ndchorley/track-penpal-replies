package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;

public record AddLetter(Letter letter) implements Command {
    public void execute(LetterBox letterBox) {
        letterBox.add(letter());
    }
}
