package com.gamehub.dslist.entities;

import jakarta.persistence.*;
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
@Table(name = "TB_GAME")
public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "GAME_YEAR")
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

}
