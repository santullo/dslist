package com.gamehub.dslist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {

    private String appName;
    private String version;
    private LocalDateTime buildTime;
    private String ambiente;
    private String fullVersion;

    public String getFullVersion() {
        return version + " - " + buildTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
