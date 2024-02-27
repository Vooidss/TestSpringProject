package ru.organization.spring.Music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("RockMusic")
public class RockMusic implements Music{
    List<String> musics = new ArrayList<String>(){{
        add("One music from RockMusic");
        add("Two music from RockMusic");
        add("Three music from RockMusic");
    }};
    @Override
    public List<String> getMusics() {
        return musics;
    }
    @Override
    public String getMusic(){
        return "Playing is RockMusic";
    }
}
