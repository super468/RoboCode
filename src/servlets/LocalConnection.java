package servlets;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LocalConnection {
	private DataSource ds;
	private Connection connection;
	public LocalConnection() {
		String dbname = "vyqib3kzgu5qfu0g";
        String hostname = "10.244.0.144";
        String user = "dmvybidngafw1b4v";
        String password = "oehd3xvyflhilkrn";
        String port = "32770";

        String dbUrl = "jdbc:mysql://" + hostname + ":" + port + "/"
                + dbname;
        System.out.println(dbUrl);
        System.out.println(user + "password " + password);

        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			this.connection = DriverManager.getConnection(dbUrl, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConn() {
		return connection;
	}
	
	
	
	
}
