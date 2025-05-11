package com.xyphias.trackpenpalreplies.commands;

public record IncorrectCommand(String usageMessage) implements Command {
    @Override
    public void execute() {}
}
