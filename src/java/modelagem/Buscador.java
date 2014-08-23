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
    private String texto;
    private String tipo;
    private Integer tipoView;
    private Map<String,Integer> lista;
    
    public Buscador() {
        texto = "";
        tipo = "";
    }
    
    @PostConstruct
    public void init() {
        lista = new HashMap<>();
        lista.put("Cliente", 1);
        lista.put("Venda", 2);
        lista.put("Produto", 3);
        lista.put("Material", 4);
        lista.put("Compra", 5);
        lista.put("Fornecedor", 6);
    }
    
    public String buscar(ActionEvent e) {
        tipoView = lista.get(tipo);
        String comp = e.getComponent().getId();
        return "search.xhtml#" + comp;
    }
    
    //public String getBuscar() {
    //    return buscar();
    //}
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public Map<String, Integer> getLista(){
        return lista;
    }
    
    public void setLista(HashMap<String, Integer> lista){
        this.lista = lista;
    }
}
