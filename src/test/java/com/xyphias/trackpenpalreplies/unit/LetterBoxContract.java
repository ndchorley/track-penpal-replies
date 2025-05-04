package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class LetterBoxContract {
    protected LetterBox letterBox;

    @Test
    public void a_new_letter_box_is_empty() {
        assertThat(letterBox.isEmpty()).isTrue();
        assertThat(letterBox.contents().isEmpty()).isTrue();
    }

    @Test
    public void a_letter_that_has_been_added_can_be_retrieved() {
        Letter letter =
                new Letter(
                        new Penpal("Dmitry"),
                        LocalDate.of(2024, 5, 1)
                );

        letterBox.add(letter);

        assertThat(letterBox.isEmpty()).isFalse();
        assertThat(letterBox.contents().getFirst()).isEqualTo(letter);
    }

    @Test
    public void all_letters_that_have_been_added_can_be_retrieved() {
        List<Letter> letters = List.of(
                new Letter(
                        new Penpal("Dmitry"),
                        LocalDate.of(2024, 5, 1)
                ),
                new Letter(
                        new Penpal("Fabrice"),
                        LocalDate.of(2024, 6, 13)
                ),
                new Letter(
                        new Penpal("Anna"),
                        LocalDate.of(2024, 8, 28)
                )              
        );
        
        letters.forEach(letter -> letterBox.add(letter));
        
        assertThat(letterBox.contents()).isEqualTo(letters);
    }

    @Test
    public void a_letter_can_be_removed() {
        Penpal camille = new Penpal("Camille");
        Letter letterFromCamille =
                new Letter(
                        camille, 
                        LocalDate.of(2025, 4, 25)
                );
        letterBox.add(letterFromCamille);

        letterBox.removeLetterFrom(camille);
        
        assertThat(letterBox.contents()).doesNotContain(letterFromCamille);
    }
}
