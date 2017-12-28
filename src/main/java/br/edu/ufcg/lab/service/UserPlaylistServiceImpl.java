package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.model.Playlist;
import br.edu.ufcg.lab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlaylistServiceImpl implements UserPlaylistService {

    @Qualifier("playlistService")
    private PlaylistService playlistService;
    private UserService userService;
    private MusicService musicsService;

    @Autowired
    public UserPlaylistServiceImpl(PlaylistService playlistService, UserService userService, MusicService musicsService) {
        this.playlistService = playlistService;
        this.userService = userService;
        this.musicsService = musicsService;
    }

    @Override
    public List<Playlist> get(String userEmail) {
        return playlistService.get(userEmail);
    }

    @Override
    public Playlist update(Playlist playlist) {
        return playlistService.update(playlist);
    }

    @Override
    public Playlist create(Playlist playlist, String username) {
        User user = userService.getByUsername(username);
        playlist.setUser(user);
        return playlistService.update(playlist);
    }

    @Override
    public List<Music> getAvailableMusics(String playlistName, String username) {
        Playlist userPlaylist = playlistService.getByNameAndUser(playlistName, username);
        List<Music> availableMusics = musicsService.getAll();

        availableMusics.removeIf(userPlaylist::containsMusic);

        return availableMusics;
    }

    @Override
    public Playlist getByNameAndUser(String playlistId, String username) {
        return playlistService.getByNameAndUser(playlistId, username);
    }

    @Override
    public void delete(Integer playlistId) {
        playlistService.delete(playlistId);
    }
}
