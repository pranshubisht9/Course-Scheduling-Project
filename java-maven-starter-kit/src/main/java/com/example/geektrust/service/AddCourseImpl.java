package com.example.geektrust.service;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.exception.InputErrorException;

import java.util.Map;
import java.util.TreeMap;

public class AddCourseImpl implements CommandExecutor{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InputErrorException, CourseException {

    }
}
