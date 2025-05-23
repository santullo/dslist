package com.gamehub.dslist.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum AmbienteEnum {
    DESENVOLVIMENTO('D', "dev", "Desenvolvimento"),
    HOMOLOGACAO('H', "hom", "Homologação"),
    PRODUCAO('P', "prod", "Produção");

    @JsonValue
    private final Character letra;
    private final String sigla;
    private final String descricao;

    AmbienteEnum(Character letra, String sigla, String descricao) {
        this.letra = letra;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public static AmbienteEnum getEnumFromLetra(String letra) {
        return Arrays.stream(AmbienteEnum.values())
                .filter(v -> letra.equals(v.getSigla()))
                .findFirst()
                .orElse(null);
    }

    @JsonCreator
    public static AmbienteEnum getEnumFromSigla(String sigla) {
        return Arrays.stream(AmbienteEnum.values())
                .filter(v -> sigla.equals(v.getSigla()))
                .findFirst()
                .orElse(null);
    }

    public static AmbienteEnum getEnumFromDescricao(String descricao) {
        return Arrays.stream(AmbienteEnum.values())
                .filter(v -> descricao.equals(v.getDescricao()))
                .findFirst()
                .orElse(null);
    }

    public static String getDescricaoFromSigla(String sigla) {
        AmbienteEnum ambiente = Arrays.stream(AmbienteEnum.values())
                .filter(v -> sigla.equals(v.getSigla()))
                .findFirst()
                .orElse(null);
        return Objects.nonNull(ambiente) ? ambiente.getDescricao() : "";
    }
}
