package com.xyphias.trackpenpalreplies.io;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void write(String string) {
        System.out.print(string);
    }
}
