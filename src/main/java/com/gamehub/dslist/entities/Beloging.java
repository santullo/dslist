package com.gamehub.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_BELONGING")
public class Beloging implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BelogingPK id = new BelogingPK();
    private Integer position;
}
