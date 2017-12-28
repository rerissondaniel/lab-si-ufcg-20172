package br.edu.ufcg.lab.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_playlist")
public class Playlist {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotEmpty
    private String name;

    @ManyToMany
    @JoinTable(name = "tb_music_playlist",
            joinColumns = @JoinColumn(name = "id_playlist", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_music", referencedColumnName = "id"))
    private List<Music> musics;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Playlist() {
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

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(getId(), playlist.getId()) &&
                Objects.equals(getName(), playlist.getName()) &&
                Objects.equals(getMusics(), playlist.getMusics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMusics());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean containsMusic(Music music) {
        return musics.contains(music);
    }
}
