package ru.mirea.shiaynevskaya.a.g.pawtrack.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class UsersRepositoryImpl implements UsersRepository {
    private final Map<Integer, User> usersDatabase = new HashMap<>();
    private int currentUserId = 1;

    @Override
    public void createAccount(User user) {
        user = new User(currentUserId++, user.getUsername(), user.getPassword(), user.getEmail());
        usersDatabase.put(user.getId(), user);
        System.out.println("Account created for user: " + user.getUsername());
    }

    @Override
    public User login(String username, String password) {
        for (User user : usersDatabase.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User " + username + " logged in.");
                return user;
            }
        }
        System.out.println("Login failed for user: " + username);
        return null;
    }

    @Override
    public void logout(int userId) {
        System.out.println("User with ID " + userId + " logged out.");
    }

    @Override
    public void editProfile(int userId, User updatedUser) {
        if (usersDatabase.containsKey(userId)) {
            usersDatabase.put(userId, updatedUser);
            System.out.println("Profile updated for user ID: " + userId);
        } else {
            System.out.println("User ID not found: " + userId);
        }
    }

    @Override
    public void deleteProfile(int userId) {
        if (usersDatabase.remove(userId) != null) {
            System.out.println("Profile deleted for user ID: " + userId);
        } else {
            System.out.println("User ID not found: " + userId);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersDatabase.values());
    }
}
