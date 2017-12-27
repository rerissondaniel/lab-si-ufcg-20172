package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.service.UserArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingController {

    public UserArtistService service;

    @GetMapping("/{artistName}/{userId}")
    public UserArtist get(String artistName, Integer userId) {
        return service.get(artistName, userId);
    }

}
