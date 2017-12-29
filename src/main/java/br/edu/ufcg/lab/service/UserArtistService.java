package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.UserArtist;

import java.util.List;

public interface UserArtistService {

    List<UserArtist> getAll(String username);

    UserArtist get(String artistName, String username);

    void createOrUpdate(UserArtist userArtist);

}
