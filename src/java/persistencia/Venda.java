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
        
        private Date d1;
        private Date d2;
	
	public Venda(){
	}

        public Date getD1() {
            return d1;
        }

        public void setD1(Date d1) {
            this.d1 = d1;
        }

        public Date getD2() {
            return d2;
        }

        public void setD2(Date d2) {
            this.d2 = d2;
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
            v.setDataDeCompra(format.format(d2));
            v.setDataEntrega(format.format(d1));
            v.setQuantidade(quantidade);
            v.setProduto(produto);
            v.setVenda(1);

            VendaDAO vdao = new VendaDAO();

            vdao.persist(v);
            limpaValores();
            
        }
        
        public void limpaValores(){
            comprador = 0;
            d1 = new Date();
            d2 = new Date();
            quantidade = 0;
            produto = 0;
            venda = 0;
        }
	
	
}