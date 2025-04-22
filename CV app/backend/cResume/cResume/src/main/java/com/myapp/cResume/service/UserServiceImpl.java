package com.myapp.cResume.service;

import com.myapp.cResume.dao.UserRepository;
import com.myapp.cResume.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    @Transactional
//    public int updateUser(User user, Long id){
//        return userRepository.updateUser(user, id);
//    }

//    @Transactional
//    public User updateUser(String userName, Long id){
//        return userRepository.updateUser(userName, id);
//    }
}
