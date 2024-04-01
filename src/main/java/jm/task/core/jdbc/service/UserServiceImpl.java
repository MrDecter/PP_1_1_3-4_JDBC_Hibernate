package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userFunc = new UserDaoJDBCImpl();

    public UserServiceImpl() throws SQLException {
    }

    public void createUsersTable() {
        userFunc.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userFunc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
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
