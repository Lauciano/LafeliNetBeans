/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelagem;

import controle.Car;
import controle.CarService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import persistencia.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@ViewScoped
public class ClienteView implements Serializable {
     
    private List<Cliente> clientes;
 
    @PostConstruct
    public void init() {
        ClienteDAO cdao= new ClienteDAO();
        clientes = cdao.findAll();
    }
     
    public List<Cliente> getClientes() {
        return clientes;
    }
    
}
