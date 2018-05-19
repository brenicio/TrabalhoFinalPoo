package poo;

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

public class PessoasCRTL {

    private PessoasTO pes;
    
    private ArrayList<PessoasTO> pessoas;
    
    private FuncionarioTO funcionarioTo;
    private ArrayList<FuncionarioTO> funcionarios;

    public PessoasCRTL() {
        try {
            pes = new PessoasTO();
            pessoas = new ArrayList();
            
            funcionarioTo = new FuncionarioTO();     
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }
    
    public String incluirFuncionario() {
        
    }

       

    public void alterarFuncionario() {
        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            String ret = funcionarioBo.alterar(funcionarioTo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public FuncionarioTO consultar(String nome) {

        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarioTo = funcionarioBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return funcionarioTo;

    }

    public FuncionarioTO consultarID(int id) {

        try {
            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarioTo = funcionarioBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return funcionarioTo;

    }

    public ArrayList<FuncionarioTO> consultarTodos() {

        try {

            FuncionarioBO funcionarioBo = new FuncionarioBO();
            funcionarios = funcionarioBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return funcionarios;
    }

    public void excluir(int id) {
        try {

            FuncionarioBO funcBo = new FuncionarioBO();
            funcBo.excluirID(id);
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
