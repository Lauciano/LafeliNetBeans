package persistencia;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "MATERIAL")
@ManagedBean
public class Material implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="QUANTIDADE", nullable = false)
	private Integer quantidade;
	
	public Material(){
		
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void cadastra(){
            
            Material m = new Material();
            
            System.out.println("Cadastrando");
            
            m.setNome(nome);
            m.setQuantidade(quantidade);

            MaterialDAO cdao = new MaterialDAO();

            cdao.persist(m);
            limpaValores();
            
        }
        
        public void limpaValores(){
            nome = "";
            quantidade = 0;
        }
}
