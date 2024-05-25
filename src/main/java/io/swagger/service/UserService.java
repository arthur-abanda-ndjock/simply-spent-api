package io.swagger.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.exceptions.ModelValidationException;
import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import io.swagger.utils.PasswordHasher;

@Service
public class UserService {

    private final String DUPLICATE_EMAIL_MSG = "a similar email id already exist in the database: ";
    private final String INVALID_EMAIL_MSG = "Email Id is invalid: ";
    private final String INVALID_PASSSWORD_MSG = "The password should contain, at minimum, one number, one capital letter, and one special character.";

    private final UserRepository userRepository;
    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern passwordPattern = Pattern
            .compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>/?]).+$");

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        validate(user);
        String hashedPassword = PasswordHasher.getHash(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    private void validate(User user) {
        if (!emailPattern.matcher(user.getEmailId()).matches()) {
            throw new ModelValidationException(400, INVALID_EMAIL_MSG + user.getEmailId());
        }
        if (!userRepository.findByEmailId(user.getEmailId()).isEmpty()) {
            throw new ModelValidationException(403,
                    DUPLICATE_EMAIL_MSG + user.getEmailId());
        }
        if (!passwordPattern.matcher(user.getPassword()).matches()) {
            throw new ModelValidationException(400, INVALID_PASSSWORD_MSG);
        }
    }

}
