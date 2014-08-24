/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Lauciano FA
 */
@ManagedBean
@SessionScoped
public class Buscador {
    private String tipo = "";
    private Integer tipoView;
    private Map<String,Integer> lista;
    
    public Buscador() {
    }
    
    @PostConstruct
    public void init() {
        lista = new HashMap<String,Integer>();
        lista.put("Cliente", 1);
        lista.put("Venda", 2);
        lista.put("Produto", 3);
        lista.put("Material", 4);
        lista.put("Compra", 5);
        lista.put("Fornecedor", 6);
    }
    
    public String buscar() {
        System.err.println("Pegando " + tipo);
        tipoView = lista.get(tipo);
        return "search";
    }
    
    public String buscarCliente() {
        System.err.println("Pegando Cliente");
        tipo = "Cliente";
        tipoView = 1;
        return "search";
    }
    
    public String buscarVenda() {
        System.err.println("Pegando Venda");
        tipo = "Venda";
        tipoView = 2;
        return "search";
    }
    
    public String buscarProduto() {
        System.err.println("Pegando Produto");
        tipo = "Produto";
        tipoView = 3;
        return "search";
    }
    
    public String buscarMaterial() {
        System.err.println("Pegando Material");
        tipo = "Material";
        tipoView = 4;
        return "search";
    }
    
    public String buscarCompra() {
        System.err.println("Pegando Compra");
        tipo = "Compra";
        tipoView = 5;
        return "search";
    }
    
    public String buscarFornecedor() {
        System.err.println("Pegando Fornecedor");
        tipo = "Fornecedor";
        tipoView = 6;
        return "search";
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        System.out.println("SETANDO TIPO COMO" + tipo);
        this.tipo = tipo;
    }
    
    public Map<String, Integer> getLista(){
        return lista;
    }
    
    public void setLista(HashMap<String, Integer> lista){
        this.lista = lista;
    }

    public Integer getTipoView() {
        return tipoView;
    }

    public void setTipoView(Integer tipoView) {
        this.tipoView = tipoView;
    }
    
    
}
