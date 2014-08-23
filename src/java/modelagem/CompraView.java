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
import persistencia.Material;
import persistencia.MaterialDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class CompraView implements Serializable {
     
    private List<Compra> compras;
 
    @PostConstruct
    public void init() {
        CompraDAO cdao= new CompraDAO();
        compras = cdao.findAll();
    }
     
    public List<Compra> getCompras() {
        return compras;
    }
    
}