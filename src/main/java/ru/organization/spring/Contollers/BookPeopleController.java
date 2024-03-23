package ru.organization.spring.Contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.organization.spring.dao.BookPeopleDao;
import ru.organization.spring.dao.PeopleDao;
import ru.organization.spring.models.Book;
import ru.organization.spring.models.Person;

@Controller
@RequestMapping("/book")
public class BookPeopleController {

    private final BookPeopleDao bookPeopleDao;

    @Autowired
    public BookPeopleController(BookPeopleDao bookPeopleDao){
        this.bookPeopleDao = bookPeopleDao;
    }

    @PatchMapping("/add")
    public String make(@ModelAttribute("person") Person person,
                       @RequestParam("bookId") Long bookId){
        bookPeopleDao.insert(person,bookId);

        return "redirect:/book";
    }


}
