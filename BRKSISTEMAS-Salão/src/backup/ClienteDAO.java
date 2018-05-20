
public class ClienteDAO {

    public ClienteDAO() throws Exception {

    }

    public String incluir(ClienteTO clienteTo) throws Exception {
        try {

            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO CLIENTE (nome,rg,sexo,cpf,telfixo,telcelular,email,endereco,bairro,cidade,foto,status,dataprivisita,dataultvisita,datacadastro)"
                    + "VALUES ('" + clienteTo.getNomeCli() + "','" + clienteTo.getRgCli() + "','" + clienteTo.getSexo() + "','" + clienteTo.getCpfCli() + "','" + clienteTo.getTelfixoCLi() + "','" + clienteTo.getCelularCli() + "','" + clienteTo.getEmailCli() + "',"
                    + "'" + clienteTo.getEnderecoCli() + "','" + clienteTo.getBairoCli() + "','" + clienteTo.getCidadeCli() + "','" + clienteTo.getCmfotoCli() + "','" + clienteTo.getStatusCli() + "','" + clienteTo.getDatapriVisita() + "','" + clienteTo.getDataultVisita() + "','" + clienteTo.getDataCadastro() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();

            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public String alterar(ClienteTO clienteTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET nome='" + clienteTo.getNomeCli() + "', rg = '" + clienteTo.getRgCli() + "', sexo='" + clienteTo.getSexo() + "', cpf = '" + clienteTo.getCpfCli() + "',telfixo = '" + clienteTo.getTelfixoCLi() + "', telcelular = '" + clienteTo.getCelularCli() + "', email = '" + clienteTo.getEmailCli() + "', "
                    + "endereco ='" + clienteTo.getEnderecoCli() + "',bairro = '" + clienteTo.getBairoCli() + "',cidade = '" + clienteTo.getCidadeCli() + "',foto = '" + clienteTo.getCmfotoCli() + "',status = '" + clienteTo.getStatusCli() + "', dataultvisita='" + clienteTo.getDataultVisita() + "',datacadastro='" + clienteTo.getDataCadastro() + "' WHERE codcliente=" + clienteTo.getCodCliente() + "";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public String AtualizarDataVisita(int codCliente) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET dataultvisita='" + getDate() + "' WHERE codcliente=" + codCliente + "";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public ClienteTO Consultar(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCli(rs.getString("nome"));
                cli.setRgCli(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpfCli(rs.getString("cpf"));
                cli.setTelfixoCLi(rs.getString("telfixo"));
                cli.setCelularCli(rs.getString("telcelular"));
                cli.setEmailCli(rs.getString("email"));
                cli.setEnderecoCli(rs.getString("endereco"));
                cli.setBairoCli(rs.getString("bairro"));
                cli.setCidadeCli(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }

    public ClienteTO ConsultarID(int id) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM CLIENTE WHERE codcliente = " + id + "";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCli(rs.getString("nome"));
                cli.setRgCli(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpfCli(rs.getString("cpf"));
                cli.setTelfixoCLi(rs.getString("telfixo"));
                cli.setCelularCli(rs.getString("telcelular"));
                cli.setEmailCli(rs.getString("email"));
                cli.setEnderecoCli(rs.getString("endereco"));
                cli.setBairoCli(rs.getString("bairro"));
                cli.setCidadeCli(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }

    public ArrayList<ClienteTO> consultarTodos() throws Exception {
        ArrayList<ClienteTO> cliA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
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
            cli.setNomeCli(rs.getString("nome"));
            cli.setRgCli(rs.getString("rg"));
            cli.setSexo(rs.getString("sexo"));
            cli.setCpfCli(rs.getString("cpf"));
            cli.setTelfixoCLi(rs.getString("telfixo"));
            cli.setCelularCli(rs.getString("telcelular"));
            cli.setEmailCli(rs.getString("email"));
            cli.setEnderecoCli(rs.getString("endereco"));
            cli.setBairoCli(rs.getString("bairro"));
            cli.setCidadeCli(rs.getString("cidade"));
            cli.setStatusCli(rs.getString("status"));
            cli.setDatapriVisita(rs.getString("dataprivisita"));
            cli.setDataultVisita(rs.getString("dataultvisita"));
            cli.setDataCadastro(rs.getString("datacadastro"));
            cli.setCmfotoCli(rs.getString("foto"));
            cliA.add(cli);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return cliA;
    }

    public String excluirID(long ID) throws Exception {
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
            return ex.getMessage();
        }

        return "";

    }

    public ArrayList<ClienteTO> consultarTodosC(String nome) throws Exception {
        ArrayList<ClienteTO> clienteA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
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
            cli.setNomeCli(rs.getString("nome"));
            cli.setRgCli(rs.getString("rg"));
            cli.setSexo(rs.getString("sexo"));
            cli.setCpfCli(rs.getString("cpf"));
            cli.setTelfixoCLi(rs.getString("telfixo"));
            cli.setCelularCli(rs.getString("telcelular"));
            cli.setEmailCli(rs.getString("email"));
            cli.setEnderecoCli(rs.getString("endereco"));
            cli.setBairoCli(rs.getString("bairro"));
            cli.setCidadeCli(rs.getString("cidade"));
            cli.setStatusCli(rs.getString("status"));
            cli.setDatapriVisita(rs.getString("dataprivisita"));
            cli.setDataultVisita(rs.getString("dataultvisita"));
            cli.setCmfotoCli(rs.getString("foto"));
            cli.setDataCadastro(rs.getString("datacadastro"));
            clienteA.add(cli);

        }
        rs.close();
        con.desconectaBD();
        return clienteA;
    }

    public ClienteTO VerificarCliente(String rg, String cpf) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT codcliente,rg,cpf,nome FROM cliente WHERE rg = '" + rg + "' or cpf='" + cpf + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCli(rs.getString("nome"));
                cli.setRgCli(rs.getString("rg"));
                cli.setCpfCli(rs.getString("cpf"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }

    public ClienteTO VerificarClienteNome(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT codcliente,rg,cpf,nome FROM cliente WHERE nome = '" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCli(rs.getString("nome"));
                cli.setRgCli(rs.getString("rg"));
                cli.setCpfCli(rs.getString("cpf"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String VerificarStatus() {
        try {

            Conexao con = new Conexao();
            String SQL;
            SQL = "UPDATE CLIENTE SET status = 'INATIVO' WHERE (SELECT CURRENT_DATE - (select to_date(dataultvisita,'DD MM YYYY') as data)) > 29";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }
    public ArrayList<ClienteTO> consultarTodosVenda() throws Exception {
        ArrayList<ClienteTO> cliA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM CLIENTE WHERE STATUS='ATIVO'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ClienteTO cli = new ClienteTO();
            cli.setCodCliente(rs.getInt("codcliente"));
            cli.setNomeCli(rs.getString("nome"));
            cli.setRgCli(rs.getString("rg"));
            cli.setSexo(rs.getString("sexo"));
            cli.setCpfCli(rs.getString("cpf"));
            cli.setTelfixoCLi(rs.getString("telfixo"));
            cli.setCelularCli(rs.getString("telcelular"));
            cli.setEmailCli(rs.getString("email"));
            cli.setEnderecoCli(rs.getString("endereco"));
            cli.setBairoCli(rs.getString("bairro"));
            cli.setCidadeCli(rs.getString("cidade"));
            cli.setStatusCli(rs.getString("status"));
            cli.setDatapriVisita(rs.getString("dataprivisita"));
            cli.setDataultVisita(rs.getString("dataultvisita"));
            cli.setDataCadastro(rs.getString("datacadastro"));
            cli.setCmfotoCli(rs.getString("foto"));
            cliA.add(cli);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return cliA;
    }
    public ArrayList<ClienteTO> consultarTodosCVenda(String nome) throws Exception {
        ArrayList<ClienteTO> clienteA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * from CLIENTE WHERE nome LIKE '%" + nome + "%' AND STATUS='ATIVO'";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            ClienteTO cli = new ClienteTO();
            cli.setCodCliente(rs.getInt("codcliente"));
            cli.setNomeCli(rs.getString("nome"));
            cli.setRgCli(rs.getString("rg"));
            cli.setSexo(rs.getString("sexo"));
            cli.setCpfCli(rs.getString("cpf"));
            cli.setTelfixoCLi(rs.getString("telfixo"));
            cli.setCelularCli(rs.getString("telcelular"));
            cli.setEmailCli(rs.getString("email"));
            cli.setEnderecoCli(rs.getString("endereco"));
            cli.setBairoCli(rs.getString("bairro"));
            cli.setCidadeCli(rs.getString("cidade"));
            cli.setStatusCli(rs.getString("status"));
            cli.setDatapriVisita(rs.getString("dataprivisita"));
            cli.setDataultVisita(rs.getString("dataultvisita"));
            cli.setCmfotoCli(rs.getString("foto"));
            cli.setDataCadastro(rs.getString("datacadastro"));
            clienteA.add(cli);

        }
        rs.close();
        con.desconectaBD();
        return clienteA;
    }
    public ClienteTO ConsultarIDVenda(int id) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        ClienteTO cli = new ClienteTO();
        SQL = "SELECT * FROM CLIENTE WHERE codcliente = " + id + " AND STATUS='ATIVO'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCli(rs.getString("nome"));
                cli.setRgCli(rs.getString("rg"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCpfCli(rs.getString("cpf"));
                cli.setTelfixoCLi(rs.getString("telfixo"));
                cli.setCelularCli(rs.getString("telcelular"));
                cli.setEmailCli(rs.getString("email"));
                cli.setEnderecoCli(rs.getString("endereco"));
                cli.setBairoCli(rs.getString("bairro"));
                cli.setCidadeCli(rs.getString("cidade"));
                cli.setStatusCli(rs.getString("status"));
                cli.setDatapriVisita(rs.getString("dataprivisita"));
                cli.setDataultVisita(rs.getString("dataultvisita"));
                cli.setDataCadastro(rs.getString("datacadastro"));

            }
            return cli;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return cli;
    }
    public String DesbloquearClientes(){
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE CLIENTE SET dataultvisita='" + getDate() + "', dataprivisita='"+getDate()+"', status='ATIVO'";

            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
