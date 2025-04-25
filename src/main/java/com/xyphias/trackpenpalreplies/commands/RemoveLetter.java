package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;

public class RemoveLetter implements Command {
    private final LetterBox letterBox;
    private final Penpal sender;

    public RemoveLetter(LetterBox letterBox, Penpal sender) {
        this.letterBox = letterBox;
        this.sender = sender;
    }

    @Override
    public void execute() {
        letterBox.remove(sender);
    }
}
