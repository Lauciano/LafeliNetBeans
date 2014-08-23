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
import persistencia.Cliente;
import persistencia.ClienteDAO;
import persistencia.Venda;
import persistencia.VendaDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class VendaView implements Serializable {
     
    private List<Venda> vendas;
 
    @PostConstruct
    public void init() {
        VendaDAO vdao= new VendaDAO();
        vendas = vdao.findAll();
    }
     
    public List<Venda> getVendas() {
        return vendas;
    }
    
}
