package org.generation.italy.EpicTrip.model.service.security;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.repository.abstraction.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepository repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public AppUser saveUser(AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user) ;

    }
}
