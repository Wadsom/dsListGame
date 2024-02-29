package com.wsCorp.dsGameList.Resource;

import com.wsCorp.dsGameList.DTO.GameDTO;
import com.wsCorp.dsGameList.Repository.GameRepository;
import com.wsCorp.dsGameList.Service.GameService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findOne(@PathVariable @Valid Long id) throws Exception {
        GameDTO dto = gameServ.getOne(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<GameDTO> insert(@RequestBody GameDTO dto) {
        dto = gameServ.postMethod(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
