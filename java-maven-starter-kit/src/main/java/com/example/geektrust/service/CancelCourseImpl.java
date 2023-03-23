package com.example.geektrust.service;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import java.util.Map;
import java.util.TreeMap;
import static com.example.geektrust.utility.FixedConstants.CANCEL_ACCEPTED;
import static com.example.geektrust.utility.FixedConstants.CANCEL_REJECTED;

public class CancelCourseImpl implements CommandExecutor{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) {
        String regId = command.getCommandParams().get(0);
        if(isValidRegistrationID(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId+" "+CANCEL_REJECTED);
            }else{
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+CANCEL_ACCEPTED);
            }
        }else{
            System.out.println(regId+" "+CANCEL_REJECTED);
        }
    }
    private void removeRegisteredEmployee(String regId, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(regId);
        course.getRegisterEmployees().remove(regId);
        registrationIdCourseMap.remove(regId);
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
