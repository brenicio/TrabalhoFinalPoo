package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.LoginTO;
import to.UsuarioTO;

public class LoginDAO {

    public UsuarioTO logar(LoginTO logar) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        UsuarioTO usu = new UsuarioTO();
        SQL = "SELECT * FROM usuario WHERE nomeusuario = '" + logar.getLogin() + "' and senhausuario='" + logar.getSenha() + "'";
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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        rs.close();
        teste.desconectaBD();

        return usu;
    }

}
