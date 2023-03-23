package com.example.geektrust.service;

import com.example.geektrust.ServiceImpl.AddCourseImpl;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.utility.CommandExeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CommandExecutionFactoryTest {
    Command c1 ;
    Command c2 ;
    @BeforeEach
    public void setUp() throws InvalidInputException {
        c1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        c2 = CommandService.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }
    @Test
    public void getExecutorTest() {
       Assertions.assertTrue(CommandExeFactory.getExecutor(c1) instanceof AddCourseImpl);
       Assertions.assertFalse(CommandExeFactory.getExecutor(c2) instanceof AddCourseImpl);
    }
}
