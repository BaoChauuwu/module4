package chaudnb.example.validate_song.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoSpecialCharactersValidator implements ConstraintValidator<NoSpecialCharacters, String> {
    
    private String[] allowedChars;
    
    @Override
    public void initialize(NoSpecialCharacters constraintAnnotation) {
        this.allowedChars = constraintAnnotation.allowedChars();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        
        String forbiddenChars = "@;.=-+";
        
        if (allowedChars.length > 0 && allowedChars[0].equals(",")) {
            forbiddenChars = "@;.=-+";
        }
        
        for (char c : value.toCharArray()) {
            if (forbiddenChars.indexOf(c) != -1) {
                return false;
            }
        }
        
        return true;
    }
}

