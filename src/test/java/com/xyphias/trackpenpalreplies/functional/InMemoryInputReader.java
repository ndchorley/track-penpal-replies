package com.xyphias.trackpenpalreplies.functional;

import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;

import java.util.ArrayList;
import java.util.List;

public class InMemoryInputReader implements InputReader {
    private final ArrayList<String> inputs;
    
    public InMemoryInputReader(List<String> inputs) {
        this.inputs = new ArrayList<>(inputs);
    }

    @Override
    public String readLine() {
        return inputs.removeFirst();
    }
}
