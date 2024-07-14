package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.AddLetter;
import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.ListLetters;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.io.InputReader;
import com.xyphias.trackpenpalreplies.io.OutputWriter;

import java.time.format.DateTimeFormatter;

import static com.xyphias.trackpenpalreplies.commands.Parsing.parse;

public class TrackPenpalReplies {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final LetterBox letterBox;

    public TrackPenpalReplies(
            LetterBox letterBox, InputReader inputReader, OutputWriter outputWriter
    ) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.letterBox = letterBox;
    }

    public void run() {
        boolean running = true;
        
        while (running) {
            Command command = readCommand();

            outputWriter.writeLine("");
            
            switch (command) {
                case ListLetters _ -> {
                    if (letterBox.isEmpty()) 
                        outputWriter.writeLine("No letters need a reply");
                    else {
                        Letter letter = letterBox.contents().getFirst();
                        
                        outputWriter.writeLine(
                                letter.from().name() + ", " + letter.receivedOn().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
                        );
                    }
                }
                
                case AddLetter addLetter -> letterBox.add(addLetter.letter());

                case Quit _ ->  running = false;
            }
        }
    }

    private Command readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();
        
        Command command = parse(input);
        
        return command;
    }
}
