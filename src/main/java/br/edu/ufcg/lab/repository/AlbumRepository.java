package br.edu.ufcg.lab.repository;

import br.edu.ufcg.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer>{
    Album findByName(String name);
}
