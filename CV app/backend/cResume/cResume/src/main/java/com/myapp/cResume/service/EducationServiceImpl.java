package com.myapp.cResume.service;

import com.myapp.cResume.dao.EducationRepository;
import com.myapp.cResume.dao.UserRepository;
import com.myapp.cResume.entity.Education;
import com.myapp.cResume.entity.User;
import com.myapp.cResume.service.interfaces.EductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements EductionService {

    private EducationRepository educationRepository;
    private UserRepository userRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository,
                                UserRepository userRepository) {
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public int updateEducation(Education edu, Long eduId, Long userId){
        return educationRepository.updateEducation(edu, eduId, userId);
    }

    @Override
    public int deleteEducation(Long userId, Long eduId){
        return educationRepository.deleteEduction(userId,eduId);
    }

    @Override
    public User addEducation(Long userId, Education edu){
        Optional<User> user =  userRepository.findById(userId);
        user.get().add(edu);

        return userRepository.save(user.get());
    }
}
