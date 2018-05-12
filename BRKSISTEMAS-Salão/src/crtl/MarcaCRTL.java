package crtl;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import bo.MarcaBO;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.MarcaTO;

public class MarcaCRTL {

    private MarcaTO marcaTo;
    private MarcaTO marcaConsultaTo;
    private ArrayList<MarcaTO> marcas;

    public MarcaTO getMarcaTo() {
        return marcaTo;
    }

    public void setMarcaTo(MarcaTO marcaTo) {
        this.marcaTo = marcaTo;
    }

    public MarcaTO getMarcaConsultaTo() {
        return marcaConsultaTo;
    }

    public void setMarcaConsultaTo(MarcaTO marcaConsultaTo) {
        this.marcaConsultaTo = marcaConsultaTo;
    }

    public ArrayList<MarcaTO> getMarcas() {
        return marcas;
    }

    public void setMarcas(ArrayList<MarcaTO> marcas) {
        this.marcas = marcas;
    }

    

    public MarcaCRTL() {
        try {
            marcaTo = new MarcaTO();
            marcaConsultaTo = new MarcaTO();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
 public String incluirMarca() {
        try {
            MarcaBO marcaBo = new MarcaBO();
            String ret = marcaBo.incluir(marcaTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Marca incluida com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }

    public void alterarMarca() {
        try {
            MarcaBO marcaBo = new MarcaBO();
            String ret = marcaBo.alterar(marcaTo);
             if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Marca alterada com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public MarcaTO consultar(String nome) {

        try {
            MarcaBO marcaBo = new MarcaBO();
            marcaTo = marcaBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return marcaTo;

    }

    public MarcaTO consultarID(int id) {

        try {
            MarcaBO marcaBo = new MarcaBO();
            marcaTo = marcaBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return marcaTo;

    }
    public ArrayList<MarcaTO> consultarTodos() {

        try {

            MarcaBO marcaBo = new MarcaBO();
            marcas = marcaBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return marcas;
    }
    public ArrayList<MarcaTO> consultarTodosM(String nome) {

        try {

            MarcaBO marcaBo = new MarcaBO();
            marcas = marcaBo.consultarTodosM(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return marcas;
    }

    public void excluir(int id) {
        try {

            MarcaBO marcaBo = new MarcaBO();
           String ret =  marcaBo.excluirID(id);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Marca excluida com sucesso!");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }
    
    public void Maiuscula(JTextField maior){
            maior.setDocument(new UpperCaseMODEL());
        }
    public void somenteNumero(JFormattedTextField numero, int tamanho){
            numero.setDocument(new LimiteDigitosMODEL(tamanho));
        }
}



