package br.edu.ufcg.lab.repository;

import br.edu.ufcg.lab.model.Artist;
import br.edu.ufcg.lab.model.UserArtist;
import br.edu.ufcg.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserArtistRepository extends JpaRepository<UserArtist, Integer> {

    UserArtist findByArtistAndUser(Artist artist, User user);

}
