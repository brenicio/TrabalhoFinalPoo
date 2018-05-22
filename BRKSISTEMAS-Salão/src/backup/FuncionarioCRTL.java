package crtl;

import bo.FuncionarioBO;
import java.text.ParseException;

import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.FuncionarioTO;

public class FuncionarioCRTL {

    private FuncionarioTO funcionarioTo;
    private FuncionarioTO funcionarioConsultaTO;
    private ArrayList<FuncionarioTO> funcionarios;

    public FuncionarioTO getFuncionarioConsultaTO() {
        return funcionarioConsultaTO;
    }

    public void setFuncionarioConsultaTO(FuncionarioTO funcionarioConsultaTO) {
        this.funcionarioConsultaTO = funcionarioConsultaTO;
    }

    public ArrayList<FuncionarioTO> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<FuncionarioTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public FuncionarioTO getFuncionarioTo() {
        return funcionarioTo;
    }

    public void setFuncionarioTo(FuncionarioTO funcionarioTo) {
        this.funcionarioTo = funcionarioTo;
    }

    public FuncionarioCRTL() {
        try {
            funcionarioTo = new FuncionarioTO();
            funcionarioConsultaTO = new FuncionarioTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public String incluirFuncionario() {

        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            String ret = funcionarioBo.Incluir(funcionarioTo);
            if (!"".equals(ret)) {
                return ret;
            } else if (ret.equals("erro")) {
                return "Erro ao cadastrar!";
            } else if (ret.equals("")) {
                return ret;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "";
    }

    public void alterarFuncionario() {
        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            String ret = funcionarioBo.Alterar(funcionarioTo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public FuncionarioTO consultar(String nome) {

        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarioTo = (FuncionarioTO) funcionarioBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return funcionarioTo;

    }

    public FuncionarioTO consultarID(int id) {

        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarioTo = (FuncionarioTO) funcionarioBo.Consultar(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return funcionarioTo;

    }

    public ArrayList<FuncionarioTO> consultarTodos() {

        try {

            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarios = funcionarioBo.ConsultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return funcionarios;
    }

    public void excluir(int id) {
        try {

            FuncionarioBO funcBo = new FuncionarioBO();
            funcBo.ExcluirID(id);
            limpaTela();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public void mascaraCPF(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraTelCel(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraData(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraCTPS(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.#####.##-#")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraTelefone(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraCep(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void Maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }

    private void limpaTela() {
        funcionarioTo.setNome("");
        funcionarioTo.setEndereco("");
        funcionarioTo.setTelefone("");
        funcionarioTo.setMatricula(0);
        funcionarioTo.setCargo("");
        funcionarioTo.setCelular("");
        funcionarioTo.setCep("");
        funcionarioTo.setCidade("");
        funcionarioTo.setCpf("");
        funcionarioTo.setCts("");
        funcionarioTo.setDatanasc("");
        funcionarioTo.setEmail("");
        funcionarioTo.setRg("");
        funcionarioTo.setSerie("");
        funcionarioTo.setSetor("");
        funcionarioTo.setSexo("");
        funcionarioTo.setTelefoneRecado("");
    }
}
