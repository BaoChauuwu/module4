package chaudnb.example.validate_form.dto;

import jakarta.validation.constraints.*;

public class UserDTO {
    
    @NotBlank(message = "First name không được để trống")
    @Size(min = 5, max = 45, message = "First name phải từ 5 đến 45 ký tự")
    private String firstName;

    @NotBlank(message = "Last name không được để trống")
    @Size(min = 5, max = 45, message = "Last name phải từ 5 đến 45 ký tự")
    private String lastName;

    @Pattern(regexp = "^(0|\\+84)[0-9]{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải >= 18")
    private int age;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
