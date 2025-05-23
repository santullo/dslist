package com.gamehub.dslist.services;

import com.gamehub.dslist.dto.GameDTO;
import com.gamehub.dslist.dto.GameMinDTO;
import com.gamehub.dslist.entities.Game;
import com.gamehub.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(GameMinDTO::new).toList();
    }

    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).orElse(null);

        if (Objects.isNull(game)) return null;

        return new GameDTO(game);
    }
}
