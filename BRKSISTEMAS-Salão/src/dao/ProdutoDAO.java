package dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.CategoriaTO;
import to.MarcaTO;
import to.ProdutoTO;

public class ProdutoDAO {

    ProdutoTO produtoVenda = new ProdutoTO();

    public ProdutoTO getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(ProdutoTO produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public String incluir(ProdutoTO produtoTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO produto (codmarca,codbarra,codcat,descricaoprod,cmfoto,valorcusto,valorvenda,quantprod,lucroprod)"
                    + "VALUES (" + produtoTo.getCodMarca() + "," + produtoTo.getCodBarra() + "," + produtoTo.getCodCategoria() + ",'" + produtoTo.getDescrProd() + "','" + produtoTo.getCmFoto() + "','" + produtoTo.getValorCusto() + "','" + produtoTo.getValorVenda() + "'," + produtoTo.getQtdeProd() + ",'" + produtoTo.getLucroProd() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println("Erro ao inserir");
            throw e;
        }
    }

    public String alterar(ProdutoTO produtoTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE produto SET codmarca=" + produtoTo.getCodMarca() + ", codbarra=" + produtoTo.getCodBarra() + ", codcat=" + produtoTo.getCodCategoria() + ", descricaoprod='" + produtoTo.getDescrProd() + "', cmfoto='" + produtoTo.getCmFoto() + "', valorcusto='" + produtoTo.getValorCusto() + "',valorvenda='" + produtoTo.getValorVenda() + "', quantprod =" + produtoTo.getQtdeProd() + ", lucroprod='" + produtoTo.getLucroProd() + "'  WHERE codproduto = " + produtoTo.getCodProd() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public void alterarPMarca(ProdutoTO produtoTo, int marca) throws Exception {
        Conexao con = new Conexao();
        try {

            String SQL;

            SQL = "UPDATE produto SET valorcusto='" + produtoTo.getValorCusto() + "',valorvenda='" + produtoTo.getValorVenda() + "', lucroprod='" + produtoTo.getLucroProd() + "'  WHERE codmarca = " + marca + " and codproduto=" + produtoTo.getCodProd() + "";
            con.conectaBD();
            con.executaSQL(SQL);

        } catch (Exception e) {
            throw e;
        }
        con.desconectaBD();
    }

    public void alterarPCategoria(ProdutoTO produtoTo, int categoria) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE produto SET valorcusto='" + produtoTo.getValorCusto() + "',valorvenda='" + produtoTo.getValorVenda() + "', lucroprod='" + produtoTo.getLucroProd() + "'  WHERE codcat = " + categoria + " and codproduto =" + produtoTo.getCodProd() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();

        } catch (Exception e) {
            throw e;
        }
    }

    public ProdutoTO consultar(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ProdutoTO produto = new ProdutoTO();
        SQL = "SELECT codproduto,codbarra,descricaoprod,m.nomemarca,c.nomecategoria,valorvenda,valorcusto,quantprod,lucroprod,cmfoto,p.codmarca,p.codcat FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria and descricaoprod LIKE '%" + nome + "%'";
        con.conectaBD();
        try (ResultSet rs = con.executaConsulta(SQL)) {
            try {
                if (rs.next()) {

                    produto.setCodProd(rs.getInt("codproduto"));
                    produto.setCodBarra(rs.getInt("codbarra"));
                    produto.setDescrProd(rs.getString("descricaoprod"));
                    produto.setNomeMarca(rs.getString("nomemarca"));
                    produto.setCategoria(rs.getString("nomecategoria"));
                    produto.setValorVenda(rs.getDouble("valorvenda"));
                    produto.setValorCusto(rs.getInt("valorcusto"));
                    produto.setQtdeProd(rs.getInt("quantprod"));
                    produto.setLucroProd(rs.getDouble("lucroprod"));
                    produto.setCmFoto(rs.getString("cmfoto"));
                    produto.setCodMarca(rs.getInt("codmarca"));
                    produto.setCodCategoria(rs.getInt("codcat"));

                }
                return produto;
            } catch (Exception e) {
                System.out.println("Falha ao executar o sql e a pegar os dados");
            }
        }
        con.desconectaBD();

        return produto;
    }

    public ProdutoTO consultarID(int id) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ProdutoTO produto = new ProdutoTO();
        SQL = "SELECT codproduto,codbarra,descricaoprod,m.nomemarca,c.nomecategoria,valorvenda,valorcusto,quantprod,lucroprod,cmfoto,p.codmarca,p.codcat FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria and codbarra = " + id + "";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                produto.setCodProd(rs.getInt("codproduto"));
                produto.setCodBarra(rs.getInt("codbarra"));
                produto.setDescrProd(rs.getString("descricaoprod"));
                produto.setNomeMarca(rs.getString("nomemarca"));
                produto.setCategoria(rs.getString("nomecategoria"));
                produto.setValorVenda(rs.getDouble("valorvenda"));
                produto.setValorCusto(rs.getInt("valorcusto"));
                produto.setQtdeProd(rs.getInt("quantprod"));
                produto.setLucroProd(rs.getDouble("lucroprod"));
                produto.setCmFoto(rs.getString("cmfoto"));
                produto.setCodMarca(rs.getInt("codmarca"));
                produto.setCodCategoria(rs.getInt("codcat"));

            }
            return produto;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return produto;
    }

    public MarcaTO consultarNome(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        MarcaTO marca = new MarcaTO();
        SQL = "SELECT codmarca FROM marca WHERE nomemarca = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                marca.setCodMarca(rs.getInt("codmarca"));
            }
            return marca;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return marca;
    }

    public CategoriaTO consultarNome2(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        CategoriaTO categoria = new CategoriaTO();
        SQL = "SELECT codcategoria FROM categoria WHERE nomecategoria = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {
            if (rs.next()) {
                categoria.setCodCategoria(rs.getInt("codcategoria"));
            }
            return categoria;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return categoria;
    }

    public ProdutoTO consultarIDF(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        ProdutoTO produto = new ProdutoTO();
        SQL = "select * from usuario inner join funcionario on matriculafunc = matricula and matriculafunc= " + id + "";
        teste.conectaBD();
        try (ResultSet rs = teste.executaConsulta(SQL)) {
            try {
                if (rs.next()) {

                    produto.setCategoria(rs.getString("categoria"));
                    produto.setCmFoto(rs.getString("cmfoto"));
                    produto.setCodBarra(rs.getInt("codbarra"));
                    produto.setCodMarca(rs.getInt("codmarca"));
                    produto.setCodProd(rs.getInt("codproduto"));
                    produto.setDescrProd(rs.getString("descricaoprod"));
                    produto.setLucroProd(rs.getDouble("lucroprod"));
                    produto.setQtdeProd(rs.getInt("quantprod"));
                    produto.setValorCusto(rs.getInt("valorcusto"));
                    produto.setValorVenda(rs.getDouble("valorvenda"));

                }
                return produto;
            } catch (Exception e) {
                System.out.println("Falha ao executar o sql e a pegar os dados");
            }
        }
        teste.desconectaBD();

        return produto;
    }

    public ArrayList<ProdutoTO> consultarTodosManutencao() throws Exception {
        ArrayList<ProdutoTO> proA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT p.codmarca,p.codcat,codproduto,valorvenda,valorcusto,lucroprod FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ProdutoTO produto = new ProdutoTO();
            produto.setCodProd(rs.getInt("codproduto"));
            // produto.setCodBarra(rs.getInt("codbarra"));
            // produto.setDescrProd(rs.getString("descricaoprod"));
            // produto.setNomeMarca(rs.getString("nomemarca"));
            // produto.setCategoria(rs.getString("nomecategoria"));
            produto.setValorVenda(rs.getDouble("valorvenda"));
            produto.setValorCusto(rs.getInt("valorcusto"));
            //produto.setQtdeProd(rs.getInt("quantprod"));
            produto.setLucroProd(rs.getDouble("lucroprod"));
            // produto.setCmFoto(rs.getString("cmfoto"));
            produto.setCodMarca(rs.getInt("codmarca"));
            produto.setCodCategoria(rs.getInt("codcat"));

            proA.add(produto);

        }
        rs.close();
        con.desconectaBD();
        return proA;
    }

    public ArrayList<ProdutoTO> consultarTodos() throws Exception {
        ArrayList<ProdutoTO> proA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT codproduto,codbarra,descricaoprod,m.nomemarca,c.nomecategoria,valorvenda,valorcusto,quantprod,lucroprod,cmfoto,p.codmarca,p.codcat FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ProdutoTO produto = new ProdutoTO();
            produto.setCodProd(rs.getInt("codproduto"));
            produto.setCodBarra(rs.getInt("codbarra"));
            produto.setDescrProd(rs.getString("descricaoprod"));
            produto.setNomeMarca(rs.getString("nomemarca"));
            produto.setCategoria(rs.getString("nomecategoria"));
            produto.setValorVenda(rs.getDouble("valorvenda"));
            produto.setValorCusto(rs.getInt("valorcusto"));
            produto.setQtdeProd(rs.getInt("quantprod"));
            produto.setLucroProd(rs.getDouble("lucroprod"));
            produto.setCmFoto(rs.getString("cmfoto"));
            produto.setCodMarca(rs.getInt("codmarca"));
            produto.setCodCategoria(rs.getInt("codcat"));

            proA.add(produto);

        }
        rs.close();
        con.desconectaBD();
        return proA;
    }

    public ArrayList<String> consultarMarca() throws Exception {
        ArrayList<String> marcas = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM MARCA";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            MarcaTO marca = new MarcaTO();
            marca.setCodMarca(rs.getInt("codmarca"));
            marca.setNomeMarca(rs.getString("nomemarca"));
            marcas.add(rs.getString("nomemarca"));

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return marcas;
    }

    public ArrayList<String> consultarCategoria() throws Exception {
        ArrayList<String> categorias = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM CATEGORIA";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            CategoriaTO categoria = new CategoriaTO();
            categoria.setCodCategoria(rs.getInt("codcategoria"));
            categoria.setNomeCategoria(rs.getString("nomecategoria"));
            categorias.add(rs.getString("nomecategoria"));

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return categorias;
    }

    public ArrayList<ProdutoTO> consultarTodosP(String nome) throws Exception {
        ArrayList<ProdutoTO> produtoA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT codproduto,codbarra,descricaoprod,m.nomemarca,c.nomecategoria,valorvenda,valorcusto,quantprod,lucroprod,cmfoto,p.codmarca,p.codcat FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria and descricaoprod LIKE '%" + nome + "%'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ProdutoTO produto = new ProdutoTO();
            produto.setCodProd(rs.getInt("codproduto"));
            produto.setCodBarra(rs.getInt("codbarra"));
            produto.setDescrProd(rs.getString("descricaoprod"));
            produto.setNomeMarca(rs.getString("nomemarca"));
            produto.setCategoria(rs.getString("nomecategoria"));
            produto.setValorVenda(rs.getDouble("valorvenda"));
            produto.setValorCusto(rs.getInt("valorcusto"));
            produto.setQtdeProd(rs.getInt("quantprod"));
            produto.setLucroProd(rs.getDouble("lucroprod"));
            produto.setCmFoto(rs.getString("cmfoto"));
            produto.setCodMarca(rs.getInt("codmarca"));
            produto.setCodCategoria(rs.getInt("codcat"));
            produtoA.add(produto);

        }
        rs.close();
        con.desconectaBD();
        return produtoA;
    }

    public ArrayList<ProdutoTO> ConsultarProdVenda(int id, int quantidadeTotal, BigDecimal valorTotal) throws Exception {
        ArrayList<ProdutoTO> produtoA = new ArrayList();

        Conexao con = new Conexao();
        String SQL;

        SQL = "SELECT codproduto,codbarra,descricaoprod,m.nomemarca,c.nomecategoria,valorvenda,valorcusto,quantprod,lucroprod,cmfoto,p.codmarca,p.codcat FROM PRODUTO p, MARCA m, CATEGORIA c WHERE p.codmarca = m.codmarca and p.codcat = c.codcategoria and codbarra = " + id + "";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            while (rs.next()) {

                produtoVenda.setCodProd(rs.getInt("codproduto"));
                produtoVenda.setCodBarra(rs.getInt("codbarra"));
                produtoVenda.setDescrProd(rs.getString("descricaoprod"));
                produtoVenda.setNomeMarca(rs.getString("nomemarca"));
                produtoVenda.setCategoria(rs.getString("nomecategoria"));
                produtoVenda.setValorVenda(rs.getDouble("valorvenda"));
                produtoVenda.setValorCusto(rs.getInt("valorcusto"));
                produtoVenda.setQtdeProd(rs.getInt("quantprod"));
                produtoVenda.setLucroProd(rs.getDouble("lucroprod"));
                produtoVenda.setCmFoto(rs.getString("cmfoto"));
                produtoVenda.setCodMarca(rs.getInt("codmarca"));
                produtoVenda.setCodCategoria(rs.getInt("codcat"));
                produtoVenda.setQuantidadetotal(quantidadeTotal);
                produtoVenda.setValortotal(valorTotal);
                produtoA.add(produtoVenda);
            }
            return produtoA;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return produtoA;
    }

    public ProdutoTO VerificarProduto(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        ProdutoTO produto = new ProdutoTO();

        SQL = "SELECT codproduto, descricaoprod FROM produto WHERE descricaoprod = '" + nome + "'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {

                produto.setCodProd(rs.getInt("codproduto"));
                produto.setDescrProd(rs.getString("descricaoprod"));

            }
            return produto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();
        return produto;
    }

    public String excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM PRODUTO WHERE CODPRODUTO =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!!");
        return "";
    }

}
