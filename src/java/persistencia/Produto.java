package persistencia;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PRODUTO")
@ManagedBean
public class Produto implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="PRECO", nullable = false)
	private Double preco;
	
	public Produto(){
            nome = "";
            preco = 0.0;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
        
        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        public void cadastra(){
            
            Produto p = new Produto();
            
            System.out.println("Cadastrando");
            
            p.setNome(nome);
            p.setPreco(preco);

            ProdutoDAO cdao = new ProdutoDAO();

            cdao.persist(p);
            limpaValores();
            
        }
        
        public void limpaValores(){
            nome = "";
            preco = 0.0;
        }
        
}