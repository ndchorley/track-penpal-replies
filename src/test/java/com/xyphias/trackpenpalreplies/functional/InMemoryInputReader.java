package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;

import java.util.ArrayList;
import java.util.List;

public class InMemoryInputReader implements InputReader {
    private final ArrayList<String> commands;
    
    public InMemoryInputReader(List<String> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public String readLine() {
        return commands.removeFirst();
    }
}
