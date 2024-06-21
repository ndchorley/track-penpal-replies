package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.TrackPenpalReplies;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackPenpalRepliesTests {
    @Test
    public void it_displays_a_message() {
        FakeOutputWriter outputWriter = new FakeOutputWriter();
        TrackPenpalReplies app = new TrackPenpalReplies(outputWriter);

        app.run();

        assertThat(outputWriter.written).isEqualTo(
                """
                        Tracking penpal replies
                        """
        );
    }
}
