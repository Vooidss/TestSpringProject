package ru.organization.spring.Music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ClassicMusic")
public class ClassiсMusic implements Music{

    List<String> musics = new ArrayList<String>(){{
        add("One music from ClassicMusic");
        add("Two music from ClassicMusic");
        add("Three music from ClassicMusic");
    }};

    @Override
    public List<String> getMusics() {
        return musics;
    }

    @Override
    public String getMusic(){
        return "Playing is Classic Music";
    }
}
