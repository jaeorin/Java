package study_190328;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class name {
	Connection connection;
	Statement statement;
	ResultSet resultset;

	public name() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String pwd = "madang";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("데이터베이스 연결 준비 ...");
			connection = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void sqlRun() {
		String query = "SELECT * FROM customer";
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			System.out.println("CUSTID \tNAME \tADDRESS \t\tPHONE");
			while (resultset.next()) {
				System.out.print(resultset.getInt(1));
				System.out.print("\t" + resultset.getString(2));
				System.out.print("\t" + resultset.getString(3));
				System.out.println("\t\t" + resultset.getString(4));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
