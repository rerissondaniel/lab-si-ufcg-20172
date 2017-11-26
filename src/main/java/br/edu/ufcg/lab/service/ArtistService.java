package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Artist;

import java.util.List;

/**
 * CRUD service for artist
 */
public interface ArtistService {

    /**
     * Creates an artist.
     *
     * @param artist {@link Artist} to be created.
     * @return A created {@link Artist}, with an Id.
     */
    Artist create(Artist artist);

    /**
     * @return all the artists of the system.
     */
    List<Artist> getAll();
}
