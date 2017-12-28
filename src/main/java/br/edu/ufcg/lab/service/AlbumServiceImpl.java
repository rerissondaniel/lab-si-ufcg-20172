package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.Album;
import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.model.Music;
import br.edu.ufcg.lab.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;
    private ArtistService artistService;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }


    @Override
    public void addMusic(String albumName, Music music) {

        Artist artist = artistService.getByName(music.getArtist().getName());

        Album album = albumRepository.findByName(albumName);
        if (album == null) {
            album = new Album(albumName);
            artist.addAlbum(album);
        }

        album.add(music);
        albumRepository.save(album);
        artistService.update(artist);
    }
}
