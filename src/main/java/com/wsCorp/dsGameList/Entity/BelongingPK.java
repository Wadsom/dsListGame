package com.wsCorp.dsGameList.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameListEntity list;

    public BelongingPK() {
    }

    public BelongingPK(GameEntity game, GameListEntity list) {
        this.game = game;
        this.list = list;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public GameListEntity getList() {
        return list;
    }

    public void setList(GameListEntity list) {
        this.list = list;
    }
}
