package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService{

    private ArtistRepository repository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Artist create(Artist artist) {
        Artist createdArtist = this.repository.save(artist);
        return createdArtist;
    }
}
