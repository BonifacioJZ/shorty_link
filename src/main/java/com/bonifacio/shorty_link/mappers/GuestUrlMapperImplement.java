package com.bonifacio.shorty_link.mappers;

import com.bonifacio.shorty_link.dtos.GuestUrlInDto;
import com.bonifacio.shorty_link.entities.GuestUrl;
import org.springframework.stereotype.Component;

@Component
public class GuestUrlMapperImplement implements GuestUrlMapper{
    @Override
    public GuestUrl guestUrlInDtoToGuestUrl(GuestUrlInDto guestUrlInDto) {
        if(guestUrlInDto == null) return null;

        GuestUrl outGUrl = new GuestUrl();
        outGUrl.setLink(guestUrlInDto.url());
        return outGUrl;
    }
}
