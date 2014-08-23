package persistencia;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@ManagedBean
@Entity(name = "CLIENTE")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="SOBRENOME", nullable = false)
	private String sobrenome;
	
	@Column(name="TELEFONE_P", nullable = false)
	private String telefonep;
	
	@Column(name="TELEFONE_S", nullable = true)
	private String telefones;
	
	public Cliente(){
            nome = "";
            sobrenome = "";
            telefonep = "";
            telefones = "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefonep() {
		return telefonep;
	}

	public void setTelefonep(String telefonep) {
		this.telefonep = telefonep;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}
        
        public void cadastra(){
            
            Cliente c = new Cliente();
            
            System.out.println("Cadastrando");
            
            c.setNome(nome);
            c.setSobrenome(sobrenome);
            c.setTelefonep(telefonep);
            c.setTelefones(telefones);

            ClienteDAO cdao = new ClienteDAO();

            cdao.persist(c);
            limpaValores();
            
        }
        
        public void limpaValores(){
            nome = "";
            sobrenome = "";
            telefonep = "";
            telefones = "";
        }

}