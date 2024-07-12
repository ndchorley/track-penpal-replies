package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.Penpal;

import java.time.LocalDate;

public class Parsing {
    public static Command parse(String input) {
        if (input.equals("L")) return new ListLetters();
        
        else if (input.startsWith("A")) 
            return new AddLetter(
                    new Letter(
                            new Penpal("Amandine"),
                            LocalDate.of(2024, 7, 4)
                    )
            );

        return new Quit();
    }
}
