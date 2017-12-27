package br.edu.ufcg.lab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_user_artist")
public class UserArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rating;

    @OneToOne
    private Music lastHeard;

    @OneToOne(cascade = CascadeType.MERGE)
    private Artist artist;

    @OneToOne
    private User user;

    public UserArtist() {
    }

    public UserArtist(Artist artist, User user) {
        this.artist = artist;
        this.user = user;
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

    public Music getLastHeard() {
        return lastHeard;
    }

    public void setLastHeard(Music lastHeard) {
        this.lastHeard = lastHeard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserArtist that = (UserArtist) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getRating(), that.getRating()) &&
                Objects.equals(getLastHeard(), that.getLastHeard()) &&
                Objects.equals(getArtist(), that.getArtist()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRating(), getLastHeard(), getArtist(), getUser());
    }
}
