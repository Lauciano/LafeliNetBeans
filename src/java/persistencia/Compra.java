package persistencia;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "COMPRA")
@ManagedBean
public class Compra implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="MATERIAL", nullable = false)
	private Integer id_material;
	
	@Column(name="FORNECEDOR", nullable = false)
	private Integer id_fornecedor;
	
	@Column(name="QUANTIDADE", nullable = false)
	private Integer quantidade;
	
	@Column(name="DATA", nullable = false)
	private String data;
	
	@Column(name="PRECO", nullable = false)
	private Double preco;
        
	public Compra(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_material() {
		return id_material;
	}

	public void setId_material(Integer id_material) {
		this.id_material = id_material;
	}

	public Integer getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
        
        public void cadastra(){
            
            Compra p = new Compra();
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Cadastrando");
            
            p.setId_fornecedor(id_fornecedor);
            p.setId_material(id_material);
            p.setPreco(preco);
            p.setQuantidade(quantidade);
            p.setData(data);
            
            CompraDAO cdao = new CompraDAO();

            cdao.persist(p);
            limpaValores();
            
        }
        
        public void limpaValores(){
            id_fornecedor = 0;
            id_material = 0;
            preco = 0.0;
            quantidade = 0;
            data = "";
        }
	
}