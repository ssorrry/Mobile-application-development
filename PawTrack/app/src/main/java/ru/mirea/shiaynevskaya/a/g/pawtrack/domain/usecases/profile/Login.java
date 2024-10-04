package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class Login {
    private final UsersRepository usersRepository;

    public Login(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User execute(String username, String password) {
        return usersRepository.login(username, password);
    }
}
