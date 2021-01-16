package com.krafton.exam.vacation.service;

import com.krafton.exam.common.exceptions.ApiRequestException;
import com.krafton.exam.vacation.dto.response.CurrentVacationInfo;
import com.krafton.exam.vacation.model.VacationInfo;
import com.krafton.exam.vacation.repository.VacationInfoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.krafton.exam.common.enums.ErrorCode.NOT_EXISTS_ACCOUNT;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacationService {

    private final VacationInfoRepo vacationInfoRepo;

    /**
     * 계정 휴가정보 조회
     *
     * @param accountId 계정 ID
     * @return
     */
    public CurrentVacationInfo currentVacationInfo(final Long accountId) {
        VacationInfo info = vacationInfoRepo.findById(accountId).orElseThrow(() -> new ApiRequestException(NOT_EXISTS_ACCOUNT));
        return CurrentVacationInfo.builder()
                .totalVacationCnt(info.getTotalVacationCnt())
                .useVacationCnt(info.getUseVacationCnt())
                .build();
    }

    public void applyVacation(final Long accountId) {

    }
}
