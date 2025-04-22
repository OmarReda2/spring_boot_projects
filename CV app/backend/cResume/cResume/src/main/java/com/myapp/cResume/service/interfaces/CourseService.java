package com.myapp.cResume.service.interfaces;

import com.myapp.cResume.entity.Course;

public interface CourseService {

    public int updateCourse(Course course, Long courseId, Long userId);

    public int deleteCourse(Long userId, Long courseId);

    public Course addCourse(Long userId, Course course);
}