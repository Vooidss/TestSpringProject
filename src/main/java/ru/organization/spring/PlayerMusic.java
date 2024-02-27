package ru.organization.spring;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.organization.spring.Music.Music;
import ru.organization.spring.Music.Musics;
import ru.organization.spring.Nationality.Nationality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@NoArgsConstructor
@Setter
@Getter
@Component ("Player")
public class PlayerMusic {
    private Nationality nationality;
    private Music classicalMusic;
    private Music rockMusic;

    @Autowired
    public PlayerMusic(@Qualifier("RockMusic") Music rockMusic, @Qualifier ("ClassicMusic") Music classicalMusic,
                       @Qualifier("rus") Nationality nationality){
        this.rockMusic = rockMusic;
        this.classicalMusic = classicalMusic;
        this.nationality = nationality;
    }

    private List<Music> musics = new ArrayList<>();

    private String name;
    private String age;

    public void playMusic(Musics musics){
        if(Musics.CLASSICAL == musics){
            System.out.println(classicalMusic.getMusics().get(new Random().nextInt(3)));
        }else if (Musics.ROCK == musics){
            System.out.println(rockMusic.getMusics().get(new Random().nextInt(3)));
        }
    }
    @Override
    public String toString() {
        return nationality.getNationality() + " and I " + classicalMusic.getMusics() + "and" + rockMusic.getMusic();
    }
}
