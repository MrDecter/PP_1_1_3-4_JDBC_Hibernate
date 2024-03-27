package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Создание переменной для доступа
        UserDao userDao = new UserDaoJDBCImpl();

        // Создание теблицы
        userDao.createUsersTable();

        // Добавление данных в БД
        userDao.saveUser("Name1","LastName1", (byte)20);
        userDao.saveUser("Name2","LastName2", (byte)30);
        userDao.saveUser("Name3","LastName3", (byte)10);
        userDao.saveUser("Name4","LastName4", (byte)50);
        userDao.saveUser("Name5","LastName5", (byte)60);

        userDao.removeUserById(2); // Возврат по ID

        userDao.getAllUsers(); // Возврат всех юзеров

        for (User user:userDao.getAllUsers()) {

            System.out.println(user.getName() + " " + user.getLastName() + " - " + user.getAge() + " лет");

        }

        userDao.cleanUsersTable(); // Удаление всех юзеров

        userDao.dropUsersTable(); // Удаление таблицы
    }
}
