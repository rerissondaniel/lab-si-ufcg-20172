package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    private MusicRepository repository;

    @Autowired
    public MusicServiceImpl(MusicRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Music> getAll() {
        return repository.findAll();
    }
}
