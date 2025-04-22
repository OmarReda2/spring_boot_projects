package com.myapp.cResume.controller;

import com.myapp.cResume.entity.Education;
import com.myapp.cResume.entity.User;
import com.myapp.cResume.service.EducationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educations")
@CrossOrigin("http://localhost:4200")
public class EducationController {


    private EducationServiceImpl educationServiceImpl;

    @Autowired
    public EducationController(EducationServiceImpl educationServiceImpl) {
        this.educationServiceImpl = educationServiceImpl;
    }

    @PutMapping("/updateEducation")
    public int updateEducation(@RequestBody Education edu,
                               @RequestParam Long eduId,
                               @RequestParam Long userId){
        return educationServiceImpl.updateEducation(edu, eduId, userId);
    }

    @DeleteMapping("/deleteEducation")
    public int deleteEducation(@RequestParam("userId") Long userId,
                               @RequestParam("eduId") Long eduId){
        return educationServiceImpl.deleteEducation(userId,eduId);
    }

    @PostMapping("/addEducation")
    public User addEducation(@RequestParam("userId") Long userId,
                             @RequestBody Education edu){
        return educationServiceImpl.addEducation(userId, edu);
    }

}
