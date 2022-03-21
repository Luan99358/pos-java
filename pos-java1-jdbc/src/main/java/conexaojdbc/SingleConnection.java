package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    
	
	//so se conecta uma vez depois apenasabre e fecha sessoes
	private static String url ="jdbc:postgresql://localhost:5432/posjava";
	private static String password = "";
	private static String user="postgres";
	private static Connection connection = null;
	
	//automatizando para sempre q instaciar essa classe ela chamar o conectar automaticamente 
	static {
		connectar();
	}
	
	public SingleConnection()  {
		connectar();
	}
	
	private static void connectar()  {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url,user,password);
				connection.setAutoCommit(false);
				System.out.println("conectou com sucesso ! ");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
