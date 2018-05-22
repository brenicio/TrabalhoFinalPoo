package backup;

import bo.ClienteBO;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import model.UpperCaseMODEL2;
import to.ClienteTO;

public class ClienteCRTL {

    private ClienteTO clienteTo;
    private ClienteTO clienteConsultaTO;
    private ArrayList<ClienteTO> clientes;

    public ClienteTO getClienteTo() {
        return clienteTo;
    }

    public void setClienteTo(ClienteTO clienteTo) {
        this.clienteTo = clienteTo;
    }

    public ClienteTO getClienteConsultaTO() {
        return clienteConsultaTO;
    }

    public void setClienteConsultaTO(ClienteTO clienteConsultaTO) {
        this.clienteConsultaTO = clienteConsultaTO;
    }

    public ArrayList<ClienteTO> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ClienteTO> clientes) {
        this.clientes = clientes;
    }

    public ClienteCRTL() {
        try {
            clienteTo = new ClienteTO();
            clienteConsultaTO = new ClienteTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public String incluirCliente() {

        try {
            ClienteBO clienteBo = new ClienteBO();
            String ret = clienteBo.Incluir(clienteTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
                return ret;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                return "limpar";
            }

        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "limpar";
    }

    public String alterarCliente() {
        try {
            ClienteBO clienteBo = new ClienteBO();
            String ret = clienteBo.Alterar(clienteTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
                return ret;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                return "limpar";
            }

        } catch (Exception ex) {
            System.out.println("Erro ao alterar!!");
        }
        return "limpar";
    }

    public ClienteTO consultar(String nome) {

        try {
            ClienteBO clienteBo = new ClienteBO();
            clienteTo = (ClienteTO) clienteBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return clienteTo;

    }

    public ClienteTO consultarID(int id) {

        try {
            ClienteBO clienteBo = new ClienteBO();
            clienteTo = clienteBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return clienteTo;

    }

    public ArrayList<ClienteTO> consultarTodos() {

        try {

            ClienteBO clienteBo = new ClienteBO();
            clientes = clienteBo.ConsultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }

    public ArrayList<ClienteTO> consultarTodosC(String nome) {

        try {

            ClienteBO clienteBo = new ClienteBO();
            clientes = clienteBo.ConsultarTodos(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }

    public void excluir(int id) {
        try {
            String ret;
            ClienteBO bo = new ClienteBO();
            ret = bo.ExcluirID(id);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
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

    public void MaiusculaNumero(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL2());
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }

}
