package com.example.geektrust.Utilities;

import com.example.geektrust.entities.Command;
import com.example.geektrust.service.*;

public class CommandExeFactory {
    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ALLOT:
                    executor = new AllotedCourseImpl();
                    break;
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
