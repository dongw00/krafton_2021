package com.krafton.exam.common.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.krafton.exam.common.enums.ErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiRequestException extends RuntimeException {

    @ApiModelProperty(dataType = "java.util.Date", example = "2020-03-01 14:00")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timestamp;
    @ApiModelProperty(value = "Http status code", example = "BAD_REQUEST")
    private HttpStatus status;
    @ApiModelProperty(value = "Error Message", example = "Invalid JSON format")
    private String errorMessage;
    @ApiModelProperty(value = "Error Code", example = "1100")
    private Integer errorCode;

    private ApiRequestException() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiRequestException(HttpStatus status, String errorMessage) {
        this();
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ApiRequestException(ErrorCode code) {
        this();
        this.errorCode = code.getCode();
        this.status = code.getStatus();
        this.errorMessage = code.getMessage();
    }
}
