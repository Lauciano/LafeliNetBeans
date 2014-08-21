package controle;

public class MemberManager {
	private String nome;
	private String user;
	private String pswd;
	
	public MemberManager() {
		nome = "Administrador";
		user = "admin";
		pswd = "admin";
	}

	public boolean authenticate(String username, String password){
		if(username == user && password == pswd){
			return true;
		}
		return false;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
}
