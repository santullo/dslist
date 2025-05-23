package com.gamehub.dslist.convertes;

import com.gamehub.dslist.enums.AmbienteEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AmbienteEnumConverter implements AttributeConverter<AmbienteEnum, String> {

    @Override
    public String convertToDatabaseColumn(AmbienteEnum atributoSigla) {
        return atributoSigla != null ? atributoSigla.getSigla() : null;
    }

    @Override
    public AmbienteEnum convertToEntityAttribute(String atributoSigla) {
        return AmbienteEnum.getEnumFromSigla(atributoSigla);
    }
}
