package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.InMemoryLetterBox;
import com.xyphias.trackpenpalreplies.TrackPenpalReplies;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrackPenpalRepliesTests {
    @Test
    public void it_displays_a_message_when_no_letters_need_a_reply() {
        List<String> commands = List.of("L", "Q");
        InMemoryInputReader inputReader = new InMemoryInputReader(commands);
        CapturingOutputWriter outputWriter = new CapturingOutputWriter();
        TrackPenpalReplies app = 
                new TrackPenpalReplies(new InMemoryLetterBox(), inputReader, outputWriter);

        app.run();

        Approvals.verify(outputWriter.written);
    }
    
    @Test
    public void it_displays_the_details_of_a_letter() {
        List<String> commands = List.of("A Amandine;04/07/2024", "L", "Q");
        InMemoryInputReader inputReader = new InMemoryInputReader(commands);
        CapturingOutputWriter outputWriter = new CapturingOutputWriter();
        TrackPenpalReplies app = new TrackPenpalReplies(new InMemoryLetterBox(), inputReader, outputWriter);
        
        app.run();
        
        Approvals.verify(outputWriter.written);
    }
}
