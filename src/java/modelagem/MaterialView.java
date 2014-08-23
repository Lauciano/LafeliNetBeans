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
import persistencia.Material;
import persistencia.MaterialDAO;
import persistencia.Produto;
import persistencia.ProdutoDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class MaterialView implements Serializable {
     
    private List<Material> materiais;
 
    @PostConstruct
    public void init() {
        MaterialDAO mdao= new MaterialDAO();
        materiais = mdao.findAll();
    }
     
    public List<Material> getMateriais() {
        return materiais;
    }
    
}

