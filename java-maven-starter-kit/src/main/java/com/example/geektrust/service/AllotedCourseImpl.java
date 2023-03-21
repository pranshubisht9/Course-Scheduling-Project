package com.example.geektrust.service;

import com.example.geektrust.entities.Command;
import com.example.geektrust.entities.Course;
import com.example.geektrust.exceptions.CourseException;
import com.example.geektrust.exceptions.InputErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AllotedCourseImpl implements CommandExecutor{

    private Course constructCourseObject(List<String> params) throws InputErrorException {
        Course course = null;
        try{
            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = inputFormat.parse(params.get(2));
            long min_count = Integer.parseInt(params.get(3));
            long max_count = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , date ,min_count , max_count , false, false);
        }catch (Exception e){
            throw new InputErrorException("INPUT_ERROR");
        }
        return course;
    }

    private void offerCourse(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseId(),course);
        System.out.println(course.getCourseId());
    }
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InputErrorException, CourseException {
        List<String> params = command.getCommandParams();
        Course course = constructCourseObject(params);
        offerCourse(courses , course);
    }
}
