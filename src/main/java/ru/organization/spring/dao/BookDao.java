package ru.organization.spring.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.organization.spring.models.Book;

import java.util.List;

@Component
@Getter
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO book(name,author,years_of_release) VALUES (?,?,?)",
        book.getName(),book.getAuthor(),book.getYears_of_release());
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM book WHERE id = ?",new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }


    public void update(int id, Book book){
        jdbcTemplate.update("UPDATE book SET name = ?, author = ?, years_of_release = ? WHERE id = ?",
                book.getName(),book.getAuthor(),book.getYears_of_release(),id);
        }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }


}
