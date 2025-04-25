package com.xyphias.trackpenpalreplies;

import java.util.List;

public interface LetterBox {
    boolean isEmpty();

    List<Letter> contents();

    void add(Letter letter);

    void remove(Penpal sender);
}
