package crtl;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import bo.CategoriaBO;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.CategoriaTO;

public class CategoriaCRTL {

    private CategoriaTO categoriaTo;
    private CategoriaTO categoriaConsultaTo;
    private ArrayList<CategoriaTO> categorias;

    public CategoriaTO getCategoriaTo() {
        return categoriaTo;
    }

    public void setCategoriaTo(CategoriaTO categoriaTo) {
        this.categoriaTo = categoriaTo;
    }

    public CategoriaTO getCategoriaConsultaTo() {
        return categoriaConsultaTo;
    }

    public void setCategoriaConsultaTo(CategoriaTO categoriaConsultaTo) {
        this.categoriaConsultaTo = categoriaConsultaTo;
    }

    public ArrayList<CategoriaTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<CategoriaTO> categorias) {
        this.categorias = categorias;
    }

    public CategoriaCRTL() {
        try {
            categoriaTo = new CategoriaTO();
            categoriaConsultaTo = new CategoriaTO();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public String incluirCategoria() {
        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            String ret = categoriaBo.incluir(categoriaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Categoria incluida com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }

    public void alterarCategoria() {
        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            String ret = categoriaBo.alterar(categoriaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public CategoriaTO consultar(String nome) {

        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            categoriaTo = categoriaBo.consultar(nome);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return categoriaTo;

    }

    public CategoriaTO consultarID(int id) {

        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            categoriaTo = categoriaBo.consultarID(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return categoriaTo;

    }

    public ArrayList<CategoriaTO> consultarTodos() {

        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            categorias = categoriaBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categorias;
    }

    public ArrayList<CategoriaTO> consultarTodosM(String nome) {

        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            categorias = categoriaBo.consultarTodosM(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categorias;
    }

    public void excluir(int id) {
        try {
            CategoriaBO categoriaBo = new CategoriaBO();
            String ret = categoriaBo.excluirID(id);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Categoria excluida com sucesso!");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public void maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }

}
