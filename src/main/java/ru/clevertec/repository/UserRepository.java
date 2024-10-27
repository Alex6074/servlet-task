package ru.clevertec.repository;

import ru.clevertec.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private static final UserRepository INSTANCE = new UserRepository();

    private final List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
        users.add(new User(0, "admin", "1111"));
        users.add(new User(1, "user", "2222"));
    }

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public User findUserByLogin(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size());
        return user;
    }
}
