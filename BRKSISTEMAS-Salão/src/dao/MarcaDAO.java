package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.MarcaTO;

public class MarcaDAO {

    public String incluir(MarcaTO marcaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO marca (nomemarca)"
                    + "VALUES ('" + marcaTo.getNomeMarca() + "')";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public String alterar(MarcaTO marcaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;

            SQL = "UPDATE marca SET nomemarca='" + marcaTo.getNomeMarca() + "' WHERE codmarca=" + marcaTo.getCodMarca() + "";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public MarcaTO consultar(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        MarcaTO marca = new MarcaTO();
        SQL = "SELECT * FROM funcionario WHERE nomefunc LIKE '%" + nome + "%'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {
                marca.setNomeMarca(rs.getString("nomemarca"));
                marca.setCodMarca(rs.getInt("codmarca"));
            }
            return marca;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return marca;
    }

    public MarcaTO consultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        MarcaTO marca = new MarcaTO();
        SQL = "SELECT * FROM marca WHERE codmarca = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                marca.setCodMarca(rs.getInt("codmarca"));
                marca.setNomeMarca(rs.getString("nomemarca"));

            }
            return marca;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return marca;
    }

    public ArrayList<MarcaTO> consultarTodos() throws Exception {
        ArrayList<MarcaTO> marcaA = new ArrayList();
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
            marcaA.add(marca);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return marcaA;
    }

    public ArrayList<MarcaTO> consultarTodosM(String nome) throws Exception {
        ArrayList<MarcaTO> marcaA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM MARCA WHERE nomemarca LIKE  '%" + nome + "%'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            MarcaTO marca = new MarcaTO();
            marca.setCodMarca(rs.getInt("codmarca"));
            marca.setNomeMarca(rs.getString("nomemarca"));
            marcaA.add(marca);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return marcaA;
    }

    public MarcaTO verificarMarca(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        MarcaTO marca = new MarcaTO();

        SQL = "SELECT nomemarca,codmarca FROM marca WHERE nomemarca = '" + nome + "'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {

                marca.setCodMarca(rs.getInt("codmarca"));
                marca.setNomeMarca(rs.getString("nomemarca"));
            }
            return marca;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();
        return marca;
    }

    public String excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM MARCA WHERE CODMARCA =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        return "";
    }
}
