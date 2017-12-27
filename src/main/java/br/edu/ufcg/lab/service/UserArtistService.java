package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.UserArtist;

public interface RatingService {

    UserArtist get(String artistName, Integer idUser);

    void createOrUpdate(UserArtist userArtist);

}
