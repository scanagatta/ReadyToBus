package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTeste implements Conexao {
	
	private static Connection con;

	static {
		open();
	}
	
	public static void open() {
		String url = "jdbc:mysql://localhost:3306/transporte_test";
		String username = "root";
		String password = "ctg4662011";
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection get() {
		try {
			if(con.isClosed()) {
				open();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
