package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;

import java.util.ArrayList;
import java.util.List;

public class FakeInputReader implements InputReader {
    private final ArrayList<String> commands;
    
    public FakeInputReader(List<String> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public String readLine() {
        return commands.removeFirst();
    }
}
