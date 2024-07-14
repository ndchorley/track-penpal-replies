package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.LetterBox;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class LetterBoxContract {
    protected LetterBox letterBox;
    
    @Test
    public void a_new_letter_box_is_empty() {
        assertThat(letterBox.isEmpty()).isTrue();
    }
}
