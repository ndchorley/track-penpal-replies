package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.commands.AddLetter;
import com.xyphias.trackpenpalreplies.commands.Command;
import com.xyphias.trackpenpalreplies.commands.ListLetters;
import com.xyphias.trackpenpalreplies.commands.Quit;
import com.xyphias.trackpenpalreplies.infrastructure.io.InputReader;
import com.xyphias.trackpenpalreplies.infrastructure.io.OutputWriter;

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
            
            if (command instanceof ListLetters listLetters) 
                listLetters.execute();

            switch (command) {
                case ListLetters _ -> {}

                case AddLetter addLetterCommand -> addLetterCommand.execute(letterBox);

                case Quit _ ->  running = false;
            }
        }
    }

    private Command readCommand() {
        outputWriter.write("enter command: ");

        String input = inputReader.readLine();
        
        Command command = parse(input, letterBox, outputWriter);
        
        return command;
    }
}
