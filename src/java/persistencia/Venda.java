package persistencia;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "VENDA")
@ManagedBean
public class Venda implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private Integer id;
	
	@Column(name="VENDA", nullable = false)
	private Integer venda;
	
	@Column(name="COMPRADOR", nullable = false)
	private Integer comprador;
	
	@Column(name="PRODUTO", nullable = false)
	private Integer produto;
	
	@Column(name="DATA_COMPRA", nullable = false)
	private String dataDeCompra;
		
	@Column(name="QUANTIDADE", nullable = false)
	private Integer quantidade;
	
	@Column(name="DATA_ENTREGA", nullable = false)
	private String dataEntrega;
	
	public Venda(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVenda() {
		return venda;
	}

	public void setVenda(Integer venda) {
		this.venda = venda;
	}

	public Integer getComprador() {
		return comprador;
	}

	public void setComprador(Integer comprador) {
		this.comprador = comprador;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public String getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(String dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

        public void cadastra(){
            
            Venda v = new Venda();
            
            System.out.println("Cadastrando");
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            v.setComprador(comprador);
            v.setDataDeCompra(dataDeCompra);
            v.setDataEntrega(dataEntrega);
            v.setQuantidade(quantidade);
            v.setProduto(produto);
            v.setVenda(1);

            VendaDAO vdao = new VendaDAO();

            vdao.persist(v);
            limpaValores();
            
        }
        
        public void limpaValores(){
            comprador = 0;
            dataDeCompra = "";
            dataEntrega = "";
            quantidade = 0;
            produto = 0;
            venda = 0;
        }
	
	
}