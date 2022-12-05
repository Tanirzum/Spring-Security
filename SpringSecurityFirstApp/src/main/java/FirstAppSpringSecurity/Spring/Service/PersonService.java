package FirstAppSpringSecurity.Spring.Service;

import FirstAppSpringSecurity.Spring.Details.PersonDetails;
import FirstAppSpringSecurity.Spring.Model.Person;
import FirstAppSpringSecurity.Spring.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personName = personRepository.findByUsername(username);

        if (personName.isEmpty())
            throw new UsernameNotFoundException("user not found");
        return new PersonDetails(personName.get());
    }
}
