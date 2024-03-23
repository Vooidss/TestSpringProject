package ru.organization.spring.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 30,message = "Имя должно состоять от 1 до 30 символов")
    private String name;

    @NotEmpty(message = "Поле не должно бвть пустым")
    private String author;

    @Min(value = 1000,message = "Год выхода книги должен быть минимум 1000")
    @Max(value = 2024, message = "Год выхода книги должен быть максимум 2024")
    private int years_of_release;

    public Book(){

    }


}
