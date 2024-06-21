package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.OutputWriter;

public class FakeOutputWriter implements OutputWriter {
    public String written = "";

    @Override
    public void writeLine(String line) {
        written += line + System.lineSeparator();
    }
}
