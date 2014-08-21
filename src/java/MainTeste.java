import persistencia.Cliente;
import persistencia.ClienteDAO;

public class MainTeste {
	public static void main(String[] args){
		
		Cliente c = new Cliente();
		c.setNome("Lauciano");
		c.setSobrenome("Almeida");
		c.setTelefonep("12345678");
		
		ClienteDAO cdao = new ClienteDAO();
		
		cdao.persist(c);
		
	}
}
