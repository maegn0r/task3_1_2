package ru.myproject.task3_1_2.service;
import ru.myproject.task3_1_2.dto.UserDto;
import java.util.List;

public interface UserService {
    void add(UserDto userDto);
    List<UserDto> getListOfUsers();

    UserDto findById(Long id);

    void deleteById(Long id);

    void merge(UserDto userDto);
}
