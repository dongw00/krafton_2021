package com.krafton.exam.vacation.model;

import com.krafton.exam.vacation.enums.VacationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "vacation_record")
public class VacationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", nullable = false, updatable = false)
    private Long accountId;

    @Column(name = "vacation_cnt", nullable = false, updatable = false)
    private Float vacationCnt;

    @Column(name = "type", nullable = false, updatable = false)
    @Convert(converter = VacationType.class)
    private VacationType type;

    @Column(name = "flag", nullable = false)
    private Boolean flag;

    @Column(name = "start_date", nullable = false, updatable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false, updatable = false)
    private LocalDateTime endDate;

    @CreationTimestamp
    @Column(name = "created_date", insertable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

//    @Builder
//    public VacationRecord(Long accountId, Float vacationCnt, VacationRecord type,)
}
