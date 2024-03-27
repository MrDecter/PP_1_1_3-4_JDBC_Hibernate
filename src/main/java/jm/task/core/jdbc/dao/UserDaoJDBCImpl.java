package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoJDBCImpl implements UserDao {
    private Connection conenct = Util.getConnection();

    public UserDaoJDBCImpl() {}

    public void createUsersTable() {

        String sql = "CREATE TABLE IF NOT EXISTS USER" +
                "(ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NAME VARCHAR(50) NOT NULL, " +
                "LASTNAME VARCHAR(100) NOT NULL, " +
                "AGE INT NOT NULL)";

        try (Statement statement = conenct.createStatement()){

            statement.executeUpdate(sql);

            System.out.println("Таблица в БД: Создана!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Таблица в БД: Неудалось инициализировать...");

        }
    }

    public void dropUsersTable() {
        try (Statement statement = conenct.createStatement()){

            statement.execute("DROP TABLE IF EXISTS USER");
            System.out.println("Удаление таблицы: Успех!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Удаление таблицы: Неудача...");

        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        // Формирование запроса
        String sql = "INSERT INTO USER (NAME, LASTNAME,AGE) VALUES (?,?,?)";

        // Обработка запроса
        try {

            PreparedStatement statement = conenct.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);

            // Отправка запроса
            statement.executeUpdate();

            System.out.println("Добавление данных: Успех!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Добавление данных: Неудача...");

        }
    }

    public void removeUserById(long id) {

        // Формирование запроса
        String sql = "SELECT * FROM USER WHERE ID = ?";

        try {

            PreparedStatement statement = conenct.prepareStatement(sql);
            statement.setLong(1, id);

            // Получение данных по запросу
            ResultSet result = statement.executeQuery();

            // Обработка отображения запроса
            if(result.next()) {

                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("lastname"));
                user.setAge(result.getByte("age"));
                System.out.println(user);

            } else {

                System.out.println("Пользователь с ID: " + id + " не найден!");

            }

            System.out.println("Получение ID: Успех!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Получение ID: Неудача...");

        }


    }

    public List<User> getAllUsers() {

        // Создание листа для хранения юзеров
        List<User> users = new ArrayList<>();

        // Формирование запроса
        String sql = "SELECT * FROM USER";

        try {

            // Обработка запрсоа
            PreparedStatement statement = conenct.prepareStatement(sql);

            // Получение данных по запросу
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                // Обработка полученных данных
                String name = result.getString("name");
                String lastname = result.getString("lastname");
                byte age = result.getByte("age");

                // Добавление в список
                User user = new User(name, lastname, age);
                users.add(user);
            }

            System.out.println("Получение всех User: Успех!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Получение всех User: Неудача...");

        }

        return users;
    }

    public void cleanUsersTable() {

    }
}
