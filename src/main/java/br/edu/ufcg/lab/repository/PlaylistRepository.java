package br.edu.ufcg.lab.repository;

import br.edu.ufcg.lab.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

    Playlist findByNameAndUserUsername(String playlistName, String username);

    List<Playlist> findByUserUsername(String username);
}
