/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelagem;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistencia.Produto;
import persistencia.ProdutoDAO;
import persistencia.Venda;
import persistencia.VendaDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class ProdutoView implements Serializable {
     
    private List<Produto> produtos;
 
    @PostConstruct
    public void init() {
        ProdutoDAO pdao= new ProdutoDAO();
        produtos = pdao.findAll();
    }
     
    public List<Produto> getProdutos() {
        return produtos;
    }
    
}
