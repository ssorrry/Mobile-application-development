package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class EditProfile {
    private final UsersRepository usersRepository;

    public EditProfile(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(int userId, User updatedUser) {
        usersRepository.editProfile(userId, updatedUser);
    }
}
