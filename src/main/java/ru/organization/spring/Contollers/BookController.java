package ru.organization.spring.Contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.organization.spring.dao.BookDao;
import ru.organization.spring.dao.PeopleDao;
import ru.organization.spring.models.Book;
import ru.organization.spring.models.Person;


@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PeopleDao peopleDao;

    @Autowired
    public BookController(BookDao bookDao, PeopleDao peopleDao){
        this.bookDao = bookDao;
        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("book",bookDao.index());
        return "book/index";
    }

    @GetMapping("/new")
    public String NewBook(@ModelAttribute("book") Book book){
        return "book/new";
    }

    @GetMapping("/{id}")
        public String show (@PathVariable("id") int id, Model model,
                            @ModelAttribute("person") Person person){
        model.addAttribute("book",bookDao.show(id));
        model.addAttribute("people",peopleDao.index());

        return "book/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book",bookDao.show(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult,
                       @PathVariable("id") int id){

        if(bindingResult.hasErrors()){
            return "book/edit";
        }

        bookDao.update(id,book);

        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDao.delete(id);
        return "redirect:/book";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "book/new";
        }

        bookDao.save(book);

        return "redirect:/book";
    }



}
