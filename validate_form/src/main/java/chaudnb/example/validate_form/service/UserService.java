package chaudnb.example.validate_form.service;

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
}
