package chaudnb.example.validate_song.entity;

import chaudnb.example.validate_song.validation.NoSpecialCharacters;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @NoSpecialCharacters(message = "Tên bài hát không được chứa các ký tự đặc biệt như @ ; , . = - +")
    private String title;
    
    @Column(name = "artist", nullable = false, length = 300)
    @NotBlank(message = "Nghệ sĩ thể hiện không được để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không được vượt quá 300 ký tự")
    @NoSpecialCharacters(message = "Nghệ sĩ thể hiện không được chứa các ký tự đặc biệt như @ ; , . = - +")
    private String artist;
    
    @Column(name = "genre", nullable = false, length = 1000)
    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    @NoSpecialCharacters(allowedChars = {","}, message = "Thể loại nhạc chỉ được chứa dấu phẩy, không được chứa các ký tự đặc biệt khác như @ ; . = - +")
    private String genre;
}
