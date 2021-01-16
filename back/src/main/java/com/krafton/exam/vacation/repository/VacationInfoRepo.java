package com.krafton.exam.vacation.repository;

import com.krafton.exam.vacation.model.VacationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationInfoRepo extends JpaRepository<VacationInfo, Long> {
}
