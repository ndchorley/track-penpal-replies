package com.xyphias.trackpenpalreplies.fakes.io;

import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

public class CapturingOutputWriter implements OutputWriter {
    public String written = "";

    @Override
    public void writeLine(String line) {
        written += line + System.lineSeparator();
    }

    @Override
    public void write(String string) {
        written += string;
    }
}
