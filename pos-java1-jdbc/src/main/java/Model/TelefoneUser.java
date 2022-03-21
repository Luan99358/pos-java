package Model;

public class TelefoneUser {
	
	private Long id_telelfone;
	private Long id_User;
	private String telefone;
	private String tipo;
	
	public Long getId_telelfone() {
		return id_telelfone;
	}
	public void setId_telelfone(Long id_telelfone) {
		this.id_telelfone = id_telelfone;
	}
	public Long getId_User() {
		return id_User;
	}
	public void setId_User(Long id_User) {
		this.id_User = id_User;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
