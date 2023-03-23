package com.example.geektrust.utility;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.*;

public class CommandExeFactory {
    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseImpl();
                    break;
                case ALLOT:
                    executor = new AllotedCourseImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
