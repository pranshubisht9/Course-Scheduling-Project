package com.example.geektrust.model;

import com.example.geektrust.enums.CommandOperator;

import java.util.List;

public class Command {
    private final CommandOperator inputCommand;
    private final List<String> commandParams;
    public Command(CommandOperator ic, List<String> cp){
        this.inputCommand = ic;
        this.commandParams = cp;
    }
    public CommandOperator getInputCommand() {
        return inputCommand;
    }
    public List<String> getCommandParams() {
        return commandParams;
    }
}
