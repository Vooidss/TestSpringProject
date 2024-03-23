package ru.organization.spring.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.organization.spring.models.Book;
import ru.organization.spring.models.Person;

import java.util.List;

@Component
@Getter
public class BookPeopleDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public BookPeopleDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Person person,Long book_id) {
       System.out.println(person.getId());
       System.out.println(book_id);

        jdbcTemplate.update("INSERT INTO person_book(book_id,person_id) VALUES(?,?)",
                book_id,person.getId());
    }

    public List<Book> ListBooksById (int id){
        return jdbcTemplate.query("SELECT book.name,book.author,book.years_of_release FROM person_book JOIN person on person.id = person_book.person_id JOIN book on book.id = person_book.book_id WHERE person_id = ? ",
                new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
    }


}

