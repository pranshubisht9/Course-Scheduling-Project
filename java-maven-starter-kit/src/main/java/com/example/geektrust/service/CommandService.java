package com.example.geektrust.service;

import com.example.geektrust.utility.FixedConstants;
import com.example.geektrust.model.Command;
import com.example.geektrust.enums.CommandOperator;
import com.example.geektrust.exception.InputErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CommandService {
    static CommandService commandService = null;

    public static CommandService getInstance(){
        if(commandService==null){
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws InputErrorException {
        try {
            String[] commandWithArguments = input.split(" ");
            CommandOperator operator = CommandOperator.valueOf(FixedConstants.getValue(commandWithArguments[0]));
            List<String> commandParams =
                    Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Command command = new Command(operator, commandParams);
            this.validateInputCommand(operator,command);
            return command;
        } catch (Exception e) {
            throw new InputErrorException("INPUT_DATA_ERROR");
        }
    }

    private void validateInputCommand(CommandOperator inputCommand , Command command) throws InputErrorException {
        if(inputCommand.getNumberOfArguments()!=command.getCommandParams().size()){
            throw new InputErrorException("INPUT_DATA_ERROR");
        }
    }
}
