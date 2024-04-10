package com.bonifacio.shorty_link.services;

import com.bonifacio.shorty_link.dtos.GuestUrlInDto;
import com.bonifacio.shorty_link.entities.GuestUrl;
import com.bonifacio.shorty_link.mappers.GuestUrlMapper;
import com.bonifacio.shorty_link.repositories.GuestUrlRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuestUrlServiceImplement implements GuestUrlService{

    @Autowired
    private final UrlEncodeService urlEncodeService;
    @Autowired
    private final GuestUrlRepository guestUrlRepository;
    @Autowired
    private final GuestUrlMapper guestUrlMapper;

    @Override
    public GuestUrl saveGuestUrl(GuestUrlInDto guestUrlInDto) {
        var url = guestUrlMapper.guestUrlInDtoToGuestUrl(guestUrlInDto);
        if(url == null){
            return null;
        }
        url.setSlug(urlEncodeService.hash(url.getLink()));
        return guestUrlRepository.save(url);
    }

    @Override
    public GuestUrl findBySlug(String slug) {
        if(StringUtils.isEmpty(slug)){
            return null;
        }
        return  guestUrlRepository.findBySlug(slug);

    }
}
