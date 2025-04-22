package com.myapp.cResume.service;

import com.myapp.cResume.dao.CourseRepository;
import com.myapp.cResume.dao.UserRepository;
import com.myapp.cResume.entity.Course;
import com.myapp.cResume.entity.User;
import com.myapp.cResume.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             UserRepository userRepository){

        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public int updateCourse(Course course, Long courseId, Long userId){
        return courseRepository.updateCourse(course, courseId, userId);
    }

    @Override
    public int deleteCourse(Long userId, Long courseId){
        return courseRepository.deleteCourse(userId,courseId);
    }

    @Override
    @Transactional
    public Course addCourse(Long userId,Course course){
        Optional<User> user = userRepository.findById(userId);
        user.get().add(course);

        return courseRepository.save(course);
    }


}
