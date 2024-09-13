package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.LetterBox;

public class RemoveLetter implements Command {
    private final LetterBox letterBox;
    
    public RemoveLetter(LetterBox letterBox) {
        this.letterBox = letterBox;
    }

    @Override
    public void execute() {
        letterBox.remove();
    }
}
