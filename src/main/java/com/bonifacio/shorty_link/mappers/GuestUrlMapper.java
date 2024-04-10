package com.bonifacio.shorty_link.mappers;

import com.bonifacio.shorty_link.dtos.GuestUrlInDto;
import com.bonifacio.shorty_link.entities.GuestUrl;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuestUrlMapper {
    GuestUrlMapper INSTANCE = Mappers.getMapper(GuestUrlMapper.class);

    GuestUrl guestUrlInDtoToGuestUrl(GuestUrlInDto guestUrlInDto);
}
