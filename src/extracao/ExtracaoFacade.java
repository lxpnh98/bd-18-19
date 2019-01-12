package extracao;

import java.sql.*;

public class ExtracaoFacade {
    private String user;
    private String password;

    public ExtracaoFacade(String user, String password, String driver) {
        this.user = user;
        this.password = password;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/Biblioteca?" +
                                               "user=" + this.user + "&password=" + this.password +
                                               "&useSSL=false" + "&allowPublicKeyRetrieval=true" + "&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }
}
