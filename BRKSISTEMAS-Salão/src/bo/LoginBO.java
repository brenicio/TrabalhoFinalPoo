package bo;

import dao.LoginDAO;
import to.UsuarioTO;
import to.LoginTO;

public class LoginBO {

    private final LoginDAO loginDao;

    public LoginBO() throws Exception {
        loginDao = new LoginDAO();
    }

    public UsuarioTO Logar(LoginTO logar) throws Exception {
        UsuarioTO usuarioTo = loginDao.Logar(logar);
        return usuarioTo;

    }

    private String consisteDados(LoginTO loginTo) {
        if ("".equals(loginTo.getLogin())) {
            return "O Usuario não foi informado!";
        }
        if ("".equals(loginTo.getSenha())) {
            return "A Senha não foi informada!";

        }
        return "";

    }
}
