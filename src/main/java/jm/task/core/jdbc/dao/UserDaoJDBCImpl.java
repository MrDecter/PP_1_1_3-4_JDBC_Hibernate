package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

// Отчистка от прошлого решения

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {}

    // Создание таблицы если не создана
    @Override
    public void createUsersTable() {}

    // Удаление таблицы
    @Override
    public void dropUsersTable() {}

    // Добавление пользователя
    @Override
    public void saveUser(String name, String lastName, byte age) {}

    // Получение пользователя по ID
    @Override
    public void removeUserById(long id) {}

    // Получение списка юзеров
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    // Отчистка таблицы
    @Override
    public void cleanUsersTable() {}
}
