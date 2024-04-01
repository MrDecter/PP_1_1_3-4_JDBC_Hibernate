package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static Connection connect = null;
    // Создание финальных переменных переменных
    private static final String URL = "jdbc:mysql://localhost/testdata";
    private static final String USER = "root";
    private static final String password = "007707";

    // Создание функции для подключения к БД
    public static Connection getConnection() throws SQLException {
        try {
            connect = DriverManager.getConnection(URL, USER,password);
            System.out.println("\nПодключение БД: Успешно!");
        } catch (SQLException e) {
            throw new SQLException(e + "Подключение БД: Неудача...");
        }
        return connect;
    }
}
