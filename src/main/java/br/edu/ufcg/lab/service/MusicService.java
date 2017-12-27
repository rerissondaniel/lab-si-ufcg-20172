package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Album;
import br.edu.ufcg.lab.model.Music;

public interface MusicService {

    /**
     * Adds a music to an album.
     * If the album doesn't exist, it will be created;
     *
     * @param music {@link Music} to be added.
     * @param album {@link Album} to which the music will be added.
     */
    void add(Music music, Album album);
}
