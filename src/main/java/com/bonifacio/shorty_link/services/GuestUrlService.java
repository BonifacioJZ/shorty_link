package com.bonifacio.shorty_link.services;

import com.bonifacio.shorty_link.dtos.GuestUrlInDto;
import com.bonifacio.shorty_link.entities.GuestUrl;

public interface GuestUrlService {
    GuestUrl saveGuestUrl(GuestUrlInDto guestUrlInDto);
    GuestUrl findBySlug(String slug);
}
