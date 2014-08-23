package persistencia;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "FORNECEDOR")
@ManagedBean
public class Fornecedor implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="TELEFONE_P", nullable = false)
	private String telefonep;
	
	@Column(name="TELEFONE_S", nullable = true)
	private String telefones;
	
	@Column(name="ENDERECO", nullable = true)
	private String endereco;
	
	public Fornecedor(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void cadastra(){
            
            Fornecedor f = new Fornecedor();
            
            System.out.println("Cadastrando");
            
            f.setCnpj(cnpj);
            f.setEndereco(endereco);
            f.setNome(nome);
            f.setTelefonep(telefonep);
            f.setTelefones(telefones);

            FornecedorDAO cdao = new FornecedorDAO();

            cdao.persist(f);
            limpaValores();
            
        }
        
        public void limpaValores(){
            cnpj = "";
            endereco = "";
            nome = "";
            telefonep = "";
            telefones = "";
        }
}
