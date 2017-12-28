package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.model.Playlist;

import java.util.List;

public interface UserPlaylistService extends PlaylistService{

    Playlist create(Playlist playlist, String userName);

    List<Music> getAvailableMusics(String playlistName, String username);
}
