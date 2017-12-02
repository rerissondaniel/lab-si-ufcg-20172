package br.edu.ufcg.lab.dto;

import br.edu.ufcg.lab.model.Artist;

public class ArtistDto {

    private Integer id;

    private String name;

    public ArtistDto(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
