package com.wsCorp.dsGameList.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.wsCorp.dsGameList.DTO.GameDTO;
import com.wsCorp.dsGameList.Entity.GameEntity;
import com.wsCorp.dsGameList.Repository.GameRepository;
import com.wsCorp.dsGameList.Service.Exceptions.DatabaseException;
import com.wsCorp.dsGameList.Service.Exceptions.GameNotFoundException;
import org.springframework.beans.BeanUtils;
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
        return resultEntities.stream().map(GameDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO getOne(Long id) throws Exception {
        try {
            Optional<GameEntity> entity = gameRepo.findById(id);
            GameEntity game = entity.orElseThrow(() -> new GameNotFoundException("Game not found!"));
            return new GameDTO(game);
        } catch (DatabaseException e) {
            throw new DatabaseException("Integration Violation");
        }
    }

    @Transactional
    public GameDTO postMethod(GameDTO dto) {
        String title = gameRepo.searchByName(dto.getTitle());
        if (title != null) throw new DatabaseException("Game exist");
        GameEntity gameEntity = new GameEntity();
        BeanUtils.copyProperties(dto, gameEntity);
        gameEntity = gameRepo.save(gameEntity);
        return new GameDTO(gameEntity);
    }

}
