package ru.clevertec.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.clevertec.entity.User;
import ru.clevertec.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final UserRepository userRepository = UserRepository.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(userRepository.getUsers());
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
