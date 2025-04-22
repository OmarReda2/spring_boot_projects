package com.myapp.cResume.dao;

import com.myapp.cResume.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface LinkRepository extends JpaRepository<Link, Long> {

    // access this function => http://localhost:8080/links/search/findByUserId?userId=1
    List<Link> findByUserId(@Param("userId") Long userId);


    @Modifying
    @Transactional
    // @Query("UPDATE Link l SET l=?1 WHERE l.id=?2 AND l.user.id=?3")
    // // we will use "SpEL" #{}
    @Query("UPDATE Link l SET l.name = :#{#link.name}, l.url = :#{#link.url} WHERE l.id = :urlId AND l.user.id = :userId")
    int updateLinkByUserId(Link link, Long urlId, Long userId);
}
