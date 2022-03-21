package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Userposjava;
import conexaojdbc.SingleConnection;

public class UserposDAO {
	
	private Connection connection;
	
	public UserposDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Userposjava userposjava ) {
		
		try {
			String sql = "INSERT INTO userposjava (nome,email)"
					+ "VALUES (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome()  );
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();/*salva no banco*/
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();/*reverte a operação*/
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
 
	public List<Userposjava> Listar() throws SQLException{
	  
	
		List<Userposjava> list = new ArrayList<Userposjava>();
	  
	  
		String sql = "SELECT * FROM userposjava";
		PreparedStatement stm  = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();
     
		while (result.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(result.getLong("id"));
			userposjava.setNome(result.getString("nome"));
			userposjava.setEmail(result.getString("email"));
			list.add(userposjava);
    	}
      
		return list;
		
  }
	
	
	
	public Userposjava Buscar(Long id) throws SQLException{
		  
		
		Userposjava userposjava = new Userposjava();
	  
	  
		String sql = "SELECT * FROM userposjava where id = " + id;
		PreparedStatement stm  = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();
     
		while (result.next()) {
			
			userposjava.setId(result.getLong("id"));
			userposjava.setNome(result.getString("nome"));
			userposjava.setEmail(result.getString("email"));
			
    	}
      
		if(userposjava.getId() == null)
		{
		
			System.out.println("Usuario inexistente na base de dados ");		
		}
		
		return userposjava;
  }
	
  public void Atualizar(Userposjava user) {
    
	  try {
	   
		  String sql = "UPDATE userposjava SET nome = ? WHERE id = " + user.getId();
		  PreparedStatement stm  = connection.prepareStatement(sql);
		  stm.setString(1, user.getNome());
		  stm.execute();
		  connection.commit();
		  }catch (Exception e) {

			  e.printStackTrace();
			  }
		
		
   }
  
  public void deletar(Long id) {
	  try {
		  String sql = "DELETE FROM telefoneuser WHERE usuariopessoa =" + id+";"
		  		+ "DELETE FROM userposjava  WHERE id = " + id + ";";
		  PreparedStatement stm  = connection.prepareStatement(sql);
		  stm.execute();
		  connection.commit();
		  


	} catch (Exception e) {
		e.printStackTrace();
	}
  }

 }
