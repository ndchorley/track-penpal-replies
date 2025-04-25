package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.TrackPenpalReplies;
import com.xyphias.trackpenpalreplies.commands.CommandFactory;
import com.xyphias.trackpenpalreplies.fakes.io.CapturingOutputWriter;
import com.xyphias.trackpenpalreplies.fakes.io.InMemoryInputReader;
import com.xyphias.trackpenpalreplies.fakes.db.InMemoryLetterBox;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrackPenpalRepliesTests {
    private final InMemoryInputReader inputReader = new InMemoryInputReader();
    private final LetterBox letterBox = new InMemoryLetterBox();
    private final CapturingOutputWriter outputWriter = new CapturingOutputWriter();
    private final CommandFactory commandFactory = new CommandFactory(letterBox, outputWriter);
    private final TrackPenpalReplies app = new TrackPenpalReplies(inputReader, outputWriter, commandFactory);

    @Test
    public void it_displays_a_message_when_no_letters_need_a_reply() {
        List<String> commands = List.of("L", "Q");
        inputReader.withInputs(commands);

        app.run();

        Approvals.verify(outputWriter.written);
    }

    @Test
    public void it_displays_the_details_of_a_letter() {
        List<String> commands = List.of("A Amandine;04/07/2024", "L", "Q");
        inputReader.withInputs(commands);

        app.run();

        Approvals.verify(outputWriter.written);
    }
    
    @Test
    public void it_displays_older_letters_before_newer_ones() {
        List<String> commands = 
                List.of(
                        "A Marta;11/08/2024",
                        "A Amandine;04/07/2024",
                        "A Eric;01/06/2024",
                        "L",
                        "Q"
                );
        inputReader.withInputs(commands);

        app.run();

        Approvals.verify(outputWriter.written);        
    }
    
    @Test
    public void a_letter_can_be_removed() {
        List<String> commands =
                List.of(
                        "A John;07/08/2024",
                        "A Amandine;04/07/2024",
                        "R Amandine",
                        "L",
                        "Q"
                );
        inputReader.withInputs(commands);

        app.run();

        Approvals.verify(outputWriter.written);
    }
}
