package com.example.alpha.responses;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class AlphaResponse {
    String message;
}
