package pos_java1_jdbc.pos_java1_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import DAO.Telefone_User_DAO;
import DAO.UserposDAO;
import Model.BeanTel;
import Model.TelefoneUser;
import Model.Userposjava;
import conexaojdbc.SingleConnection;


public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {	
           
		/*setando os dados no objeto*/
		Userposjava userposjava = new Userposjava();
		userposjava.setNome("aguinaldo");
		userposjava.setEmail("aguinaldo@gmail.com");
		
		
		/*instanciandoa classe dao e enviando o objeto como parameto para o metodo salvar*/
		UserposDAO dao = new UserposDAO();
		dao.salvar(userposjava);
		

	}
	
	@Test
	public void initListar() throws SQLException {	
        
		/*instanciandoa classe dao e enviando o objeto como parameto para o metodo salvar*/
		UserposDAO dao = new UserposDAO();
		List<Userposjava> list = dao.Listar();
		
		for (Userposjava user : list ) {
			 System.out.println("ID : " + user.getId()+", Nome : " +user.getNome() +", E-mail : "+user.getEmail());
		}
		
		

	}
	
	@Test
	public void initBuscar() throws SQLException  {	
        
		/*instanciandoa classe dao e enviando o objeto como parameto para o metodo salvar*/
		UserposDAO dao = new UserposDAO();
		Userposjava user = dao.Buscar(4L);
		
			 System.out.println("ID : " + user.getId()+", Nome : " +user.getNome() +", E-mail : "+user.getEmail());
		
		

	}
	
	
	@Test
	public void initAtualizar() throws SQLException  {	
	
		Userposjava userposjava = new Userposjava();
		userposjava.setId(4L);
		userposjava.setNome("Lucas atualizado ");
		userposjava.setEmail("lucas@gmail.com");
		
		UserposDAO dao = new UserposDAO();
		dao.Atualizar(userposjava);
		

	}
	
	@Test
	public void initDeletar() throws SQLException  {	
	
	
		UserposDAO dao = new UserposDAO();
		dao.deletar(7l);
		

	}
	
	
	@Test
	public void initInsertTel() {	
           
		/*setando os dados no objeto*/
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTelefone("(13) 98730-0537");
		telefoneUser.setTipo("CELULAR");
		telefoneUser.setId_User(1L);
		
		
		/*instanciandoa classe dao e enviando o objeto como parameto para o metodo salvar*/
		Telefone_User_DAO dao = new Telefone_User_DAO();
		dao.salvar(telefoneUser);
		

	}
	
	@Test
	public void initBuscarTel() throws SQLException {	
           
		
		/*instanciandoa classe dao e enviando o objeto como parameto para o metodo salvar*/
		Telefone_User_DAO dao = new Telefone_User_DAO();
		List<BeanTel> list = dao.listaFone(1L);
   		
		for (BeanTel bean : list) {
   			
   			 System.out.println("Nome : " +bean.getNome() +", Numero : "+ bean.getNumero()+
   					 ", E-mail : "+bean.getEmail());
   		
		}
		

	}
	
	
	
	


}
