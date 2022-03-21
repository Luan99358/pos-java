package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.BeanTel;
import Model.TelefoneUser;
import Model.Userposjava;
import conexaojdbc.SingleConnection;

public class Telefone_User_DAO {
	
private Connection connection;
	
	public Telefone_User_DAO() {
		
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (TelefoneUser teluser ) {
		
		try {
			String sql = "INSERT INTO telefoneuser (numero, tipo, usuariopessoa)"
					+ "VALUES (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, teluser.getTelefone()  );
			insert.setString(2, teluser.getTipo());
			insert.setLong(3, teluser.getId_User());
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
	
	
 
	public List<TelefoneUser> Listar() throws SQLException{
	  
	
		List<TelefoneUser> list = new ArrayList<TelefoneUser>();
	  
	  
		String sql = "SELECT * FROM telefoneuser";
		PreparedStatement stm  = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();
     
		while (result.next()) {
			TelefoneUser telefoneUser = new TelefoneUser();
			telefoneUser.setId_telelfone(result.getLong("id"));
			telefoneUser.setTelefone("telefone");
			telefoneUser.setTipo(result.getString("tipo"));
			telefoneUser.setId_User(result.getLong("usuariopessoa"));
			list.add(telefoneUser);
    	}
      
		return list;
		
  }
	
	
	
	
	
  
  public void deletar(Long id) {
	  try {
		  String sql = "DELETE FROM userposjava  WHERE id = " + id;
		  PreparedStatement stm  = connection.prepareStatement(sql);
		  stm.execute();
		  connection.commit();
		  


	} catch (Exception e) {
		e.printStackTrace();
	}
  }


  
  
  public List<BeanTel> listaFone (Long id) throws SQLException{
	  
	  List<BeanTel> list = new ArrayList<BeanTel>();
	  
		String sql = "SELECT nome,numero,email FROM telefoneuser "
				+ " AS fone INNER JOIN "
				+ " userposjava AS userp ON  fone.usuariopessoa = userp.id "
				+ " WHERE userp.id = " + id;
		PreparedStatement stm  = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();
     
		while (result.next()) {
			BeanTel beanTel = new BeanTel();
			beanTel.setNome(result.getString("nome"));
			beanTel.setNumero(result.getString("numero"));
			beanTel.setEmail(result.getString("email"));
			list.add(beanTel);
    	}
      
		return list;
	  
	  
	  
	  
	  
	  
  }
  
  
}
