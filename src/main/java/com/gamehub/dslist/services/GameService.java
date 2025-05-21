package com.gamehub.dslist.services;

import com.gamehub.dslist.dto.GameMinDTO;
import com.gamehub.dslist.entities.Game;
import com.gamehub.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        List<GameMinDTO> listDto = new ArrayList<>();

        if (!list.isEmpty()) {
            listDto = list.stream().map(GameMinDTO::new).toList();
        }

        return listDto;
    }

    public GameMinDTO findById(Long id) {
        Game game = gameRepository.findById(id).orElse(null);

        if (game == null) {
            return null;
        }

        return new GameMinDTO(game);
    }
}
