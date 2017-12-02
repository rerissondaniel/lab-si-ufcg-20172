package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository repository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Artist create(Artist artist) {
        return this.repository.save(artist);
    }

    @Override
    public List<Artist> getAll() {
        return repository.findAll();
    }

    @Override
    public Artist update(Artist artist) {
        return repository.save(artist);
    }

    @Override
    public Artist getByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
