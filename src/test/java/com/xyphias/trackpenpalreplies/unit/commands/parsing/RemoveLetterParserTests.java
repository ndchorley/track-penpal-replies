package com.xyphias.trackpenpalreplies.unit.commands.parsing;

import com.xyphias.trackpenpalreplies.Penpal;
import com.xyphias.trackpenpalreplies.commands.RemoveLetter;
import com.xyphias.trackpenpalreplies.commands.parsing.RemoveLetterParser;
import org.junit.jupiter.api.Test;

import static com.xyphias.trackpenpalreplies.ResultConveniences.successful;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveLetterParserTests {
    @Test
    public void the_command_can_have_letters_in_the_name() {
        var input = "R John B";
        var parser = new RemoveLetterParser(null);

        var result = parser.parse(input);
        var command = (RemoveLetter) successful(result);

        assertThat(command.sender).isEqualTo(new Penpal("John B"));
    }
}
