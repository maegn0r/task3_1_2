package ru.myproject.task3_1_2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myproject.task3_1_2.dao.UserDao;
import ru.myproject.task3_1_2.dto.UserDto;
import ru.myproject.task3_1_2.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public void add(UserDto userDto) {
        User user = new User(userDto);
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getListOfUsers() {
        return userDao.listUsers().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return new UserDto(userDao.findById(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.remove(userDao.findById(id));
    }

    @Override
    @Transactional
    public void merge(UserDto userDto) {
        User user = userDao.findById(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAge(userDto.getAge());
        userDao.merge(user);
    }


}
