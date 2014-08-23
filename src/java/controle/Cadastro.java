/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Thiago
 */
@ManagedBean
@SessionScoped
public class Cadastro {
    
    private int tipoCadastro;
    
    public Cadastro(){
        tipoCadastro = -1;
    }
    
    public String setTipoCadastro(ActionEvent e){
        
        String nome = e.getComponent().getId();
        
        if(nome.equals("clientecd")) tipoCadastro = 1;
        else if(nome.equals("produtocd")) tipoCadastro = 3;
        else if(nome.equals("compracd")) tipoCadastro = 5;
        else if(nome.equals("vendacd")) tipoCadastro = 2;
        else if(nome.equals("fornecedorcd")) tipoCadastro = 6;
        else tipoCadastro = 4;
        
        System.out.println("Tipo = " + tipoCadastro);
        
        return "cadastro";
        
    }
    
    public String getSetTipoCadastro(ActionEvent e){
        return setTipoCadastro(e);
    }

    public int getTipoCadastro() {
        System.out.println("Pegando valor " + tipoCadastro);
        return tipoCadastro;
    }

    public void setTipoCadastro(int tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }
    
    
    
}
