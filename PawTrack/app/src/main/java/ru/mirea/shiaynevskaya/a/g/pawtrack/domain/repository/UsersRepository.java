package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;

public interface UsersRepository {
    void createAccount(User user);
    User login(String username, String password);
    void logout(int userId);
    void editProfile(int userId, User updatedUser);
    void deleteProfile(int userId);

    List<User> getAllUsers();
}
