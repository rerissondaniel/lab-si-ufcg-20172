package br.edu.ufcg.lab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rating;

    @OneToOne
    private Artist artist;

    @ManyToOne
    private User user;

    public Rating() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(getId(), rating1.getId()) &&
                Objects.equals(getRating(), rating1.getRating()) &&
                Objects.equals(getArtist(), rating1.getArtist()) &&
                Objects.equals(getUser(), rating1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRating(), getArtist(), getUser());
    }
}
