package com.wsCorp.dsGameList.Resource;

import com.wsCorp.dsGameList.DTO.GameDTO;
import com.wsCorp.dsGameList.Repository.GameRepository;
import com.wsCorp.dsGameList.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameResource {
    @Autowired
    private GameService gameServ;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        List<GameDTO> result = gameServ.getAll();
        return ResponseEntity.ok().body(result);
    }
}
