package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.TrackPenpalReplies;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrackPenpalRepliesTests {
    @Test
    public void it_displays_a_message_when_no_letters_need_a_reply() {
        List<String> commands = List.of("L", "Q");
        FakeInputReader inputReader = new FakeInputReader(commands);
        FakeOutputWriter outputWriter = new FakeOutputWriter();
        TrackPenpalReplies app = new TrackPenpalReplies(inputReader, outputWriter);

        app.run();

        Approvals.verify(outputWriter.written);
    }
}
