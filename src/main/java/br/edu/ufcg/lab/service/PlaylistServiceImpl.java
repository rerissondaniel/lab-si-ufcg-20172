package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Playlist;
import br.edu.ufcg.lab.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService {


    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> get(String username) {
        return playlistRepository.findByUserUsername(username);
    }

    @Override
    public Playlist update(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getByNameAndUser(String playlistName, String username) {
        return playlistRepository.findByNameAndUserUsername(playlistName, username);
    }

    @Override
    public void delete(Integer playlistId) {
        playlistRepository.delete(playlistId);
    }
}
