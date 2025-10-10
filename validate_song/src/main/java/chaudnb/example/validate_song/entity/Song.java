package chaudnb.example.validate_song.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title", nullable = false, length = 800)
    private String title;
    
    @Column(name = "artist", nullable = false, length = 300)
    private String artist;
    
    @Column(name = "genre", nullable = false, length = 1000)
    private String genre;
}
