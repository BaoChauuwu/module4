package chaudnb.example.validate_song.validation;

import chaudnb.example.validate_song.dto.SongDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return SongDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        
        if (songDTO.getTitle() == null || songDTO.getTitle().trim().isEmpty()) {
            errors.rejectValue("title", "notEmpty", "Tên bài hát không được để trống");
        } else if (songDTO.getTitle().length() > 800) {
            errors.rejectValue("title", "size", "Tên bài hát không được vượt quá 800 ký tự");
        } else if (containsSpecialCharacters(songDTO.getTitle())) {
            errors.rejectValue("title", "specialChars", "Tên bài hát không được chứa các ký tự đặc biệt như @ ; , . = - +");
        }
        
        if (songDTO.getArtist() == null || songDTO.getArtist().trim().isEmpty()) {
            errors.rejectValue("artist", "notEmpty", "Nghệ sĩ thể hiện không được để trống");
        } else if (songDTO.getArtist().length() > 300) {
            errors.rejectValue("artist", "size", "Nghệ sĩ thể hiện không được vượt quá 300 ký tự");
        } else if (containsSpecialCharacters(songDTO.getArtist())) {
            errors.rejectValue("artist", "specialChars", "Nghệ sĩ thể hiện không được chứa các ký tự đặc biệt như @ ; , . = - +");
        }
        
        if (songDTO.getGenre() == null || songDTO.getGenre().trim().isEmpty()) {
            errors.rejectValue("genre", "notEmpty", "Thể loại nhạc không được để trống");
        } else if (songDTO.getGenre().length() > 1000) {
            errors.rejectValue("genre", "size", "Thể loại nhạc không được vượt quá 1000 ký tự");
        }
    }
    
    private boolean containsSpecialCharacters(String value) {
        String forbiddenChars = "@;,.=-+";
        for (char c : value.toCharArray()) {
            if (forbiddenChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
