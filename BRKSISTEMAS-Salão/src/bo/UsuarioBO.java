package bo;
import dao.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.UsuarioTO;

public class UsuarioBO {

    private final UsuarioDAO usuarioDao;
    UsuarioTO usuTo;
    public UsuarioBO() throws Exception {
        usuarioDao = new UsuarioDAO();
        usuTo = new UsuarioTO();

    }
    public String incluir (UsuarioTO usuarioTo) throws Exception{
        
        usuTo = usuarioDao.VerificarUsuario(usuarioTo.getNomeUsuario());
        
        String ret = consisteDados(usuarioTo);
        
        
       if (!ret.equals("")) {
            return ret; 
        }
       
       
          ret = usuarioDao.incluir(usuarioTo); 
         
        return ret; 
       
                        
    }
    
        public String alterar (UsuarioTO usuarioTo) throws Exception{
        String ret = consisteDados(usuarioTo);
        if (!ret.equals("")){
            return ret;
        }
        
        ret = usuarioDao.alterar(usuarioTo);
        return ret;
    }
    
       
    private String consisteDados(UsuarioTO usuarioTo){
        if(usuarioTo.getNomeUsuario().equals(usuTo.getNomeUsuario())){
            return "O usuario informado já existe!";
        }
        if (usuarioTo.getNomeUsuario().equals("")) {
           return "Nome não informado!";   
           
        }
        if (usuarioTo.getSenhaUsuario().equals("")) {
            
            return "Senha não informada!";
        }
        if (usuarioTo.getTipoUsuario().equals("")){
            return "Tipo de usuário não informado!";
        }
        
//        if (usuTo.getNomeFuncionario().equalsIgnoreCase(usuarioTo.getNomeUsuario())){
//          JOptionPane.showMessageDialog(null, usuTo.getNomeFuncionario());
//            return "O usuário informado já existe!";
//            
//        }
         
      return "";
    }
    public UsuarioTO Consultar(String nome) throws Exception {
        UsuarioTO usuarioTo = usuarioDao.Consultar(nome);       
        return usuarioTo;
    }
     public UsuarioTO ConsultarID(int id) throws Exception {
        UsuarioTO usuarioTo = usuarioDao.ConsultarID(id);       
        return usuarioTo;
    }
     public UsuarioTO ConsultarIDF(int id) throws Exception{
       UsuarioTO usuarioTo = usuarioDao.ConsultarIDF(id);
       return usuarioTo;
     }
    public ArrayList <UsuarioTO> consultarTodos() throws Exception {
        ArrayList usuarios = usuarioDao.consultarTodos();
        return usuarios;
    }
    public void excluirID (long id) throws Exception {
        usuarioDao.excluirID(id);
    }
}
