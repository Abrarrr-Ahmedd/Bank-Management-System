package bank_management_system;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagement",
                "root",
                "Knkikorba12@"
            );

            s = c.createStatement();

            System.out.println("CONNECTED TO DATABASE!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}