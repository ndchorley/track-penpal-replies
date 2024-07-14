package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class LetterBoxContract {
    protected LetterBox letterBox;

    @Test
    public void a_new_letter_box_is_empty() {
        assertThat(letterBox.isEmpty()).isTrue();
        assertThat(letterBox.contents().isEmpty()).isTrue();
    }

    @Test
    public void it_stores_a_letter_that_is_added() {
        Letter letter =
                new Letter(
                        new Penpal("Dmitry"),
                        LocalDate.of(2024, 5, 1)
                );
        
        letterBox.add(letter);

        assertThat(letterBox.isEmpty()).isFalse();
        assertThat(letterBox.contents().getFirst()).isEqualTo(letter);
    }
}
