package com.example.geektrust.service;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.exception.InputErrorException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class AllotedCourseImpl implements CommandExecutor{

        @Override
        public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws  InputErrorException {
            String courseId = command.getCommandParams().get(0);
            Course course = courses.get(courseId);
            if(course!=null){
                if(course.getRegisterEmployees().size()<course.getMinCapacity()){
                    course.setCancel(true);
                    printCourseData(course);
                }else{
                    course.setAllotted(true);
                    printCourseData(course);
                }
            }else{
                throw new InputErrorException("INPUT_DATA_ERROR");
            }
        }

        private void printCourseData(Course course) {
            String status = course.isCancel()?"COURSE_CANCELED":"CONFIRMED";
            for(Map.Entry<String, Employee> e: course.getRegisterEmployees().entrySet()){
                String pattern = "ddMMyyyy";
                DateFormat df = new SimpleDateFormat(pattern);
                System.out.println(e.getKey()+" "+e.getValue().getEmail()+" "+course.getCourseName()+" "+course.getCourseName()+" "+course.getInstructor()+" "
                        + df.format(course.getDate())+" "+status);
            }
        }
}
