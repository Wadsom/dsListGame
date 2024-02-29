package com.wsCorp.dsGameList.Repository;

import com.wsCorp.dsGameList.Entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT game.title FROM tb_game AS game WHERE game.title = :title ")
    String searchByName(String title);


}
