package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.UserArtist;

public interface UserArtistService {

    UserArtist get(String artistName, String username);

    void createOrUpdate(UserArtist userArtist);

}
