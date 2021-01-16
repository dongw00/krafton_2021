package com.krafton.exam.vacation.controller;

import com.krafton.exam.common.exceptions.CustomRequestException;
import com.krafton.exam.vacation.dto.response.CurrentVacationInfo;
import com.krafton.exam.vacation.service.VacationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Vacation")
@RestController
@RequestMapping("/vacation")
@RequiredArgsConstructor
public class VacationApiController {

    // 현재 접속된 계정 (Spring security에서 get) - 지금은 1번 고정
    final Long accountId = 1L;
    private final VacationService vacationService;

    @ApiOperation(value = "휴가 정보")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CurrentVacationInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = CustomRequestException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = CustomRequestException.class)})
    @GetMapping("/info")
    public ResponseEntity<?> getVacationInfo() {
        return ResponseEntity.ok().body(vacationService.currentVacationInfo(accountId));
    }

    @ApiOperation(value = "휴가 정보")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses({@ApiResponse(code = 204, message = "No Content", response = Void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = CustomRequestException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = CustomRequestException.class)})
    @PostMapping
    public ResponseEntity<?> applyVacation() {

        return ResponseEntity.noContent().build();
    }
}
