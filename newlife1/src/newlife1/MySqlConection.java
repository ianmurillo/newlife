package newlife1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConection {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/1taldea";
        String usuario = "root";
        String contraseña = "1WMG2023";

        return DriverManager.getConnection(url, usuario, contraseña);
    }
}

