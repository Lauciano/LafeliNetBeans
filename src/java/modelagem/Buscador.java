/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelagem;

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
    
    public Buscador() {
        texto = "";
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
}
