package com.xyphias.trackpenpalreplies.commands;

public class Parsing {
    public static Command parse(String command) {
        if (command.equals("L")) return new ListLetters();
        
        return new Quit();
    }
}
