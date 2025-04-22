package com.myapp.cResume.dao;

import com.myapp.cResume.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface EducationRepository extends JpaRepository<Education, Long> {

    // access this function => http?//localhost?8080/educations/search/findByUserId?userId=1
    List<Education> findByUserId(@Param("userId") Long userId);


    // // ? positional param, : named param
    @Transactional
    @Modifying
    @Query("UPDATE Education e SET e.name = ?#{#edu.name}, " +
            "e.location = ?#{#edu.location}, " +
            "e.grade = ?#{#edu.grade}, " +
            "e.gpa = ?#{#edu.gpa}, " +
            "e.startDate = ?#{#edu.startDate}, " +
            "e.endDate = ?#{#edu.endDate}, " +
            "e.description = ?#{#edu.description} " +
            "WHERE e.id = :eduId AND e.user.id = :userId")
    int updateEducation(Education edu, Long eduId, Long userId);

   @Transactional
   @Modifying
   @Query("DELETE Education e WHERE e.user.id = :userId AND e.id = :eduId")
    int deleteEduction(Long userId, Long eduId);
}
