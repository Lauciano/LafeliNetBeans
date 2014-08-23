package persistencia;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "FORNECIMENTO")
public class Fornecimento implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="FORNECEDOR", nullable = false)
	private Integer fornecedor;

	@Column(name="MATERIAL", nullable = false)
	private Integer material;
	
	@Column(name="PRECO", nullable = true)
	private Double preco;
	
	public Fornecimento(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Integer fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
