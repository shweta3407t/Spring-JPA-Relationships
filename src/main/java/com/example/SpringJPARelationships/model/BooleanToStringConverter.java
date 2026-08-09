package com.example.SpringJPARelationships.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.AttributeOverride;

public class BooleanToStringConverter implements AttributeConverter<Boolean , String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
         if(attribute){
             return  "yes";
         }else {
             return  "No";
         }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
         return  dbData.equals("yes");
    }
}
