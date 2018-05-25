package crtl;

import bo.LoginBO;
import javax.swing.JOptionPane;
import to.LoginTO;
import to.UsuarioTO;

public class LoginCRTL {

    private LoginTO loginTo;
    private UsuarioTO usuarioTo;

    public UsuarioTO getUsuarioTo() {
        return usuarioTo;
    }

    public void setUsuarioTo(UsuarioTO usuarioTo) {
        this.usuarioTo = usuarioTo;
    }

    public LoginTO getLoginTo() {
        return loginTo;
    }

    public void setLoginTo(LoginTO loginTo) {
        this.loginTo = loginTo;
    }

    public LoginCRTL() {
        try {
            loginTo = new LoginTO();
            usuarioTo = new UsuarioTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public UsuarioTO logar() {

        try {
            LoginBO loginBo = new LoginBO();
            usuarioTo = loginBo.logar(loginTo);
            if (usuarioTo != null) {
                // JOptionPane.showMessageDialog(null, "Seja Bem Vindo!");
                return usuarioTo;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Logar no Sistema! Usuário ou Senha incorretos.");
        }
        return usuarioTo;
    }
}
