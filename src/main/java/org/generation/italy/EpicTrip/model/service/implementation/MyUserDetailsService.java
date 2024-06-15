package org.generation.italy.EpicTrip.model.service.implementation;


import org.generation.italy.EpicTrip.model.UserPrincipal;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.repository.abstraction.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser user= repo.findByEmail(email);

        if (user==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
    }

}
