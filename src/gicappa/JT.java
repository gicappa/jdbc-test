package gicappa;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * This class will try to connect to a database specified by program arguments
 *
 * usage:
 *  java -cp ./driver.jar url driver user pass
 */
public class JT {

    public JT(String url, String driver, String username, String password) {
        out.printf("* connection to [%s,%s,%s]: ", url, driver, username);

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection == null)
                out.println("FAILED.\n Some connection parameter is wrong");

            out.println("OK!");

        } catch (ClassNotFoundException e) {
            out.printf("FAILED.\nerror: can't find diver class '%s' in classpath\n", driver);
        } catch (SQLException e) {
            out.printf("FAILED.\nerror: %s", e.getMessage());
        }
    }

    public static void main(String[] argv) {
        String url = argv[1];
        String driver = argv[2];
        String username = argv[3];
        String password = argv[4];

        new JT(url, driver, username, password);
    }
}
