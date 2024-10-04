package ru.mirea.shiaynevskaya.a.g.pawtrack;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.data.AnimalsRepositoryImpl;
import ru.mirea.shiaynevskaya.a.g.pawtrack.data.PetsRepositoryImpl;
import ru.mirea.shiaynevskaya.a.g.pawtrack.data.UsersRepositoryImpl;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.User;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.AnimalsRepository;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.UsersRepository;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals.FilterAnimalsByCategory;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals.SearchAnimalByName;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals.SearchAnimalByPicture;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals.SortAnimalsByNameAsc;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals.SortAnimalsByNameDesc;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.AddActivity;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.AddPetsProfile;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.AddWeight;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.DeletePetsProfile;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.EditPetsProfile;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.GetAllStaticData;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.GetStaticDataActivity;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets.GetStaticDataWeight;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile.CreateAccount;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile.DeleteProfile;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile.EditProfile;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile.LogOut;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.profile.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //  1. Работа с профилем

        UsersRepository usersRepository = new UsersRepositoryImpl();

        // Создание Use Cases
        CreateAccount createAccountUseCase = new CreateAccount(usersRepository);
        Login loginUseCase = new Login(usersRepository);
        LogOut logoutUseCase = new LogOut(usersRepository);
        EditProfile editProfileUseCase = new EditProfile(usersRepository);
        DeleteProfile deleteProfileUseCase = new DeleteProfile(usersRepository);

        // Создание аккаунта
        User user1 = new User(0, "john_doe", "password123", "john@example.com");
        createAccountUseCase.execute(user1);

        // Вход в аккаунт
        User loggedInUser = loginUseCase.execute("john_doe", "password123");

        // Редактирование профиля
        if (loggedInUser != null) {
            loggedInUser.setEmail("john.doe@newdomain.com");
            editProfileUseCase.execute(loggedInUser.getId(), loggedInUser);
        }

        // Выход из аккаунта
        logoutUseCase.execute(loggedInUser.getId());

        // Удаление профиля
        deleteProfileUseCase.execute(loggedInUser.getId());

        // 2. Страница с животными

        AnimalsRepository animalsRepository = new AnimalsRepositoryImpl();

        // Создание Use Cases
        SortAnimalsByNameAsc sortAsc = new SortAnimalsByNameAsc(animalsRepository);
        SortAnimalsByNameDesc sortDesc = new SortAnimalsByNameDesc(animalsRepository);
        SearchAnimalByName searchByName = new SearchAnimalByName(animalsRepository);
        SearchAnimalByPicture searchByPicture = new SearchAnimalByPicture(animalsRepository);
        FilterAnimalsByCategory filterByCategory = new FilterAnimalsByCategory(animalsRepository);

        // Сортировка по имени по возрастанию
        List<Animal> sortedAsc = sortAsc.execute();
        System.out.println("Sorted Animals Ascending:");
        sortedAsc.forEach(animal -> System.out.println(animal.getName()));

        // Сортировка по имени по убыванию
        List<Animal> sortedDesc = sortDesc.execute();
        System.out.println("\nSorted Animals Descending:");
        sortedDesc.forEach(animal -> System.out.println(animal.getName()));

        // Поиск животного по имени
        List<Animal> searchResult = searchByName.execute("Bella");
        System.out.println("\nSearch Result for 'Bella':");
        searchResult.forEach(animal -> System.out.println(animal.getName()));

        // Поиск животного по изображению
        List<Animal> searchPictureResult = searchByPicture.execute("http://example.com/max.jpg");
        System.out.println("\nSearch Result for Picture:");
        searchPictureResult.forEach(animal -> System.out.println(animal.getName()));

        // Фильтрация животных по категории
        List<Animal> filteredAnimals = filterByCategory.execute("Dog");
        System.out.println("\nFiltered Animals (Category: Dog):");
        filteredAnimals.forEach(animal -> System.out.println(animal.getName()));

        // 3. Взаимодействие с питомцами

        PetsRepository petsRepository = new PetsRepositoryImpl();

        // Создание Use Cases
        AddPetsProfile addPet = new AddPetsProfile(petsRepository);
        EditPetsProfile editPet = new EditPetsProfile(petsRepository);
        DeletePetsProfile deletePet = new DeletePetsProfile(petsRepository);
        GetAllStaticData getAllStaticData = new GetAllStaticData(petsRepository);
        AddActivity addActivity = new AddActivity(petsRepository);
        GetStaticDataActivity getStaticDataActivity = new GetStaticDataActivity(petsRepository);
        AddWeight addWeight = new AddWeight(petsRepository);
        GetStaticDataWeight getStaticDataWeight = new GetStaticDataWeight(petsRepository);

        // Добавление питомца
        Pet pet1 = new Pet(0, "Rex", 5, "Labrador", "Dog", "http://example.com/rex.jpg");
        addPet.execute(pet1);

        // Получение всех статических данных
        List<Pet> allPets = getAllStaticData.execute();
        System.out.println("\nAll Pets:");
        allPets.forEach(pet -> System.out.println(pet.getName()));

        // Редактирование профиля питомца
        pet1.setAge(6);
        editPet.execute(1, pet1);

        // Добавление активности
        addActivity.execute(1, "Walked 5 km");

        // Получение данных об активности
        List<String> activities = getStaticDataActivity.execute(1);
        System.out.println("\nActivities for Pet ID 1:");
        activities.forEach(System.out::println);

        // Добавление веса
        addWeight.execute(1, 25.5);

        // Получение данных о весе
        List<Double> weights = getStaticDataWeight.execute(1);
        System.out.println("\nWeights for Pet ID 1:");
        weights.forEach(System.out::println);

        // Удаление профиля питомца
        deletePet.execute(1);
    }
}