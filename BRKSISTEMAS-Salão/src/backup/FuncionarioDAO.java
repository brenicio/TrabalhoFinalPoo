
public class FuncionarioDAO {

    public FuncionarioDAO() throws Exception {

    }

    public String incluir(FuncionarioTO funcionarioTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO funcionario "
                    + "(matricula,cidade,uf,nomefunc,sexofunc,cargofunc,rgfunc,cpffunc,celularfunc,telefonefunc,"
                    + "telefonerecadofunc,emailfunc,enderecofunc,cepfunc,ctsfunc,seriefunc,datanasc,setor)"
                    + "VALUES (" + funcionarioTo.getMatricula() + ",'" + funcionarioTo.getCidade() + "','" + funcionarioTo.getUf() + "','" + funcionarioTo.getNome() + "','" + funcionarioTo.getSexo() + "','" + funcionarioTo.getCargo() + "',"
                    + "'" + funcionarioTo.getRg() + "','" + funcionarioTo.getCpf() + "','" + funcionarioTo.getCelular() + "','" + funcionarioTo.getTelefone() + "','" + funcionarioTo.getTelefoneRecado() + "','" + funcionarioTo.getEmail() + "',"
                    + "'" + funcionarioTo.getEndereco() + "','" + funcionarioTo.getCep() + "','" + funcionarioTo.getCts() + "','" + funcionarioTo.getSerie() + "','" + funcionarioTo.getDatanasc() + "','" + funcionarioTo.getSetor() + "')";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            //   return "";

        } catch (Exception e) {
            throw e;
        }
        return "";
    }

    public String alterar(FuncionarioTO funcionarioTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;

            SQL = "UPDATE funcionario SET cidade='" + funcionarioTo.getCidade() + "', uf = '" + funcionarioTo.getUf() + "', nomefunc = '" + funcionarioTo.getNome() + "',sexofunc = '" + funcionarioTo.getSexo() + "', cargofunc = '" + funcionarioTo.getCargo() + "', rgfunc = '" + funcionarioTo.getRg() + "', "
                    + "cpffunc ='" + funcionarioTo.getCpf() + "',celularfunc = '" + funcionarioTo.getCelular() + "',telefonefunc = '" + funcionarioTo.getTelefone() + "',telefonerecadofunc = '" + funcionarioTo.getTelefoneRecado() + "',emailfunc = '" + funcionarioTo.getEmail() + "',enderecofunc = '" + funcionarioTo.getEndereco() + "',"
                    + "cepfunc = '" + funcionarioTo.getCep() + "', ctsfunc = '" + funcionarioTo.getCts() + "', "
                    + "seriefunc = '" + funcionarioTo.getSerie() + "', datanasc = '" + funcionarioTo.getDatanasc() + "',setor = '" + funcionarioTo.getSetor() + "' WHERE matricula=" + funcionarioTo.getMatricula() + "";

            JOptionPane.showMessageDialog(null, "Funcionario Atualizado com Sucesso!");

            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public FuncionarioTO Consultar(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        FuncionarioTO func = new FuncionarioTO();
        SQL = "SELECT * FROM funcionario WHERE nomefunc LIKE '%" + nome + "%'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                func.setMatricula(rs.getInt("matricula"));
                func.setNome(rs.getString("nomefunc"));
                func.setCargo(rs.getString("cargofunc"));
                func.setRg(rs.getString("rgfunc"));
                func.setCpf(rs.getString("cpffunc"));
                func.setCelular(rs.getString("celularfunc"));
                func.setTelefone(rs.getString("telefonefunc"));
                func.setEmail(rs.getString("emailfunc"));
                func.setEndereco(rs.getString("enderecofunc"));
                func.setCidade(rs.getString("cidade"));
                func.setCep(rs.getString("cepfunc"));
                func.setSexo(rs.getString("sexofunc"));
                func.setTelefoneRecado(rs.getString("telefonerecadofunc"));
                func.setUf(rs.getString("uf"));
                func.setDatanasc(rs.getString("datanasc"));
                func.setCts(rs.getString("ctsfunc"));
                func.setSerie(rs.getString("seriefunc"));
                func.setSetor(rs.getString("setor"));

            }
            return func;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return func;
    }

    public FuncionarioTO ConsultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        FuncionarioTO func = new FuncionarioTO();
        SQL = "SELECT * FROM funcionario WHERE matricula = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                func.setMatricula(rs.getInt("matricula"));
                func.setNome(rs.getString("nomefunc"));
                func.setCargo(rs.getString("cargofunc"));
                func.setRg(rs.getString("rgfunc"));
                func.setCpf(rs.getString("cpffunc"));
                func.setCelular(rs.getString("celularfunc"));
                func.setTelefone(rs.getString("telefonefunc"));
                func.setEmail(rs.getString("emailfunc"));
                func.setEndereco(rs.getString("enderecofunc"));
                func.setCidade(rs.getString("cidade"));
                func.setCep(rs.getString("cepfunc"));
                func.setSexo(rs.getString("sexofunc"));
                func.setTelefoneRecado(rs.getString("telefonerecadofunc"));
                func.setUf(rs.getString("uf"));
                func.setDatanasc(rs.getString("datanasc"));
                func.setCts(rs.getString("ctsfunc"));
                func.setSerie(rs.getString("seriefunc"));
                func.setSetor(rs.getString("setor"));

            }
            return func;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return func;
    }

    public ArrayList<FuncionarioTO> consultarTodos() throws Exception {
        ArrayList<FuncionarioTO> funcA = new ArrayList();
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
            func.setCargo(rs.getString("cargofunc"));
            func.setRg(rs.getString("rgfunc"));
            func.setCpf(rs.getString("cpffunc"));
            func.setCelular(rs.getString("celularfunc"));
            func.setTelefone(rs.getString("telefonefunc"));
            func.setEmail(rs.getString("emailfunc"));
            func.setEndereco(rs.getString("enderecofunc"));
            func.setCidade(rs.getString("cidade"));
            func.setCep(rs.getString("cepfunc"));
            func.setSexo(rs.getString("sexofunc"));
            func.setTelefoneRecado(rs.getString("telefonerecadofunc"));
            func.setUf(rs.getString("uf"));
            func.setDatanasc(rs.getString("datanasc"));
            func.setCts(rs.getString("ctsfunc"));
            func.setSerie(rs.getString("seriefunc"));
            func.setSetor(rs.getString("setor"));
            funcA.add(func);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return funcA;
    }

    public void excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM FUNCIONARIO WHERE MATRICULA =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        JOptionPane.showMessageDialog(null, "Funcionario Excluido com sucesso!!");
    }

    public FuncionarioTO VerificarFuncionario(String rg, String cpf, int matricula) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        FuncionarioTO funcTo = new FuncionarioTO();
        SQL = "SELECT matricula,rgfunc,cpffunc,nomefunc FROM funcionario WHERE rgfunc = '" + rg + "' or cpffunc='" + cpf + "' or matricula = " + matricula + "";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                funcTo.setMatricula(rs.getInt("matricula"));
                funcTo.setRg(rs.getString("rgfunc"));
                funcTo.setCpf(rs.getString("cpffunc"));
                funcTo.setNome(rs.getString("nomefunc"));

            }
            return funcTo;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return funcTo;
    }

}
