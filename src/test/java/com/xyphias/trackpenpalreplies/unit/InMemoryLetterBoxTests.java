package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.fakes.db.InMemoryLetterBox;

public class InMemoryLetterBoxTests extends LetterBoxContract {
    public InMemoryLetterBoxTests() {
        this.letterBox = new InMemoryLetterBox();
    }
}
