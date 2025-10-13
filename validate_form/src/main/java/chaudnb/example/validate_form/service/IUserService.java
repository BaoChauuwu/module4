package chaudnb.example.validate_form.service;

import chaudnb.example.validate_form.dto.UserDTO;
import chaudnb.example.validate_form.entity.User;

public interface IUserService {
    boolean addUser(User user);
    boolean addUser(UserDTO userDTO);
}
