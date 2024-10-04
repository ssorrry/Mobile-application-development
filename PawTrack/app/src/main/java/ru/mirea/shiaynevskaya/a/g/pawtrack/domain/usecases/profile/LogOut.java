package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class LogOut {
    private final UsersRepository usersRepository;

    public LogOut(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(int userId) {
        usersRepository.logout(userId);
    }
}
