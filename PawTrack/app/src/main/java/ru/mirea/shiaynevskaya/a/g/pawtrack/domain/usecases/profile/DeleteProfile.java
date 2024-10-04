package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;

public class DeleteProfile {
    private final UsersRepository usersRepository;

    public DeleteProfile(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(int userId) {
        usersRepository.deleteProfile(userId);
    }
}
