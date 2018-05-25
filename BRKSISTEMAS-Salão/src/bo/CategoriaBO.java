package bo;

import dao.CategoriaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import to.CategoriaTO;

public class CategoriaBO {

    private final CategoriaDAO categoriaDao;
    CategoriaTO catTo;

    public CategoriaBO() throws Exception {
        categoriaDao = new CategoriaDAO();
        catTo = new CategoriaTO();
    }

    public String incluir(CategoriaTO categoriaTo) throws Exception {
        String ret = consisteDados(categoriaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = categoriaDao.incluir(categoriaTo);
        return "";

    }

    public String alterar(CategoriaTO categoriaTo) throws Exception {
        catTo = categoriaDao.verificarCategoria(categoriaTo.getNomeCategoria());
        String ret = consisteDados(categoriaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = categoriaDao.alterar(categoriaTo);
        return ret;
    }

    private String consisteDados(CategoriaTO categoriaTo) {

//        if (catTo.getNomeCategoria().equals(catTo.getNomeCategoria())) {
//            return "A categoria informada já existe!";
//        }
        if (categoriaTo.getNomeCategoria().equals("")) {
            return "Nome da categoria não informado!";
        }
        return "";
    }

    public CategoriaTO consultar(String nome) throws Exception {

        CategoriaTO categoriaTo = categoriaDao.consultar(nome);
        return categoriaTo;
    }

    public CategoriaTO consultarID(int id) throws Exception {

        CategoriaTO categoriaTo = categoriaDao.consultarID(id);
        return categoriaTo;
    }

    public ArrayList<CategoriaTO> consultarTodos() throws Exception {

        ArrayList categorias = categoriaDao.consultarTodos();
        return categorias;
    }

    public ArrayList<CategoriaTO> consultarTodosM(String nome) throws Exception {

        ArrayList categorias = categoriaDao.consultarTodosM(nome);
        return categorias;
    }

    public String excluirID(long id) throws Exception {
        String ret = categoriaDao.excluirID(id);
        return ret;
    }
}
