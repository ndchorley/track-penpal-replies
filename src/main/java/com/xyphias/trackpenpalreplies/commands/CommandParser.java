package com.xyphias.trackpenpalreplies.commands;

public class CommandParser {
    public static Command parse(String command) {
        if (command.equals("L")) return new ListPenpals();
        
        return new Quit();
    }
}
