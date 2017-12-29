package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.service.UserArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user/artist")
public class UserArtistController {

    private UserArtistService service;

    @Autowired
    public UserArtistController(UserArtistService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserArtist>> getAll(Principal principal){
        return new ResponseEntity<>(service.getAll(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/{artistName}")
    public ResponseEntity<UserArtist> get(@PathVariable("artistName") String artistName, Principal principal) {
        return new ResponseEntity<>(service.get(artistName, principal.getName()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserArtist userArtist) {
        service.createOrUpdate(userArtist);
        return new ResponseEntity(HttpStatus.OK);
    }

}
