/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.CaixaTO;
import to.EntradaCaixaTO;
import to.ItemVendaTO;
import to.ProdutoTO;
import to.VendaTO;

/**
 *
 * @author Brenicio
 */
public class VendaProdDAO {

    public String incluirVenda(VendaTO vendaTo) throws Exception {
        try {
//            JOptionPane.showMessageDialog(null, vendaTo.getCodusuario());
//            JOptionPane.showMessageDialog(null, vendaTo.getCodformapagamento());
//            // JOptionPane.showMessageDialog(null, vendaTo.getCodvenda());
//            JOptionPane.showMessageDialog(null, vendaTo.getDataven());
//            JOptionPane.showMessageDialog(null, vendaTo.getDescricaoven());
//            JOptionPane.showMessageDialog(null, vendaTo.getHoraven());
//            JOptionPane.showMessageDialog(null, vendaTo.getObservacoes());
//            // JOptionPane.showMessageDialog(null, vendaTo.getPrecoven());
//            //  JOptionPane.showMessageDialog(null, vendaTo.getStatusven());
//            JOptionPane.showMessageDialog(null, vendaTo.getTotalven());
//            // JOptionPane.showMessageDialog(null, vendaTo.getTrocoven());
            Conexao teste = new Conexao();
            String SQL;
            teste.conectaBD();
            SQL = "INSERT INTO venda (codusuario,codformapagamento,descricaoven,dataven,horaven,totalven,observacoes)"
                    + "VALUES (" + vendaTo.getCodusuario() + "," + vendaTo.getCodformapagamento() + ",'" + vendaTo.getDescricaoven() + "','" + vendaTo.getDataven() + "','" + vendaTo.getHoraven() + "','" + vendaTo.getTotalven() + "','" + vendaTo.getObservacoes() + "')";
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";

    }

    public String incluirItemVenda(ItemVendaTO itemTo) throws Exception {
        try {
            JOptionPane.showMessageDialog(null, itemTo.getCodvenda());
            JOptionPane.showMessageDialog(null, itemTo.getCodproduto());
            JOptionPane.showMessageDialog(null, itemTo.getQtde());
            Conexao teste = new Conexao();
            teste.conectaBD();
            String SQL;
            SQL = "INSERT INTO itenvenda (codvenda,codbarra,qtdeven)"
                    + "VALUES (" + itemTo.getCodvenda() + "," + itemTo.getCodproduto() + "," + itemTo.getQtde() + ")";

            teste.executaSQL(SQL);
            teste.desconectaBD();
            // JOptionPane.showMessageDialog(null, "Depois da inserção do item!");
            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public VendaTO ConsultarID() throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        VendaTO venda = new VendaTO();
        SQL = "SELECT codvenda FROM venda ORDER BY codvenda DESC LIMIT 1";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                venda.setCodvenda(rs.getInt("codvenda"));
            }
            return venda;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return venda;
    }

    public ProdutoTO ConsultarItemID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        ProdutoTO produto = new ProdutoTO();
        ArrayList<ProdutoTO> produtos = new ArrayList();
        SQL = "SELECT * FROM produto where codbarra = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {
                produto.setCodBarra(rs.getInt("codbarra"));
                produto.setQtdeProd(rs.getInt("quantprod"));
                produto.setDescrProd(rs.getString("descricaoprod"));
                // produtos.add(produto);
            }
            return produto;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return produto;
    }

    public void alterarQuantidadeProdutos(ProdutoTO prodTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE produto SET quantprod=" + prodTo.getQtdeProd() + " WHERE codbarra=" + prodTo.getCodBarra() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();

        } catch (Exception e) {
            throw e;
        }
    }

    public String EntradaCaixa(EntradaCaixaTO entradaTo) {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO entradacaixa (codcaixa,descricao,dataentradac,hora,valor,codusuario,tipomov) VALUES(" + entradaTo.getCodCaixa() + ",'" + entradaTo.getDescricao() + "','" + entradaTo.getDataEntracaC() + "','" + entradaTo.getHora() + "','" + entradaTo.getValor() + "'," + entradaTo.getCodUsuario() + ",'" + entradaTo.getTipoMovimentacao() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }

    }

}
