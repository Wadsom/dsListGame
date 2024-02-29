package com.wsCorp.dsGameList.Service;

import com.wsCorp.dsGameList.DTO.GameDTO;
import com.wsCorp.dsGameList.Entity.GameEntity;
import com.wsCorp.dsGameList.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    @Transactional(readOnly = true)
    public List<GameDTO> getAll() {
        List<GameEntity> resultEntities = gameRepo.findAll();
        List<GameDTO> result = resultEntities.stream().map(GameDTO::new).toList();
        return result;
    }

}
