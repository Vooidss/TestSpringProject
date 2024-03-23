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

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 30,message = "Имя должно состоять от 1 до 30 символов")
    private String full_name;

    @Min(value = 1950,message = "Год рождения должен быть минимум 1950")
    @Max(value = 2024, message = "Год рождения должен быть максимум 2024")
    private int years_of_birth;

    public Person(){

    }

}
