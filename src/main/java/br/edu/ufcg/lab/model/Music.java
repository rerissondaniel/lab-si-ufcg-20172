package br.edu.ufcg.lab.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_music")
public class Music implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String name;

    @Column(name = "release_year")
    @NotEmpty
    private String releaseYear;

    @Transient
    private Artist artist;

    //In seconds
    @Column
    @NotNull
    private Integer duration;

    public Music() {
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(getId(), music.getId()) &&
                Objects.equals(getName(), music.getName()) &&
                Objects.equals(getReleaseYear(), music.getReleaseYear()) &&
                Objects.equals(getDuration(), music.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getReleaseYear(), getDuration());
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
