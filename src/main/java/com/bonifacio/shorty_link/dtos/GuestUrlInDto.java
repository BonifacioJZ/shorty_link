package com.bonifacio.shorty_link.dtos;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record GuestUrlInDto(
        @Lob
        @NotBlank
        @NotEmpty
        String url
){

}
