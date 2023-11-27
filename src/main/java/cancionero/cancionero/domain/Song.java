package cancionero.cancionero.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cancion")
public class Song {

    @Id
    private Integer songId;
    private String songName;
    private String singerName;
    private List<Chord> chordList;
    private String tonality;

    public Song(String songName, String tonality, String singerName){

        this.songName = songName;
        this.tonality = tonality;
        this.singerName = singerName;
        this.chordList = new ArrayList<Chord>();
    }

    public Integer getSongId(){
        return this.songId;
    }
    public String getSongName(){
        return this.songName;
    }
    public String getTonality(){
        return this.tonality;
    }
    public List<Chord> getChordList(){
        return this.chordList;
    }
    public String getSingerName(){
        return singerName;
    }
    public void setSongId(Integer songId){
        this.songId = songId;
    }
    public void setSongName(String songName){
        this.songName = songName;
    }
    public void setChordList(List<Chord> chordList){
        this.chordList = chordList;
    }
    public void setTonality(String tonality){
        this.tonality = tonality;
    }
    public void setSingerName(String singerName){
        this.singerName = singerName;
    }
}



