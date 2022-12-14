package com.tanirbergen.SecondAppSpringSecurityPage.ServiceDetails;

import com.tanirbergen.SecondAppSpringSecurityPage.Model.Person;
import com.tanirbergen.SecondAppSpringSecurityPage.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }
}
