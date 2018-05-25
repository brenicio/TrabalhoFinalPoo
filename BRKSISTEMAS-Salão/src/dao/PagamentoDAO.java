package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.PagamentoTO;

public class PagamentoDAO {

    public String incluir(PagamentoTO pagamentoTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO  formapagamento(descpagamento,tipopagamento,qtdparcela)"
                    + "VALUES ('" + pagamentoTo.getDescpagamento() + "','" + pagamentoTo.getTipopagamento() + "'," + pagamentoTo.getQtdparcela() + ")";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public String alterar(PagamentoTO pagamentoTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;

            SQL = "UPDATE formapagamento SET descpagamento='" + pagamentoTo.getDescpagamento() + "', tipopagamento='" + pagamentoTo.getTipopagamento() + "', qtdparcela=" + pagamentoTo.getQtdparcela() + " WHERE codformapagamento=" + pagamentoTo.getCodformapagamento() + "";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";

        } catch (Exception e) {
            throw e;
        }
    }

    public PagamentoTO Consultar(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        PagamentoTO pagamento = new PagamentoTO();
        SQL = "SELECT * FROM formapagamento WHERE descpagamento LIKE '%" + nome + "%'";
        con.conectaBD();
        try (ResultSet rs = con.executaConsulta(SQL)) {
            try {
                if (rs.next()) {
                    pagamento.setDescpagamento(rs.getString("descpagamento"));
                    pagamento.setCodformapagamento(rs.getInt("codformapagamento"));
                    pagamento.setTipopagamento(rs.getString("tipopagamento"));
                    pagamento.setQtdparcela(rs.getInt("qtdparcela"));
                }
                return pagamento;
            } catch (Exception e) {
                System.out.println("Falha ao executar o sql e a pegar os dados");
            }
        }
        con.desconectaBD();

        return pagamento;
    }

    public PagamentoTO consultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        PagamentoTO pagamento = new PagamentoTO();
        SQL = "SELECT * FROM formapagamento WHERE codformapagamento = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                pagamento.setDescpagamento(rs.getString("descpagamento"));
                pagamento.setCodformapagamento(rs.getInt("codformapagamento"));
                pagamento.setTipopagamento(rs.getString("tipopagamento"));
                pagamento.setQtdparcela(rs.getInt("qtdparcela"));

            }
            return pagamento;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return pagamento;
    }

    public ArrayList<PagamentoTO> consultarTodos() throws Exception {
        ArrayList<PagamentoTO> pagamentoA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM FORMAPAGAMENTO";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            PagamentoTO pagamento = new PagamentoTO();
            pagamento.setDescpagamento(rs.getString("descpagamento"));
            pagamento.setCodformapagamento(rs.getInt("codformapagamento"));
            pagamento.setTipopagamento(rs.getString("tipopagamento"));
            pagamento.setQtdparcela(rs.getInt("qtdparcela"));
            pagamentoA.add(pagamento);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return pagamentoA;
    }

    public ArrayList<PagamentoTO> consultarTodosP(String nome) throws Exception {
        ArrayList<PagamentoTO> pagamentoA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM FORMAPAGAMENTO WHERE descpagamento LIKE  '%" + nome + "%'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            PagamentoTO pagamento = new PagamentoTO();
            pagamento.setDescpagamento(rs.getString("descpagamento"));
            pagamento.setCodformapagamento(rs.getInt("codformapagamento"));
            pagamento.setTipopagamento(rs.getString("tipopagamento"));
            pagamento.setQtdparcela(rs.getInt("qtdparcela"));
            pagamentoA.add(pagamento);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return pagamentoA;
    }

    public PagamentoTO verificarPagamento(PagamentoTO pagTo) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        PagamentoTO pagamento = new PagamentoTO();

        SQL = "SELECT * FROM formapagamento WHERE descpagamento = '" + pagTo.getDescpagamento() + "' and tipopagamento='" + pagTo.getTipopagamento() + "' and qtdparcela=" + pagTo.getQtdparcela() + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {

                pagamento.setDescpagamento(rs.getString("descpagamento"));
                pagamento.setCodformapagamento(rs.getInt("codformapagamento"));
                pagamento.setTipopagamento(rs.getString("tipopagamento"));
                pagamento.setQtdparcela(rs.getInt("qtdparcela"));
            }
            return pagamento;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();
        return pagamento;
    }

    public String excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM FORMAPAGAMENTO WHERE CODFORMAPAGAMENTO =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        return "";
    }
}
