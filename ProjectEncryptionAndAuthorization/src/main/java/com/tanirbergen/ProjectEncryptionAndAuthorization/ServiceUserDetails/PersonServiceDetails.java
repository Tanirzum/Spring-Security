package com.tanirbergen.ProjectEncryptionAndAuthorization.ServiceUserDetails;

import com.tanirbergen.ProjectEncryptionAndAuthorization.Model.Person;
import com.tanirbergen.ProjectEncryptionAndAuthorization.Repository.PersonRepository;
import com.tanirbergen.ProjectEncryptionAndAuthorization.UserDetails.PersonUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceDetails implements UserDetailsService {
    private final PersonRepository personRepository;

    public PersonServiceDetails(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personName = personRepository.findByUsername(username);
        if (personName.isEmpty())
            throw new UsernameNotFoundException("user not found");
            return new PersonUserDetails(personName.get());
    }
}
