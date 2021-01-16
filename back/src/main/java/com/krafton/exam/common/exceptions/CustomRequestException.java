package com.krafton.exam.common.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

import static com.krafton.exam.common.enums.ErrorCode.ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public class CustomRequestException {

    @ApiModelProperty(value = "Http status code", example = "BAD_REQUEST")
    private HttpStatus status;

    @ApiModelProperty(value = "Error Code", example = "1100")
    private Integer errorCode;

    @ApiModelProperty(value = "Error Message", example = "Invalid JSON format")
    private String errorMessage;

    @ApiModelProperty(dataType = "java.util.Date", example = "2020-03-01 14:00")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    private CustomRequestException() {
        this.timestamp = LocalDateTime.now();
    }

    public CustomRequestException(ApiRequestException e) {
        this();
        this.status = e.getStatus();
        this.errorCode = e.getErrorCode();
        this.errorMessage = e.getErrorMessage();
    }

    public CustomRequestException(RuntimeException e) {
        this();
        this.status = BAD_REQUEST;
        this.errorCode = 100;
        this.errorMessage = e.getMessage();
    }

    public CustomRequestException(MethodArgumentNotValidException e) {
        this();
        this.status = BAD_REQUEST;
        this.errorCode = 101;
        this.errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }

    public CustomRequestException(Exception e) {
        this();
        this.status = ERROR.getStatus();
        this.errorCode = ERROR.getCode();
        this.errorMessage = e.getMessage();
    }
}
