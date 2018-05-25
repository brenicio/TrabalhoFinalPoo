package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.UsuarioTO;

public class UsuarioDAO {

    UsuarioTO usuarioTo = new UsuarioTO();

    public UsuarioDAO() throws Exception {

    }

    public String incluir(UsuarioTO usuarioTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO usuario (nomeusuario,senhausuario,tipousuario,matricula)"
                    + "VALUES ('" + usuarioTo.getNomeUsuario() + "','" + usuarioTo.getSenhaUsuario() + "','" + usuarioTo.getTipoUsuario() + "'," + usuarioTo.getMatriculaFunc() + ")";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            // JOptionPane.showMessageDialog(null, "Usuário Incluido com Sucesso!");
            return "";
        } catch (Exception e) {
            System.out.println("Erro ao incluir no banco!");
            throw e;
        }

    }

    public String alterar(UsuarioTO usuarioTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;

            SQL = "UPDATE usuario SET nomeusuario='" + usuarioTo.getNomeUsuario() + "', senhausuario = '" + usuarioTo.getSenhaUsuario() + "', tipousuario = '" + usuarioTo.getTipoUsuario() + "',matricula = " + usuarioTo.getMatriculaFunc() + " WHERE codusuario=" + usuarioTo.getCodUsuario() + "";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            JOptionPane.showMessageDialog(null, "Funcionario Atualizado com Sucesso!");
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public UsuarioTO Consultar(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        UsuarioTO usu = new UsuarioTO();
        SQL = "SELECT * FROM usuario WHERE nomeusuario LIKE '%" + nome + "%'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                usu.setCodUsuario(rs.getInt("codusuario"));
                usu.setMatriculaFunc(rs.getInt("matricula"));
                usu.setNomeUsuario(rs.getString("nomeusuario"));
                usu.setSenhaUsuario(rs.getString("senhausuario"));
                usu.setTipoUsuario(rs.getString("tipousuario"));

            }
            return usu;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return usu;
    }

    public UsuarioTO ConsultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        UsuarioTO usu = new UsuarioTO();
        SQL = "SELECT * FROM usuario WHERE codusuario = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                usu.setCodUsuario(rs.getInt("codusuario"));
                usu.setMatriculaFunc(rs.getInt("matricula"));
                usu.setNomeUsuario(rs.getString("nomeusuario"));
                usu.setSenhaUsuario(rs.getString("senhausuario"));
                usu.setTipoUsuario(rs.getString("tipousuario"));

            }
            return usu;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return usu;
    }

    public UsuarioTO ConsultarIDF(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        UsuarioTO usu = new UsuarioTO();
        SQL = "select * from usuario u inner join funcionario f on u.matricula = f.matricula and u.matricula= " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                usu.setCodUsuario(rs.getInt("codusuario"));
                usu.setMatriculaFunc(rs.getInt("matricula"));
                usu.setNomeFuncionario(rs.getString("nomefunc"));
                usu.setNomeUsuario(rs.getString("nomeusuario"));
                usu.setSenhaUsuario(rs.getString("senhausuario"));
                usu.setTipoUsuario(rs.getString("tipousuario"));

            }
            return usu;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return usu;
    }

    public ArrayList<UsuarioTO> consultarTodos() throws Exception {
        ArrayList<UsuarioTO> usuA = new ArrayList();
        //*********************************************
        //RECUPERA TODOS OS ALUNOS DO BANCO
        //*********************************************
        ResultSet rs;
        Conexao con = new Conexao();
        con.conectaBD();
        String SQL = "SELECT * FROM USUARIO";
        rs = con.executaConsulta(SQL);
        //***********************************************
        //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
        //************************************************************
        while (rs.next()) {
            UsuarioTO usu = new UsuarioTO();
            usu.setCodUsuario(rs.getInt("codusuario"));
            usu.setMatriculaFunc(rs.getInt("matricula"));
            usu.setNomeUsuario(rs.getString("nomeusuario"));
            usu.setSenhaUsuario(rs.getString("senhausuario"));
            usu.setTipoUsuario(rs.getString("tipousuario"));
            usuA.add(usu);

        }
        //************************************************************

        //RETORNA O ARRAYLIST PARA O BO
        rs.close();
        con.desconectaBD();
        return usuA;
    }

    public UsuarioTO VerificarUsuario(String nome) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        UsuarioTO usu = new UsuarioTO();

        SQL = "SELECT nomeusuario, matricula FROM usuario WHERE nomeusuario = '" + nome + "'";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {
            if (rs.next()) {

                usu.setMatriculaFunc(rs.getInt("matricula"));
                usu.setNomeUsuario(rs.getString("nomeusuario"));

            }
            return usu;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();
        JOptionPane.showMessageDialog(null, usu.getNomeUsuario());
        return usu;
    }

    public void excluirID(long ID) throws Exception {

        //EXCLUI UM ALUNO DO BANCO (COM O ID PASSADO COMO PARÂMETRO)
        //************************************************************
        //ABRE CONEXAO COM O BANCO
        //************************************************************
        Conexao con = new Conexao();
        String SQL;
        con.conectaBD();
        SQL = "DELETE FROM USUARIO WHERE CODUSUARIO =" + ID + "";
        con.executaSQL(SQL);
        con.desconectaBD();
        JOptionPane.showMessageDialog(null, "Usuario Excluido com sucesso!!");
    }
}
