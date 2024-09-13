package com.xyphias.trackpenpalreplies.fakes.io;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryLetterBox implements LetterBox {
    @Override
    public boolean isEmpty() { return letters.isEmpty(); }

    @Override
    public List<Letter> contents() {
        return Collections.unmodifiableList(letters);
    }

    @Override
    public void add(Letter letter) {
        letters.add(letter);
    }

    @Override
    public void remove() {
        letters.removeFirst();
    }

    private final ArrayList<Letter> letters = new ArrayList<>();
}
