package ru.organization.spring.Nationality;

import org.springframework.stereotype.Component;

@Component("rus")
public class Russian implements Nationality{
    @Override
    public String getNationality() {
        return "I am Russian";
    }
}
