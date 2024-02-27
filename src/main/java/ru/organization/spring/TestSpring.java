package ru.organization.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.organization.spring.Music.Musics;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        PlayerMusic playerMusic = context.getBean("Player",PlayerMusic.class);

        playerMusic.playMusic(Musics.ROCK);
        playerMusic.playMusic(Musics.CLASSICAL);

        context.close();
    }
}
