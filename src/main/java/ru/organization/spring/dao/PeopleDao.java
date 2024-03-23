package ru.organization.spring.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.organization.spring.models.Book;
import ru.organization.spring.models.Person;

import java.util.List;

@Getter
@Component
public class PeopleDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO person(full_name,years_of_birth) VALUES (?,?)",
                person.getFull_name(),person.getYears_of_birth());
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE id = ?",new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE person SET full_name = ?, years_of_birth = ? WHERE id = ?",
                person.getFull_name(),person.getYears_of_birth(),id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }
}
