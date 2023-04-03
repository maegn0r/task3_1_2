package ru.myproject.task3_1_2.dao;


import ru.myproject.task3_1_2.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User findById(Long id);

    void merge(User user);

    void remove(User user);
}