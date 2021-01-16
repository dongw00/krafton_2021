package com.krafton.exam.vacation.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "vacation_info")
public class VacationInfo {

    @Id
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "total_vacation_cnt", nullable = false)
    private Float totalVacationCnt;

    @Column(name = "use_vacation_cnt", nullable = false)
    private Float useVacationCnt;
}
