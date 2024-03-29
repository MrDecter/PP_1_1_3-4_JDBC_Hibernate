package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("name1","lastname1", (byte) 20);
        userDao.saveUser("name2","lastname2", (byte) 30);
        userDao.saveUser("name3","lastname3", (byte) 40);
        userDao.saveUser("name4","lastname4", (byte) 50);

        List<User> users = userDao.getAllUsers();
        users.forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getLastName() + " " + s.getAge()));

        userDao.removeUserById(2);

        userDao.cleanUsersTable();

        List<User> users2 = userDao.getAllUsers();
        users2.forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getLastName() + " " + s.getAge()));

        userDao.dropUsersTable();

    }
}
