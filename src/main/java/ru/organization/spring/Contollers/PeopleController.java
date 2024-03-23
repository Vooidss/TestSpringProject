package ru.organization.spring.Contollers;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.organization.spring.dao.BookDao;
import ru.organization.spring.dao.BookPeopleDao;
import ru.organization.spring.dao.PeopleDao;
import ru.organization.spring.models.Person;

@Controller
@Getter
@RequestMapping("/people")
public class PeopleController {
    private final PeopleDao peopleDao;
    private final BookDao bookDao;
    private final BookPeopleDao bookPeopleDao;

    @Autowired
    public PeopleController(PeopleDao peopleDao,BookDao bookDao,BookPeopleDao bookPeopleDao){
        this.peopleDao = peopleDao;
        this.bookDao = bookDao;
        this.bookPeopleDao = bookPeopleDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("person",peopleDao.index());
        return "people/index";
    }

    @GetMapping("/new")
    public String NewBook(@ModelAttribute("person")Person person){
        return "people/new";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
        model.addAttribute("person",peopleDao.show(id));
        model.addAttribute("bookList",bookPeopleDao.ListBooksById(id));

        return "people/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",peopleDao.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") @Valid Person person,
                       BindingResult bindingResult,
                       @PathVariable("id") int id){

        if(bindingResult.hasErrors()){
            return "people/edit";
        }

        peopleDao.update(id,person);

        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        peopleDao.delete(id);
        return "redirect:/people";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "people/new";
        }

        peopleDao.save(person);

        return "redirect:/people";
    }
}
