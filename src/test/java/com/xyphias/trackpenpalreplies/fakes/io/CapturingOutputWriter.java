package com.xyphias.trackpenpalreplies.fakes.io;

import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CapturingOutputWriter implements OutputWriter {
    public final List<String> lines = new ArrayList<>();

    @Override
    public void writeLine(String line) {
        lines.add(line + System.lineSeparator());
    }

    @Override
    public void write(String string) {
        lines.add(string);
    }
}
