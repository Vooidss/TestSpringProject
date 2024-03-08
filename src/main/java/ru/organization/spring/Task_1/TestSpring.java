package ru.organization.spring.Task_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.organization.spring.Task_1.Music.Musics;

public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        PlayerMusic playerMusic = context.getBean("Player",PlayerMusic.class);

        playerMusic.playMusic(Musics.ROCK);
        playerMusic.playMusic(Musics.CLASSICAL);

        context.close();
    }
}
