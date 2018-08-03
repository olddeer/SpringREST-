package at.bitmedia.schoolreader.configure;

import at.bitmedia.schoolreader.entity.TypeTask;

import javax.persistence.AttributeConverter;

public class CustomConverterType implements AttributeConverter<TypeTask, String> {

    @Override
    public String convertToDatabaseColumn(TypeTask attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getName();
    }

    @Override
    public TypeTask convertToEntityAttribute(String dbData) {
        return TypeTask.valueOf(dbData);
    }

}