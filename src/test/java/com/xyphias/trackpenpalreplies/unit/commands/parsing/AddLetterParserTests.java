package com.xyphias.trackpenpalreplies.unit.commands.parsing;

import com.xyphias.trackpenpalreplies.Penpal;
import com.xyphias.trackpenpalreplies.commands.AddLetter;
import com.xyphias.trackpenpalreplies.commands.parsing.AddLetterParser;
import org.junit.jupiter.api.Test;

import static com.xyphias.trackpenpalreplies.ResultConveniences.successful;
import static org.assertj.core.api.Assertions.assertThat;

public class AddLetterParserTests {
    @Test
    public void an_add_letter_command_can_contain_spaces_in_the_name() {
        var input = "A Pascal G, 03/04/2024";
        var parser = new AddLetterParser(null);
        
        var result = parser.parse(input);
        var addLetter = (AddLetter) successful(result);
        
        assertThat(addLetter.letter.from()).isEqualTo(new Penpal("Pascal G"));
    }
}
