package br.edu.ufcg.lab.service;

import br.edu.ufcg.lab.model.User;
import br.edu.ufcg.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByUsername(email);
    }
}
