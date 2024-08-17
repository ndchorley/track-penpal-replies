package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.TrackPenpalReplies;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.fakes.io.CapturingOutputWriter;
import com.xyphias.trackpenpalreplies.fakes.io.InMemoryInputReader;
import com.xyphias.trackpenpalreplies.fakes.io.InMemoryLetterBox;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrackPenpalRepliesTests {
    private LetterBox letterBox = new InMemoryLetterBox();
    private CapturingOutputWriter outputWriter = new CapturingOutputWriter();
    private CommandFactory commandFactory = new CommandFactory(letterBox, outputWriter);

    @Test
    public void it_displays_a_message_when_no_letters_need_a_reply() {
        List<String> commands = List.of("L", "Q");
        InMemoryInputReader inputReader = new InMemoryInputReader(commands);
        TrackPenpalReplies app =
                new TrackPenpalReplies(inputReader, outputWriter, commandFactory);

        app.run();

        Approvals.verify(outputWriter.written);
    }

    @Test
    public void it_displays_the_details_of_a_letter() {
        List<String> commands = List.of("A Amandine;04/07/2024", "L", "Q");
        InMemoryInputReader inputReader = new InMemoryInputReader(commands);
        TrackPenpalReplies app =
                new TrackPenpalReplies(inputReader, outputWriter, commandFactory);

        app.run();

        Approvals.verify(outputWriter.written);
    }
}
