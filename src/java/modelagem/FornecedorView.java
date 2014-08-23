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
import persistencia.Compra;
import persistencia.CompraDAO;
import persistencia.Fornecedor;
import persistencia.FornecedorDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class FornecedorView implements Serializable {
     
    private List<Fornecedor> fornecedores;
 
    @PostConstruct
    public void init() {
        FornecedorDAO cdao= new FornecedorDAO();
        fornecedores = cdao.findAll();
    }
     
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
    
}
