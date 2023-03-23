package com.example.geektrust.utility;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.exception.InputErrorException;
import com.example.geektrust.service.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LMS {
    private final String organisationName;
    private final TreeMap<String , Course> courses;
    private final Map<String, Course> registrationIdCourseMap;

    public LMS(String name) {
        this.organisationName = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InputErrorException {
        CommandExecutor commandExecutor = CommandExeFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseException e ){
            System.out.println(e.getMessage());
        }
    }
}
