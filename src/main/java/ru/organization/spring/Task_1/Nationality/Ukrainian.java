package ru.organization.spring.Task_1.Nationality;

import org.springframework.stereotype.Component;
import ru.organization.spring.Task_1.Nationality.Nationality;

@Component("uk")
public class Ukrainian implements Nationality {
    @Override
    public String getNationality() {
        return "I am Ukrainian";
    }
}
