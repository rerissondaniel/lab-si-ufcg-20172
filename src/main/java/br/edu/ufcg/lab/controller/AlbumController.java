package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("album")
public class AlbumController {

    private AlbumService service;

    @Autowired
    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @PutMapping("/{album}/add-music")
    public ResponseEntity addMusic(@PathVariable("album") String album, @RequestBody Music music) {
        service.addMusic(album, music);
        return new ResponseEntity(HttpStatus.OK);
    }
}
