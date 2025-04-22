package com.myapp.cResume.controller;

import com.myapp.cResume.entity.Link;
import com.myapp.cResume.service.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
@CrossOrigin("http://localhost:4200")
public class LinkController {


    private LinkServiceImpl linkServiceImpl;

    @Autowired
    public LinkController(LinkServiceImpl linkServiceImpl){
        this.linkServiceImpl = linkServiceImpl;
    }

    @PutMapping("/updateLinkByUserId")
    public int updateLink(@RequestBody Link link,
                           @RequestParam Long urlId,
                           @RequestParam Long userId) {
        return linkServiceImpl.updateLinkByUserId(link, urlId, userId);
    }

}
