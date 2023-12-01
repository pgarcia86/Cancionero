package cancionero.cancionero.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Document(collection = "Cancion")
public class Song {

    @Id
    private Integer songId;
    private String songName;
    private String singerName;
    private List<Chord> chordList;
    private String tonality;

    public Song(Integer songId, String songName, String tonality, String singerName){
        this.songId = songId;
        this.songName = songName;
        this.tonality = tonality;
        this.singerName = singerName;
        this.chordList = new ArrayList<Chord>();
    }

    public Song(Integer songId, String songName, List<Chord> chordList, String tonality, String singerName){
        this.songId = songId;
        this.songName = songName;
        this.tonality = tonality;
        this.singerName = singerName;
        this.chordList = chordList;
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



