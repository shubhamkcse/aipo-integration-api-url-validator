package com.aipo.url.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlResponse {

    String urlStatus;

    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonIgnore
    private HttpHeaders httpHeaders;
}
