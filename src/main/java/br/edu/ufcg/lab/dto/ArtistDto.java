package br.edu.ufcg.lab.dto;

import br.edu.ufcg.lab.model.Artist;

public class ArtistDto {

    private Integer id;

    private String name;

    private String imageUrl;

    public ArtistDto(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.imageUrl = artist.getImageUrl();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
