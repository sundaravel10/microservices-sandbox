package com.example.alpha.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Schema(description = "API Response")
public class AlphaResponse {
    @Schema(description = "Response message")
    String message;
}
