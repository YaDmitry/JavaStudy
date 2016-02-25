import java.sql.DriverManager;

/**
 * Created by dmya on 2/5/2016.
 */
public class Connection {

Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root123")

}
