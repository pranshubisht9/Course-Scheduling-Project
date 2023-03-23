package com.example.geektrust.service;

import com.example.geektrust.model.Command;
import com.example.geektrust.exception.InputErrorException;

import java.io.*;

public class FileProcesserService {
    private File file;
    private BufferedReader reader;

    public FileProcesserService(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        reader = new BufferedReader(new FileReader(file));
    }


    public Command processLine() throws IOException, InputErrorException  {
        String inputString = reader.readLine();
        if(inputString == null){
            return null;
        }
        if(isEmpty(inputString)){
            processLine();
        }
        try{
            return CommandService.getInstance().getCommandFromString(inputString);
        }catch(InputErrorException e){
            System.out.println(e.getMessage());
            return processLine();
        }
    }
    private boolean isEmpty(String line) {
        return line==null || line.length()==0 || line.trim().isEmpty() || line.trim().startsWith("#");
    }
}
