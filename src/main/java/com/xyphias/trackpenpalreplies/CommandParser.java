package com.xyphias.trackpenpalreplies;

public class CommandParser {
    public static Command parse(String command) {
        if (command.equals("L")) return new ListPenpals();
        
        return new Quit();
    }
}
