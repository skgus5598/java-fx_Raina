package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCommon {
public static Connection conn;
	
	public static void setDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "raina", "5598");
			System.out.println("연결되었습니다 : " + conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
