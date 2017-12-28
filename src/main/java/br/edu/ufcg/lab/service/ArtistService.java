package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.model.UserArtist;

import java.util.List;

/**
 * CRUD service for artist.
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

    /**
     * Updates an {@link Artist}
     *
     * @param artist {@link Artist to be updated}
     * @return the updated {@link Artist}
     */
    Artist update(Artist artist);

    /**
     * Returns the artist that has {@param name} as its name.
     *
     * @param name The name of the {@link Artist}
     * @return An artist that has {@param name} as name, if found. {@code null} otherwise.
     */
    Artist getByName(String name);
}
