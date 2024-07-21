package com.xyphias.trackpenpalreplies.commands;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.Penpal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {
    public static Command parse(String input) {
        if (input.equals("L")) return new ListLetters();
        
        else if (input.startsWith("A")) {
            Matcher matcher = 
                    Pattern.compile("A ([\\w ]+);(\\d{2}/\\d{2}/\\d{4})")
                            .matcher(input);
            matcher.matches();
            
            String name = matcher.group(1);
            LocalDate receivedOn = 
                    LocalDate.parse(
                            matcher.group(2),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    );
            
            return new AddLetter(
                    new Letter(new Penpal(name), receivedOn)
            );
        }

        return new Quit();
    }
}
