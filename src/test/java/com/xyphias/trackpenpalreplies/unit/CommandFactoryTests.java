package com.xyphias.trackpenpalreplies.unit;

import com.xyphias.trackpenpalreplies.Penpal;
import com.xyphias.trackpenpalreplies.commands.AddLetter;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandFactoryTests {
    @Test
    public void an_add_letter_command_can_contain_spaces_in_the_name() {
        String input = "A Pascal G;03/04/2024";
        CommandFactory commandFactory = new CommandFactory(null, null);

        AddLetter command = (AddLetter) commandFactory.createFrom(input);

        assertThat(command.letter.from()).isEqualTo(new Penpal("Pascal G"));
    }
}
