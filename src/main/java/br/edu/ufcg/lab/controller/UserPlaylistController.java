package br.edu.ufcg.lab.controller;

import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.model.Playlist;
import br.edu.ufcg.lab.service.UserPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("playlist")
public class UserPlaylistController {

    private UserPlaylistService userPlaylistService;

    @Autowired
    public UserPlaylistController(UserPlaylistService userPlaylistService) {
        this.userPlaylistService = userPlaylistService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> get(Principal principal) {
        List<Playlist> playlists = userPlaylistService.get(principal.getName());
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/{playlistName}")
    public ResponseEntity<Playlist> getByName(@PathVariable String playlistName, Principal principal) {
        Playlist playlist = userPlaylistService.getByNameAndUser(playlistName, principal.getName());
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @GetMapping("/{playlistName}/available-musics")
    public ResponseEntity<List<Music>> getAvailableMusics(@PathVariable String playlistName, Principal principal) {
        List<Music> musics = userPlaylistService.getAvailableMusics(playlistName, principal.getName());
        return new ResponseEntity<>(musics, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> create(@RequestBody Playlist playlist, Principal principal) {
        return new ResponseEntity<>(userPlaylistService.create(playlist, principal.getName()), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Playlist> update(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(userPlaylistService.update(playlist), HttpStatus.CREATED);
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity delete(@PathVariable Integer playlistId) {
        userPlaylistService.delete(playlistId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
