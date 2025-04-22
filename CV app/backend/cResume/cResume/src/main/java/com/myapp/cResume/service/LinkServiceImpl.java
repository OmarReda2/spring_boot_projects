package com.myapp.cResume.service;

import com.myapp.cResume.dao.LinkRepository;
import com.myapp.cResume.entity.Link;
import com.myapp.cResume.service.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }


    @Override
    public int updateLinkByUserId(Link link, Long urlId, Long userId){
      return  linkRepository.updateLinkByUserId(link, urlId, userId);
    }
}
