package com.bonifacio.shorty_link.dtos;

import lombok.Builder;

@Builder
public record CustomResponse<T>(
        String message,
        String status,
        boolean success,
        T data
) {
}
