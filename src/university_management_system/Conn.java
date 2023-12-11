package university_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connect;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/universityManagementSystem","root","Rahul@123");
            s = connect.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
