package crtl;

import bo.ServicoBO;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.ServicoTO;

public class ServicoCRTL {

    private ServicoTO servicoTo;
    private ServicoTO servicoConsultaTO;
    private ArrayList<ServicoTO> servicos;

    public ServicoTO getServicoTo() {
        return servicoTo;
    }

    public void setServicoTo(ServicoTO servicoTo) {
        this.servicoTo = servicoTo;
    }

    public ServicoTO getServicoConsultaTO() {
        return servicoConsultaTO;
    }

    public void setServicoConsultaTO(ServicoTO servicoConsultaTO) {
        this.servicoConsultaTO = servicoConsultaTO;
    }

    public ArrayList<ServicoTO> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<ServicoTO> servicos) {
        this.servicos = servicos;
    }

    public ServicoCRTL() {
        try {
            servicoTo = new ServicoTO();
            servicoConsultaTO = new ServicoTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public String incluirServico() {

        try {
            ServicoBO clienteBo = new ServicoBO();
            String ret = clienteBo.incluir(servicoTo);

            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
                return ret;
            } else {
                JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
                return "limpar";
            }

        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "";
    }

    public String alterarServico() {
        try {
            ServicoBO servicoBo = new ServicoBO();
            String ret = servicoBo.alterar(servicoTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
                return ret;
            } else {
                JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");
                return "limpar";
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }
        return "";
    }

    public ServicoTO consultar(String nome) {

        try {
            ServicoBO servicoBo = new ServicoBO();
            servicoTo = servicoBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return servicoTo;

    }

    public ServicoTO consultarID(int id) {

        try {
            ServicoBO servicoBo = new ServicoBO();
            servicoTo = servicoBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return servicoTo;

    }

    public ArrayList<ServicoTO> consultarTodos() {

        try {

            ServicoBO servicoBo = new ServicoBO();
            servicos = servicoBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return servicos;
    }

    public ArrayList<ServicoTO> consultarTodosC(String nome) {

        try {

            ServicoBO servicoBo = new ServicoBO();
            servicos = servicoBo.consultarTodosC(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return servicos;
    }

    public void excluir(int id) {
        try {
            String ret;
            ServicoBO servicoBo = new ServicoBO();
            ret = servicoBo.excluirID(id);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso!");
            }

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
}
