package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.ServicoTO;

public class ServicoDAO {

    public ServicoDAO() throws Exception {

    }

    public String incluir(ServicoTO servicoTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO SERVICO (descricao)" + "VALUES ('" + servicoTo.getDescrServico() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();

            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public String alterar(ServicoTO servicoTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE SERVICO SET descricao='" + servicoTo.getDescrServico() + "' WHERE codservico=" + servicoTo.getCodServico() + "";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public ServicoTO Consultar(String descricao) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ServicoTO serv = new ServicoTO();
        SQL = "SELECT * FROM servico WHERE descricao LIKE '%" + descricao + "%'";
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
        }
        rs.close();
        con.desconectaBD();

        return serv;
    }

    public ServicoTO ConsultarID(int id) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ServicoTO serv = new ServicoTO();
        SQL = "SELECT * FROM SERVICO WHERE codservico = " + id + "";
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
        }
        rs.close();
        con.desconectaBD();

        return serv;
    }

    public ArrayList<ServicoTO> consultarTodos() throws Exception {
        ArrayList<ServicoTO> servA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM SERVICO";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ServicoTO serv = new ServicoTO();
            serv.setCodServico(rs.getInt("codservico"));
            serv.setDescrServico(rs.getString("descricao"));
            servA.add(serv);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return servA;
    }

    public String excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        try{
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM SERVICO WHERE CODSERVICO =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            return ex.getMessage();
        }
        return "";

    }

    public ArrayList<ServicoTO> consultarTodosC(String nome) throws Exception {
        ArrayList<ServicoTO> servicoA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * from SERVICO WHERE descricao LIKE '%" + nome + "%'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ServicoTO serv = new ServicoTO();
            serv.setCodServico(rs.getInt("codservico"));
            serv.setDescrServico(rs.getString("descricao"));
            servicoA.add(serv);

        }
        rs.close();
        con.desconectaBD();
        return servicoA;
    }
    public ServicoTO VerificarServicos(String descricao) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ServicoTO serv = new ServicoTO();
        SQL = "SELECT * FROM servico WHERE descricao = '" + descricao + "'";
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
        }
        rs.close();
        con.desconectaBD();

        return serv;
    }
}
