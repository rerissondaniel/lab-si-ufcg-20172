package br.edu.ufcg.lab.repository;

import br.edu.ufcg.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByNameIgnoreCase(String name);
}
