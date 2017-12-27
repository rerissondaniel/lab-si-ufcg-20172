package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User getById(Integer id);

    User create(User user);
}
