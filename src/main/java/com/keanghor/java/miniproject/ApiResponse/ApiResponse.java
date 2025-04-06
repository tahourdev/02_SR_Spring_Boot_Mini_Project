package com.keanghor.java.miniproject.ApiResponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private Boolean success;
    private String messsage;
    private HttpStatus status;
    private T payload;
    private LocalDateTime timestamps;
}
