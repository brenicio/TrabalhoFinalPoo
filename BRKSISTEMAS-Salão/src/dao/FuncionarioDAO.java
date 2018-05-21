package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.PessoasTO;
import to.FuncionarioTO;

public class FuncionarioDAO implements PessoasDAO{

    @Override
    public String Incluir(PessoasTO p) {
        FuncionarioTO funcionarioTo;
        funcionarioTo = (FuncionarioTO) p;
        Conexao con = new Conexao();
        String SQL;
        try {
            SQL = "INSERT INTO funcionario "
                    + "(matricula,cidade,uf,nomefunc,sexofunc,cargofunc,rgfunc,cpffunc,celularfunc,telefonefunc,"
                    + "telefonerecadofunc,emailfunc,enderecofunc,cepfunc,ctsfunc,seriefunc,datanasc,setor)"
                    + "VALUES (" + funcionarioTo.getMatricula() + ",'" + funcionarioTo.getCidade() + "','" + funcionarioTo.getUf() + "','" + funcionarioTo.getNome() + "','" + funcionarioTo.getSexo() + "','" + funcionarioTo.getCargo() + "',"
                    + "'" + funcionarioTo.getRg() + "','" + funcionarioTo.getCpf() + "','" + funcionarioTo.getCelular() + "','" + funcionarioTo.getTelefone() + "','" + funcionarioTo.getTelefoneRecado() + "','" + funcionarioTo.getEmail() + "',"
                    + "'" + funcionarioTo.getEndereco() + "','" + funcionarioTo.getCep() + "','" + funcionarioTo.getCts() + "','" + funcionarioTo.getSerie() + "','" + funcionarioTo.getDatanasc() + "','" + funcionarioTo.getSetor() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            //   return "";

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "";
    }

    @Override
    public String Alterar(PessoasTO p) {
        FuncionarioTO funcionarioTo;
        funcionarioTo = (FuncionarioTO) p;
        Conexao con = new Conexao();
        String SQL;
        try {
            SQL = "UPDATE funcionario SET cidade='" + funcionarioTo.getCidade() + "', uf = '" + funcionarioTo.getUf() + "', nomefunc = '" + funcionarioTo.getNome() + "',sexofunc = '" + funcionarioTo.getSexo() + "', cargofunc = '" + funcionarioTo.getCargo() + "', rgfunc = '" + funcionarioTo.getRg() + "', "
                    + "cpffunc ='" + funcionarioTo.getCpf() + "',celularfunc = '" + funcionarioTo.getCelular() + "',telefonefunc = '" + funcionarioTo.getTelefone() + "',telefonerecadofunc = '" + funcionarioTo.getTelefoneRecado() + "',emailfunc = '" + funcionarioTo.getEmail() + "',enderecofunc = '" + funcionarioTo.getEndereco() + "',"
                    + "cepfunc = '" + funcionarioTo.getCep() + "', ctsfunc = '" + funcionarioTo.getCts() + "', "
                    + "seriefunc = '" + funcionarioTo.getSerie() + "', datanasc = '" + funcionarioTo.getDatanasc() + "',setor = '" + funcionarioTo.getSetor() + "' WHERE matricula=" + funcionarioTo.getMatricula() + "";

            JOptionPane.showMessageDialog(null, "Funcionario Atualizado com Sucesso!");

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
        FuncionarioTO func = new FuncionarioTO();
        SQL = "SELECT * FROM funcionario WHERE nomefunc LIKE '%" + nome + "%'";
        try {

            con.conectaBD();
            ResultSet rs;
            rs = con.executaConsulta(SQL);

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
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return func;
    }

    @Override
    public PessoasTO Consultar(int id) {
        Conexao con = new Conexao();
        String SQL;
        FuncionarioTO func = new FuncionarioTO();
        SQL = "SELECT * FROM funcionario WHERE matricula = " + id + "";
        try {
            con.conectaBD();
            ResultSet rs = con.executaConsulta(SQL);

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
            rs.close();
            con.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return func;
    }

    @Override
    public ArrayList<PessoasTO> ConsultarTodos() {
        ArrayList<PessoasTO> pessoas = new ArrayList();

        try {
            //*********************************************
            //RECUPERA TODOS OS FUNCIONARIOS DO BANCO
            //*********************************************
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "SELECT * FROM FUNCIONARIO";
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA FUNCINARIO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
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
                pessoas.add(func);

            }
            //************************************************************

            //RETORNA O ARRAYLIST PARA O BO
            rs.close();
            con.desconectaBD();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: " + ex.getMessage());
        }
        return pessoas;
    }

    @Override
    public void ExcluirID(long Id) {
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM FUNCIONARIO WHERE MATRICULA =" + Id + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        JOptionPane.showMessageDialog(null, "Funcionario Excluido com sucesso!!");
    }

    public PessoasTO VerificarFuncionario(String rg, String cpf, int matricula) {

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
            rs.close();
            con.desconectaBD();
            return funcTo;
        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }

        return funcTo;
    }

}
