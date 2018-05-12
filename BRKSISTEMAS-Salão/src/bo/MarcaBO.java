package bo;

import dao.MarcaDAO;
import to.MarcaTO;
import java.util.ArrayList;

public class MarcaBO {

    private final MarcaDAO marcaDao;
    MarcaTO marcTo;

    public MarcaBO() throws Exception {
        marcaDao = new MarcaDAO();
        marcTo = new MarcaTO();
    }

    public String incluir(MarcaTO marcaTo) throws Exception {
        marcTo = marcaDao.VerificarMarca(marcaTo.getNomeMarca());
        String ret = consisteDados(marcaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = marcaDao.incluir(marcaTo);

        return ret;

    }

    public String alterar(MarcaTO marcaTo) throws Exception {
        marcTo = marcaDao.VerificarMarca(marcaTo.getNomeMarca());
        String ret = consisteDados(marcaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = marcaDao.alterar(marcaTo);
        return ret;
    }

    private String consisteDados(MarcaTO marcaTo) {

        if (marcaTo.getNomeMarca().equals(marcTo.getNomeMarca())) {
            return "A marca informada já existe!";
        }

        if (marcaTo.getNomeMarca().equals("")) {
            return "Nome da marca não informado!";
        }
        return "";
    }

    public MarcaTO Consultar(String nome) throws Exception {

        MarcaTO marcaTo = marcaDao.Consultar(nome);
        return marcaTo;
    }

    public MarcaTO ConsultarID(int id) throws Exception {

        MarcaTO funcionarioTo = marcaDao.ConsultarID(id);
        return funcionarioTo;
    }

    public ArrayList<MarcaTO> consultarTodos() throws Exception {

        ArrayList marcas = marcaDao.consultarTodos();
        return marcas;
    }

    public ArrayList<MarcaTO> consultarTodosM(String nome) throws Exception {

        ArrayList marcas = marcaDao.consultarTodosM(nome);
        return marcas;
    }

    public String excluirID(long id) throws Exception {
        String ret = marcaDao.excluirID(id);
        return ret;
    }
}
