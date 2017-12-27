package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.model.User;
import br.edu.ufcg.lab.repository.UserArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private ArtistService artistService;
    private UserService userService;
    private UserArtistRepository repository;

    @Autowired
    public RatingServiceImpl(ArtistService artistService, UserService userService, UserArtistRepository repository) {
        this.artistService = artistService;
        this.userService = userService;
        this.repository = repository;
    }

    @Override
    public UserArtist get(String artistName, Integer idUser) {
        Artist artist = artistService.getByName(artistName);
        User user = userService.getById(idUser);

        return repository.findByArtistAndUser(artist, user);
    }

    @Override
    public void createOrUpdate(UserArtist userArtist) {
        repository.save(userArtist);
    }
}
