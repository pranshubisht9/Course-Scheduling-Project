package com.example.geektrust;

import com.example.geektrust.entities.Command;
import com.example.geektrust.exceptions.InputErrorException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
/*    public static void main(String[] args) {
        *//*
        Sample code to read from file passed as command line argument

         *//*
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Intuit");
                FileProcesserService fileProcesserService = new FileProcesserService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InputErrorException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
