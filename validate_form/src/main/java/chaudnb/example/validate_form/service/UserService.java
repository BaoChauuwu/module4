package chaudnb.example.validate_form.service;

import chaudnb.example.validate_form.dto.UserDTO;
import chaudnb.example.validate_form.entity.User;
import chaudnb.example.validate_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        User user = convertDTOToEntity(userDTO);
        return userRepository.save(user) != null;
    }

    private User convertDTOToEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
