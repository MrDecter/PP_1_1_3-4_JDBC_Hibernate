package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl userFunc = new UserDaoJDBCImpl();
    public void createUsersTable()  {
        userFunc.createUsersTable();
    }

    public void dropUsersTable() {
        userFunc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userFunc.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userFunc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userFunc.getAllUsers();
    }

    public void cleanUsersTable() {
        userFunc.cleanUsersTable();
    }
}
