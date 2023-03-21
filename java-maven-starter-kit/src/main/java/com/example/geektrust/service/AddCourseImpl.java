package com.example.geektrust.service;

import com.example.geektrust.entities.Command;
import com.example.geektrust.entities.Course;
import com.example.geektrust.exceptions.CourseException;
import com.example.geektrust.exceptions.InputErrorException;

import java.util.Map;
import java.util.TreeMap;

public class AddCourseImpl implements CommandExecutor{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InputErrorException, CourseException {

    }
}
