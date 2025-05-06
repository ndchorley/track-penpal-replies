package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.fakes.storage.InMemoryLetterBox;

public class InMemoryLetterBoxTests extends LetterBoxContract {
    public InMemoryLetterBoxTests() {
        this.letterBox = new InMemoryLetterBox();
    }
}
