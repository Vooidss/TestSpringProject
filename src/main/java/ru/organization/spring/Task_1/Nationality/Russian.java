package ru.organization.spring.Task_1.Nationality;

import org.springframework.stereotype.Component;

@Component("rus")
public class Russian implements Nationality {
    @Override
    public String getNationality() {
        return "I am Russian";
    }
}
