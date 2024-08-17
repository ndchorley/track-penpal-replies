package com.xyphias.trackpenpalreplies.fakes.io;

import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;

import java.util.ArrayList;
import java.util.List;

public class InMemoryInputReader implements InputReader {
    private ArrayList<String> inputs;
    
    public void withInputs(List<String> inputs) {
        this.inputs = new ArrayList<>(inputs);
    }

    @Override
    public String readLine() {
        return inputs.removeFirst();
    }
}
