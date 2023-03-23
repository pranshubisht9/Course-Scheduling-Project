package com.example.geektrust.service;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.utility.CommandExeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


public class AllotCourseImplTest {
    Command command;
    CommandExecutor executor;
    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command = CommandService.getInstance().getCommandFromString("ALLOT OFFERING-JAVA-JAMES");
        executor = CommandExeFactory.getExecutor(command);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }
    @Test
    public void testExecute() {
        assertThrows(InvalidInputException.class , ()->executor.executeCommand(courses , registrationIdCourseMap , command));
    }

}
