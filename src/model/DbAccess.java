package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbAccess implements ServletContextListener{

	public static Connection conn = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DbAccess.conn = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1/person_db?user=root&password=&serverTimezone=JST&useUnicode=true&characterEncoding=utf8");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
