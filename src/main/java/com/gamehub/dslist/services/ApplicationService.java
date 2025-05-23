package com.gamehub.dslist.services;

import com.gamehub.dslist.dto.ApplicationDTO;
import com.gamehub.dslist.enums.AmbienteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ApplicationService {

    private final BuildProperties buildProperties;
    private final Environment environment;

    @Autowired
    public ApplicationService(BuildProperties buildProperties, Environment environment) {
        this.buildProperties = buildProperties;
        this.environment = environment;
    }

    public ApplicationDTO getStatus() {
        return ApplicationDTO.builder()
                .appName("DSLIST")
                .version(buildProperties.getVersion())
                .buildTime(LocalDateTime.ofInstant(buildProperties.getTime(), ZoneId.of("America/Sao_Paulo")))
                .ambiente(AmbienteEnum.getDescricaoFromSigla(environment.getActiveProfiles()[0]))
                .build();
    }
}
