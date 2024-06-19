package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.repository.abstraction.AppUserRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserService implements UserService {

    @Autowired
    private AppUserRepository repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public AppUser saveUser(AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user) ;

    }

    @Override
    public AppUser getById(Long userId) throws EntityNotFoundException {
        Optional<AppUser> opUser = repo.findById(userId);
        if(opUser.isEmpty()){
            throw new EntityNotFoundException(AppUser.class,userId);
        }
        return opUser.get();
    }
}
