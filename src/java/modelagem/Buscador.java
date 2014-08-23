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

/**
 *
 * @author Lauciano FA
 */
@ManagedBean
@SessionScoped
public class Buscador {
    private String texto;
    private String tipo;
    private Map<String,String> lista;
    
    public Buscador() {
        texto = "";
        tipo = "";
    }
    
    @PostConstruct
    public void init() {
        lista = new HashMap<>();
        lista.put("Cliente", "Cliente");
        lista.put("Venda", "Venda");
        lista.put("Produto", "Produto");
        lista.put("Material", "Material");
        lista.put("Compra", "Compra");
        lista.put("Fornecedor", "Fornecedor");
    }
    
    public String buscar() {
        return "";
    }
    
    public String getBuscar() {
        return buscar();
    }
    
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
    
    public Map<String, String> getLista(){
        return lista;
    }
    
    public void setLista(HashMap<String, String> lista){
        this.lista = lista;
    }
}
