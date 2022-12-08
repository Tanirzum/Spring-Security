package com.tanirbergen.SecondAppSpringSecurityPage.ServiceDetails;

import com.tanirbergen.SecondAppSpringSecurityPage.Model.Person;
import com.tanirbergen.SecondAppSpringSecurityPage.PersonDetails.PersonUserDetails;
import com.tanirbergen.SecondAppSpringSecurityPage.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceDetails implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceDetails(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("user not found");
        return new PersonUserDetails(person.get());
    }
}
