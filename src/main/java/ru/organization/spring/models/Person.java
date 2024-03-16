package ru.organization.spring.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 30,message = "Name should be between 1 and 30 characters")
    private String name;

    @Min(value = 0,message = "Age should be greater than 0")
    @Max(value = 99, message = "Age should be less than 99")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Incorrect email form")
    private String email;

    public Person(){

    }

}
