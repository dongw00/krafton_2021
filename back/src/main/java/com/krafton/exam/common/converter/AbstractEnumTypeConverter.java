package com.krafton.exam.common.converter;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

@RequiredArgsConstructor
public class AbstractEnumTypeConverter<E extends Enum<E> & AbstractEnumType> implements AttributeConverter<E, String> {

    private final Class<E> targetEnumClass;

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return (attribute == null || Strings.isEmpty(attribute.getCode())) ? null : attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(targetEnumClass).stream().filter(v -> v.getCode().equals(dbData)).findAny().orElse(null);
    }
}
