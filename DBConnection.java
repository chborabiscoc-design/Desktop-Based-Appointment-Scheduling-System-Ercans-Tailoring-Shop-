import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author dayuh
 */
public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ercans_tailoring",
                "root",
                ""
            );

            System.out.println("Database Connected!");
            return con;

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
   
}
