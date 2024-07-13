package com.xyphias.trackpenpalreplies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterBox {
    public LetterBox() {}

    public boolean isEmpty() { return letters.isEmpty(); }

    public List<Letter> contents() {
        return Collections.unmodifiableList(letters);
    }

    public void add(Letter letter) {
        letters.add(letter);
    }

    private final ArrayList<Letter> letters = new ArrayList<>();
}
