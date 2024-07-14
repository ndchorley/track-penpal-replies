package com.xyphias.trackpenpalreplies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryLetterBox implements LetterBox {
    public InMemoryLetterBox() {}

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

    private final ArrayList<Letter> letters = new ArrayList<>();
}
