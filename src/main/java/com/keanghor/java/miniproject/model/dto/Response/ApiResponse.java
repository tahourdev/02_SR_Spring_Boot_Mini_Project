package com.keanghor.java.miniproject.model.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private Boolean success;
    private String message;
    @JsonProperty("status")
    private HttpStatus status;
    private T payload;
    @JsonProperty("timestamps")
    private Instant instant;
}