package com.myapp.cResume.dao;

import com.myapp.cResume.entity.Course;
import com.myapp.cResume.entity.Education;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface CourseRepository extends JpaRepository<Course, Long> {
    // access this function => http://localhost:8080/courses/search/findByUserId?userId=1
    List<Course> findByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE Course c SET c.name = ?#{#course.name}, " +
            "c.location = ?#{#course.location}, " +
            "c.startDate = ?#{#course.startDate}, " +
            "c.endDate = ?#{#course.endDate}, " +
            "c.description = ?#{#course.description} " +
            "WHERE c.id = :courseId AND c.user.id = :userId")
    int updateCourse(Course course, Long courseId, Long userId);


    @Transactional
    @Modifying
    @Query("DELETE Course c WHERE c.id = :courseId AND c.user.id = :userId")
    int deleteCourse(Long userId, Long courseId);





}

