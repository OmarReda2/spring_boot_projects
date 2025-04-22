package com.myapp.cResume.service.interfaces;

import com.myapp.cResume.entity.Education;
import com.myapp.cResume.entity.User;

public interface EductionService {

    public int updateEducation(Education edu, Long eduId, Long userId);

    public int deleteEducation(Long userId, Long eduId);

    public User addEducation(Long userId, Education education);
}
