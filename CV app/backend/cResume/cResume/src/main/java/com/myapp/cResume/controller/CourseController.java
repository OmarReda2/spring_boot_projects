package com.myapp.cResume.controller;


import com.myapp.cResume.entity.Course;
import com.myapp.cResume.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@CrossOrigin("http://localhost:4200")
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl){
        this.courseServiceImpl = courseServiceImpl;
    }

    @PutMapping("/updateCourse/{userId}/{courseId}")
    public int updateCourse(@RequestBody Course course, @PathVariable Long userId, @PathVariable Long courseId){
        return courseServiceImpl.updateCourse(course, courseId, userId);
    }

    @DeleteMapping("/deleteCourse")
    public int deleteCourse(@RequestParam("userId") Long userId,
                            @RequestParam("courseId") Long courseId){
        return courseServiceImpl.deleteCourse(userId, courseId);
    }

    @PostMapping("/addCourse/{userId}")
    public Course addCourse(@PathVariable Long userId, @RequestBody Course course){

        return courseServiceImpl.addCourse(userId, course);
    }
}
