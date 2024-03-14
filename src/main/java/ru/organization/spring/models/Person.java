package ru.organization.spring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private int yearsAgo;

    public Person(){

    }

}
