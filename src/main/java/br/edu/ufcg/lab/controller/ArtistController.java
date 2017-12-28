package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.dto.ArtistDto;
import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.service.ArtistService;
import br.edu.ufcg.lab.service.UserArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        Artist createdArtist = artistService.create(artist);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Artist> update(@RequestBody Artist artist) {
        Artist updatedArtist = artistService.update(artist);
        return new ResponseEntity<>(updatedArtist, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<ArtistDto>> getAll() {
        List<Artist> artists = artistService.getAll();
        List<ArtistDto> artistDtos = new LinkedList<>();
        artists.forEach(artist -> artistDtos.add(new ArtistDto(artist)));
        return new ResponseEntity<>(artistDtos, HttpStatus.CREATED);
    }
}
