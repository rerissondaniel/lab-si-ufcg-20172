package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Playlist;

import java.util.List;

public interface PlaylistService {

    List<Playlist> get(String userEmail);

    Playlist update(Playlist playlist);

    Playlist getByNameAndUser(String playlist, String username);

    void delete(Integer playlistId);
}
