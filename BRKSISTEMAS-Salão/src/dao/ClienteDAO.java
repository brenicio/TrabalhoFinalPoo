package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import to.PessoasTO;
import to.ClienteTO;

public class ClienteDAO implements PessoasDAO {

    @Override
    public String Incluir(PessoasTO p) {
        ClienteTO clienteTo;
        clienteTo = (ClienteTO) p;
        try {

            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO CLIENTE (nome,rg,sexo,cpf,telfixo,telcelular,email,endereco,bairro,cidade,foto,status,dataprivisita,dataultvisita,datacadastro)"
                    + "VALUES ('" + clienteTo.getNome() + "','" + clienteTo.getRg() + "','" + clienteTo.getSexo() + "','" + clienteTo.getCpf() + "','" + clienteTo.getTelefone() + "','" + clienteTo.getCelular() + "','" + clienteTo.getEmail() + "',"
                    + "'" + clienteTo.getEndereco() + "','" + clienteTo.getBairro() + "','" + clienteTo.getCidade() + "','" + clienteTo.getCmfotoCli() + "','" + clienteTo.getStatusCli() + "','" + clienteTo.getDatapriVisita() + "','" + clienteTo.getDataultVisita() + "','" + clienteTo.getDataCadastro() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();

        } catch (Exception e) {
            System.out.println("Erro ao Inlcuir: " + e.getMessage());

        }
        return "";
    }

    @Override
    public String Alterar(PessoasTO p) {
        ClienteTO clienteTo;
        clienteTo = (ClienteTO) p;
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET nome='" + clienteTo.getNome() + "', rg = '" + clienteTo.getRg() + "', sexo='" + clienteTo.getSexo() + "', cpf = '" + clienteTo.getCpf() + "',telfixo = '" + clienteTo.getTelefone() + "', telcelular = '" + clienteTo.getCelular() + "', email = '" + clienteTo.getEmail() + "', "
                    + "endereco ='" + clienteTo.getEndereco() + "',bairro = '" + clienteTo.getBairro() + "',cidade = '" + clienteTo.getCidade() + "',foto = '" + clienteTo.getCmfotoCli() + "',status = '" + clienteTo.getStatusCli() + "', dataultvisita='" + clienteTo.getDataultVisita() + "',datacadastro='" + clienteTo.getDataCadastro() + "' WHERE codcliente=" + clienteTo.getCodCliente() + "";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
        } catch (Exception e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
        }
        return "";
    }

    public String AtualizarDataVisita(int codCliente) {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET dataultvisita='" + getDate() + "' WHERE codcliente=" + codCliente + "";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "";
    }

    @Override
    public PessoasTO Consultar(String nome) {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%'";
        try {

            con.conectaBD();
            ResultSet rs = con.executaConsulta(SQL);

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            rs.close();
            con.desconectaBD();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return cli;
    }

    public PessoasTO Consultar(int id) {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM CLIENTE WHERE codcliente = " + id + "";
        try {

            con.conectaBD();
            ResultSet rs = con.executaConsulta(SQL);

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            rs.close();
            con.desconectaBD();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return cli;
    }

    @Override
    public ArrayList<PessoasTO> ConsultarTodos() {
        ArrayList<PessoasTO> p = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        try {
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "SELECT * FROM CLIENTE";
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                ClienteTO cli = new ClienteTO();
                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));
                cli.setCmfotoCli(rs.getString("foto"));
                p.add(cli);

            }
            //************************************************************

            //RETORNA O ARRAYLIST PARA O BO
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return p;
    }

    @Override
    public void ExcluirID(long ID) {
        try {
            //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
            //************************************************************
            //ABRE CONEXAO COM O BANCO
            //************************************************************
            Conexao con = new Conexao();
            String SQL;
            con.conectaBD();
            SQL = "DELETE FROM CLIENTE WHERE CODCLIENTE =" + ID + "";
            con.executaSQL(SQL);
            con.desconectaBD();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ArrayList<PessoasTO> ConsultarTodos(String nome) {
        ArrayList<PessoasTO> p = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO

        try {
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "SELECT * from CLIENTE WHERE nome LIKE '%" + nome + "%'";
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                ClienteTO cli = new ClienteTO();
                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setCmfotoCli(rs.getString("foto"));
                cli.setDataCadastro(rs.getString("datacadastro"));
                p.add(cli);

            }
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return p;
    }

    public PessoasTO VerificarCliente(String rg, String cpf) {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT codcliente,rg,cpf,nome FROM cliente WHERE rg = '" + rg + "' or cpf='" + cpf + "'";

        try {
            con.conectaBD();
            ResultSet rs = con.executaConsulta(SQL);

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));

            }
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return cli;
    }

    public PessoasTO VerificarClienteNome(String nome) {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT codcliente,rg,cpf,nome FROM cliente WHERE nome = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));

            }
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return cli;
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String VerificarStatus() {
        Conexao con = new Conexao();
        String SQL;
        SQL = "UPDATE CLIENTE SET status = 'INATIVO' WHERE (SELECT CURRENT_DATE - (select to_date(dataultvisita,'DD MM YYYY') as data)) > 29";
        con.conectaBD();
        con.executaSQL(SQL);
        con.desconectaBD();
        return "";
    }

    public ArrayList<PessoasTO> ConsultarTodosClienteAtivosVenda() {
        ArrayList<PessoasTO> p = new ArrayList();
        Conexao con = new Conexao();
        String SQL = "SELECT * FROM CLIENTE WHERE STATUS='ATIVO'";
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        try {
            ResultSet rs;
            con.conectaBD();
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                ClienteTO cli = new ClienteTO();
                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));
                cli.setCmfotoCli(rs.getString("foto"));
                p.add(cli);

            }
            //************************************************************

            //RETORNA O ARRAYLIST PARA O BO
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return p;
    }

    public ArrayList<PessoasTO> ConsultarTodosClienteAtivosVenda(String nome) {
        ArrayList<PessoasTO> p = new ArrayList();

        ResultSet rs;
        Conexao con = new Conexao();
        String SQL = "SELECT * from CLIENTE WHERE nome LIKE '%" + nome + "%' AND STATUS='ATIVO'";

        try {
            con.conectaBD();
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA CLIENTE MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                ClienteTO cli = new ClienteTO();
                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setCmfotoCli(rs.getString("foto"));
                cli.setDataCadastro(rs.getString("datacadastro"));
                p.add(cli);

            }
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return p;
    }

    public PessoasTO ConsultarClienteIDVenda(int id) {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM CLIENTE WHERE codcliente = " + id + " AND STATUS='ATIVO'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telfixo"));
                cli.setCelular(rs.getString("telcelular"));
                cli.setEmail(rs.getString("email"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return cli;
    }

    public String DesbloquearClientes() {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET dataultvisita='" + getDate() + "', dataprivisita='" + getDate() + "', status='ATIVO'";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
