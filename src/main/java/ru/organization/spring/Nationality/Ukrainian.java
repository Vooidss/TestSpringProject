package ru.organization.spring.Nationality;

import org.springframework.stereotype.Component;

@Component("uk")
public class Ukrainian implements Nationality{
    @Override
    public String getNationality() {
        return "I am Ukrainian";
    }
}
