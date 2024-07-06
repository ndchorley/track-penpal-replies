package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.io.OutputWriter;

public class FakeOutputWriter implements OutputWriter {
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
