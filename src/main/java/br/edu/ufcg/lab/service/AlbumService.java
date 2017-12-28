package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Music;

public interface AlbumService {
    void addMusic(String albumName, Music music);
}
