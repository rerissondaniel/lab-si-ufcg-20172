package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/create/")
    public ResponseEntity<Artist> create(Artist artist) {
        Artist createdArtist = this.artistService.create(artist);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

}
