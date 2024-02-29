package com.wsCorp.dsGameList.DTO;

import com.wsCorp.dsGameList.Entity.GameEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class GameDTO {
    private Long id;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    private Integer year;

    @NotNull
    private String imgUrl;
    @NotEmpty
    @NotNull
    private String shortDescription;

    public GameDTO() {
    }

    public GameDTO(String title, Integer year, String imgUrl, String shortDescription) {
        this.title = title;
        this.year = year;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
    }

    public GameDTO(GameEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
