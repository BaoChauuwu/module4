package chaudnb.example.validate_song.dto;

import chaudnb.example.validate_song.validation.NoSpecialCharacters;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    
    private Long id;
    
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @NoSpecialCharacters(message = "Tên bài hát không được chứa các ký tự đặc biệt như @ ; , . = - +")
    private String title;
    
    @NotBlank(message = "Nghệ sĩ thể hiện không được để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không được vượt quá 300 ký tự")
    @NoSpecialCharacters(message = "Nghệ sĩ thể hiện không được chứa các ký tự đặc biệt như @ ; , . = - +")
    private String artist;
    
    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    private String genre;
}
