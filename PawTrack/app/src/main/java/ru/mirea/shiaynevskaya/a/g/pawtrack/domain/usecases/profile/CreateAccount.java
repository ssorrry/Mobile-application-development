package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class CreateAccount {
    private final UsersRepository usersRepository;

    public CreateAccount(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(User user) {
        usersRepository.createAccount(user);
    }
}
