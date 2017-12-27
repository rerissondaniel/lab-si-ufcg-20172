package br.edu.ufcg.lab.repository;

import br.edu.ufcg.lab.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>{
}
