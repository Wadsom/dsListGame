package com.wsCorp.dsGameList.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

//    @ManyToMany
//    @JoinTable(name = "tb_belonging",
//            joinColumns = @JoinColumn(name = "game_id"),inverseJoinColumns = @JoinColumn(name = "gameList_id")
//    )
//    private List<GameList>


    public GameEntity() {
    }

    public GameEntity(String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
