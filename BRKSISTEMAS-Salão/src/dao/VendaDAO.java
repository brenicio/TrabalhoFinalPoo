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
import to.ClienteTO;
import to.EntradaCaixaTO;
import to.FuncionarioTO;
import to.ItemVendaTO;
import to.ProdutoTO;
import to.ServicoTO;
import to.VendaTO;

/**
 *
 * @author Brenicio
 */
public class VendaDAO {

    public String incluirVenda(VendaTO vendaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO venda (codusuario,codformapagamento,descricaoven,dataven,horaven,totalven,observacoes,codcliente,tipo)"
                    + "VALUES (" + vendaTo.getCodusuario() + "," + vendaTo.getCodformapagamento() + ",'" + vendaTo.getDescricaoven() + "','" + vendaTo.getDataven() + "','" + vendaTo.getHoraven() + "','" + vendaTo.getTotalven() + "','" + vendaTo.getObservacoes() + "'," + vendaTo.getCodCliente() + ",'" + vendaTo.getTipo() + "')";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados VENDA");
            throw e;
        }

    }

    public String incluirItemVenda(ItemVendaTO itemTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            teste.conectaBD();

            SQL = "INSERT INTO itenvenda (codvenda,codservico,codfuncionario,precounit)"
                    + "VALUES (" + itemTo.getCodvenda() + "," + itemTo.getCodServico() + "," + itemTo.getCodFuncionario() + ",'" + itemTo.getPrecoUnit() + "')";

            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;

    }

    public String incluirItemVendaProd(ItemVendaTO itemTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            teste.conectaBD();

            SQL = "INSERT INTO itenvendaprod (codvenda,codbarra,qtdeven)"
                    + "VALUES (" + itemTo.getCodvenda() + "," + itemTo.getCodproduto() + "," + itemTo.getQtde() + ")";

            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;

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
           System.out.println("Erro Venda: "+e.getMessage());
           return "erro";
        }

    }

    public ArrayList<String> consultarMarca() throws Exception {
        ArrayList<String> funcionarios = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM FUNCIONARIO";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            FuncionarioTO func = new FuncionarioTO();
            func.setMatricula(rs.getInt("matricula"));
            func.setNome(rs.getString("nomefunc"));
            funcionarios.add(rs.getString("nomefunc"));

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return funcionarios;
    }

    public FuncionarioTO ConsultarNOMEFuncionario(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        FuncionarioTO func = new FuncionarioTO();
        SQL = "SELECT matricula FROM funcionario WHERE nomefunc = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                func.setMatricula(rs.getInt("matricula"));
            }
            return func;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
            System.out.println("Funcionario");
            System.out.println(nome);
        }
        rs.close();
        con.desconectaBD();

        return func;
    }

    public ClienteTO ConsultarNOMECliente(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT codcliente FROM cliente WHERE nome = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
            System.out.println("Cliente");
            System.out.println(nome);
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }

    public ServicoTO ConsultarNOMEServico(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ServicoTO serv = new ServicoTO();
        SQL = "SELECT * FROM servico WHERE descricao = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                serv.setCodServico(rs.getInt("codservico"));
                serv.setDescrServico(rs.getString("descricao"));
            }
            return serv;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
            System.out.println("Servico");
            System.out.println(nome);
        }
        rs.close();
        con.desconectaBD();

        return serv;
    }

}
