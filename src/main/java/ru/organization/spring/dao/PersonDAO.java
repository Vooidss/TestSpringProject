package ru.organization.spring.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.organization.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class PersonDAO {
    private static int POPLE_COUNT;

    private List<Person> people = new ArrayList<>() {{
        add(new Person(++POPLE_COUNT,"Egor",18));
        add(new Person(++POPLE_COUNT,"Ksenia",18));
        add(new Person(++POPLE_COUNT,"Vasia",17));
    }};

    public void save(Person person){
        person.setId(++POPLE_COUNT);
        people.add(person);
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setYearsAgo(updatePerson.getYearsAgo());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
