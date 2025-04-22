package com.myapp.cResume.service.interfaces;

import com.myapp.cResume.entity.Link;

public interface LinkService {

    public int updateLinkByUserId(Link link, Long urlId, Long userId);
}
