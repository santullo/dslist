package com.gamehub.dslist.controllers;

import com.gamehub.dslist.dto.GameDTO;
import com.gamehub.dslist.dto.GameMinDTO;
import com.gamehub.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }
}
