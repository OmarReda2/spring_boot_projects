package com.myapp.cResume.dao;

import com.myapp.cResume.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUserId(@Param("userId") Long userId);
    
}
