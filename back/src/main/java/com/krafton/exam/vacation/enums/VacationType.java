package com.krafton.exam.vacation.enums;

import com.krafton.exam.common.converter.AbstractEnumType;
import com.krafton.exam.common.converter.AbstractEnumTypeConverter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VacationType implements AbstractEnumType {

    ALL_DAY("all_day", "연차"), HALF_DAY("half_day", "반차");

    private final String code;
    private final String description;

    public static class Converter extends AbstractEnumTypeConverter<VacationType> {
        public Converter() {
            super(VacationType.class);
        }
    }
}