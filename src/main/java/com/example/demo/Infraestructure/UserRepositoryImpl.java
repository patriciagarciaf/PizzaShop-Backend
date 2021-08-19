package com.example.demo.Infraestructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.Domain.UserDomain.User;
import com.example.demo.Domain.UserDomain.UserRepository;

import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepository{

        private UserJPARepository userJPARepository;
    
        @Autowired
        public UserRepositoryImpl(final UserJPARepository userJPARepository){
            this.userJPARepository = userJPARepository;
        }
    
        @Override
        public void add(User user) {
            this.userJPARepository.save(user);
        }
    
        @Override
        public Optional<User> get(UUID id) {
            return this.userJPARepository.findById(id);
        }
    

        @Override
        public void update(User user) {
            this.userJPARepository.save(user);
        }
    
        @Override
        public void delete(User user) {
            this.userJPARepository.delete(user);
        }

        @Override
        public List<User> getAll(UUID id, String name, String surname, String email, String Password, String role, int page, int size) {
            return this.userJPARepository
                .findByCriteria(name,email,PageRequest.of(page, size));
        }

}
    

    

