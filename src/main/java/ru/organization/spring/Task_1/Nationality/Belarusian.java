package ru.organization.spring.Task_1.Nationality;

import org.springframework.stereotype.Component;

@Component("bel")
public class Belarusian implements Nationality {
    @Override
    public String getNationality() {
        return "I am Belarusian";
    }
}
