package com.xyphias.trackpenpalreplies.commands;

public class Parsing {
    public static Command parse(String input) {
        if (input.equals("L")) return new ListLetters();
        
        return new Quit();
    }
}
