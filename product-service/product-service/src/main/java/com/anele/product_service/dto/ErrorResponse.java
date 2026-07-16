package com.anele.product_service.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        String details,
        LocalDateTime timestamp
) {
}
