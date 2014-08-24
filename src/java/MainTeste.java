
import persistencia.Cliente;
import persistencia.ClienteDAO;
import persistencia.Venda;
import persistencia.VendaDAO;

public class MainTeste {

    public static void main(String[] args) {

        Venda v = new Venda();
        v.setComprador(1);
        v.setDataDeCompra("1123123");
        v.setDataEntrega("123123");
        v.setProduto(1);
        v.setQuantidade(3);
        v.setVenda(3);
        VendaDAO v2 = new VendaDAO();
        v2.persist(v);

    }
}
