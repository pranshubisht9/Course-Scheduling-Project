package com.example.geektrust.ServiceImpl;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.service.CommandExecutor;

import java.util.Map;
import java.util.TreeMap;

import static com.example.geektrust.utility.Constants.CANCEL_ACCEPTED;
import static com.example.geektrust.utility.Constants.CANCEL_REJECTED;

public class CancelCourseImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) {
        String regId = command.getCommandParams().get(0);
        if(isValidRegistrationID(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId+" "+CANCEL_REJECTED);
            }else{
                    //remove the registration
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+CANCEL_ACCEPTED);
            }
        }else{
            System.out.println(regId+" "+CANCEL_REJECTED);
        }
    }

    private void removeRegisteredEmployee(String id, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(id);
        course.getRegisterEmployees().remove(id);
        registrationIdCourseMap.remove(id);
    }
    private boolean isCourseNotAllotted(String regId, Map<String, Course> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isAllotted();
    }
    private boolean isValidRegistrationID(String regId, Map<String, Course> registrationIdCourseMap) {
        if(registrationIdCourseMap.get(regId)!=null){
            return true;
        }else{
            return false;
        }
    }
}
