/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelagem;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencia.Cliente;
import persistencia.ClienteDAO;
import persistencia.Compra;
import persistencia.CompraDAO;
import persistencia.Fornecedor;
import persistencia.FornecedorDAO;
import persistencia.Material;
import persistencia.MaterialDAO;
import persistencia.Produto;
import persistencia.ProdutoDAO;
import persistencia.Venda;
import persistencia.VendaDAO;

/**
 *
 * @author Thiago
 */
@ManagedBean
@SessionScoped
public class DeleteUpdate {
    
    private int id;
    private int att;
    
    private Cliente c;
    private Produto p;
    private Venda v;
    private Material m;
    private Compra cm;
    private Fornecedor f;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }
    
    public String updateCliente(){
        att = 1;
        ClienteDAO cdao = new ClienteDAO();
        c = cdao.getById(id);
        return "atualizacao";
    }
    
    public String updateVenda(){
        att = 2;
        VendaDAO vdao = new VendaDAO();
        v = vdao.getById(id);
        return "atualizacao";
    }
    
    public String updateProduto(){
        att = 3;
        ProdutoDAO pdao = new ProdutoDAO();
        p = pdao.getById(id);
        return "atualizacao";
    }
    
    public String updateMaterial(){
        att = 4;
        MaterialDAO mdao = new MaterialDAO();
        m = mdao.getById(id);
        return "atualizacao";
    }
    
    public String updateCompra(){
        att = 5;
        CompraDAO cdao = new CompraDAO();
        cm = cdao.getById(id);
        return "atualizacao";
    }
    
    public String updateFornecedor(){
        att = 6;
        FornecedorDAO fdao = new FornecedorDAO();
        f = fdao.getById(id);
        return "atualizacao";
    }
    
    public String deleteCliente(){
        ClienteDAO d = new ClienteDAO();
        d.removeById(id);
        return "search";
    }
    
    public String deleteVenda(){
        VendaDAO d = new VendaDAO();
        d.removeById(id);
        return "search";
    }
    
    public String deleteProduto(){
        ProdutoDAO d = new ProdutoDAO();
        d.removeById(id);
        return "search";
    }
    
    public String deleteMaterial(){
        MaterialDAO d = new MaterialDAO();
        d.removeById(id);
        return "search";
    }
    
    public String deleteCompra(){
        CompraDAO d = new CompraDAO();
        d.removeById(id);
        return "search";
    }
    
    public String deleteFornecedor(){
        FornecedorDAO d = new FornecedorDAO();
        d.removeById(id);
        return "search";
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public Venda getV() {
        return v;
    }

    public void setV(Venda v) {
        this.v = v;
    }

    public Material getM() {
        return m;
    }

    public void setM(Material m) {
        this.m = m;
    }

    public Compra getCm() {
        return cm;
    }

    public void setCm(Compra cm) {
        this.cm = cm;
    }

    public Fornecedor getF() {
        return f;
    }

    public void setF(Fornecedor f) {
        this.f = f;
    }
    
    public String commitCliente(){
        ClienteDAO c = new ClienteDAO();
        c.merge(this.c);
        return "search";
    }
    
    public String commitProduto(){
        ProdutoDAO c = new ProdutoDAO();
        c.merge(this.p);
        return "search";
    }
    
    public String commitMaterial(){
        MaterialDAO c = new MaterialDAO();
        c.merge(this.m);
        return "search";
    }
    
    public String commitVenda(){
        VendaDAO c = new VendaDAO();
        c.merge(this.v);
        return "search";
    }
    
    public String commitCompra(){
        CompraDAO c = new CompraDAO();
        c.merge(this.cm);
        return "search";
    }
    
    public String commitFornecedor(){
        FornecedorDAO c = new FornecedorDAO();
        c.merge(this.f);
        return "search";
    }
    
}
