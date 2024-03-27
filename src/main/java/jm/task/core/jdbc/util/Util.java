package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    // Создание переменных с url,логином и паролем к БД
    private static final String URL = "jdbc:mysql://localhost/testdata";
    private static final String USER = "root";
    private static final String password = "007707";

    // Создание функции для подключения к БД
    public static Connection getConnection() {

        Connection connect = null;

        try {

            connect = DriverManager.getConnection(URL, USER,password);
            System.out.println("\nПодключение БД: Успешно!");

        } catch (SQLException e) {

            throw new RuntimeException(e + "Подключение БД: Неудача...");

        }

        return connect;

    }
}
