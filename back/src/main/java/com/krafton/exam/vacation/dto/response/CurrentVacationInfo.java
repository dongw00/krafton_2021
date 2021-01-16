package com.krafton.exam.vacation.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrentVacationInfo {

    @ApiModelProperty(name = "보유연차 (일)", example = "15")
    private float totalVacationCnt;

    @ApiModelProperty(name = "사용연차 (일)", example = "5")
    private float useVacationCnt;

    @ApiModelProperty(name = "잔여연차 (일)", example = "10")
    private float restVacationCnt;

    @Builder
    public CurrentVacationInfo(float totalVacationCnt, float useVacationCnt) {
        this.totalVacationCnt = totalVacationCnt;
        this.useVacationCnt = useVacationCnt;
        this.restVacationCnt = totalVacationCnt - useVacationCnt;
    }
}
