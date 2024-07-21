package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.fakes.io.InMemoryLetterBox;

public class InMemoryLetterBoxTests extends LetterBoxContract {
    public InMemoryLetterBoxTests() {
        this.letterBox = new InMemoryLetterBox();
    }
}
