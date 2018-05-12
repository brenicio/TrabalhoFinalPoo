package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.CategoriaTO;

public class CategoriaDAO {
    public String incluir(CategoriaTO categoriaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO CATEGORIA (nomecategoria)"
                    + "VALUES ('" + categoriaTo.getNomeCategoria() + "')";
           // JOptionPane.showMessageDialog(null, categoriaTo.getNomeCategoria());
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public String alterar(CategoriaTO categoriaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;

            SQL = "UPDATE categoria SET nomeCategoria='" + categoriaTo.getNomeCategoria() + "' WHERE codcategoria="+categoriaTo.getCodCategoria()+"";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public CategoriaTO Consultar(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        CategoriaTO categoria = new CategoriaTO();
        SQL = "SELECT * FROM funcionario WHERE nomefunc LIKE '%" + nome + "%'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                categoria.setNomeCategoria(rs.getString("nomecategoria"));
                categoria.setCodCategoria(rs.getInt("codcategoria"));

            }
            return categoria;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return categoria;
    }

    public CategoriaTO ConsultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        CategoriaTO categoria = new CategoriaTO();
        SQL = "SELECT * FROM categoria WHERE codcategoria = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                categoria.setCodCategoria(rs.getInt("codcategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));

            }
            return categoria;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return categoria;
    }

    public ArrayList<CategoriaTO> consultarTodos() throws Exception {
        ArrayList<CategoriaTO> categoriaA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM categoria";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            CategoriaTO categoria = new CategoriaTO();
            categoria.setCodCategoria(rs.getInt("codcategoria"));
            categoria.setNomeCategoria(rs.getString("nomecategoria"));
            categoriaA.add(categoria);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return categoriaA;
    }
     public ArrayList<CategoriaTO> consultarTodosM(String nome) throws Exception {
        ArrayList<CategoriaTO> categoriaA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM categoria WHERE nomecategoria LIKE  '%"+nome+"%'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            CategoriaTO categoria = new CategoriaTO();
            categoria.setCodCategoria(rs.getInt("codcategoria"));
            categoria.setNomeCategoria(rs.getString("nomecategoria"));
            categoriaA.add(categoria);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return categoriaA;
    }

    public CategoriaTO VerificarCategoria(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        CategoriaTO categoria = new CategoriaTO();

        SQL = "SELECT * FROM categoria WHERE nomecategoria = '" + nome + "'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {

                categoria.setCodCategoria(rs.getInt("codcategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));

            }
            return categoria;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();
        return categoria;
    }

    public String excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM CATEGORIA WHERE CODCATEGORIA =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
return "";
    }
    
}
