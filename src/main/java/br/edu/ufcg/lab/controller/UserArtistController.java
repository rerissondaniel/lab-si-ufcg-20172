package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.service.UserArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/artist")
public class UserArtistController {

    public UserArtistService service;

    @GetMapping("/{userId}/{artistName}")
    public ResponseEntity<UserArtist> get(String artistName, Integer userId) {
        return new ResponseEntity<>(service.get(artistName, userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserArtist userArtist) {
        service.createOrUpdate(userArtist);
        return new ResponseEntity(HttpStatus.OK);
    }

}
