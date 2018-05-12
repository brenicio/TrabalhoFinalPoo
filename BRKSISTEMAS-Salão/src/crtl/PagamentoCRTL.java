package crtl;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import bo.PagamentoBO;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.PagamentoTO;

public class PagamentoCRTL {

    private PagamentoTO pagamentoTo;
    private PagamentoTO formapagConsultaTo;
    private ArrayList<PagamentoTO> fpagamentos;

    public PagamentoTO getPagamentoTo() {
        return pagamentoTo;
    }

    public void setPagamentoTo(PagamentoTO pagamentoTo) {
        this.pagamentoTo = pagamentoTo;
    }

    public PagamentoTO getFormapagConsultaTo() {
        return formapagConsultaTo;
    }

    public void setFormapagConsultaTo(PagamentoTO formapagConsultaTo) {
        this.formapagConsultaTo = formapagConsultaTo;
    }

    public ArrayList<PagamentoTO> getFpagamentos() {
        return fpagamentos;
    }

    public void setFpagamentos(ArrayList<PagamentoTO> fpagamentos) {
        this.fpagamentos = fpagamentos;
    }

    public PagamentoCRTL() {
        try {
            pagamentoTo = new PagamentoTO();
            formapagConsultaTo = new PagamentoTO();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public String incluirFormaPagamento() {
        try {
            PagamentoBO pagBo = new PagamentoBO();
            String ret = pagBo.incluir(pagamentoTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Forma de pagamento incluida com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }

    public void alterarFormaPagamento() {
        try {
            PagamentoBO pagBo = new PagamentoBO();
            String ret = pagBo.alterar(pagamentoTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Forma de pagamento alterada com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public PagamentoTO consultar(String nome) {

        try {
            PagamentoBO pagBo = new PagamentoBO();
            pagamentoTo = pagBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return pagamentoTo;
    }

    public PagamentoTO consultarID(int id) {

        try {
            PagamentoBO pagBo = new PagamentoBO();
            pagamentoTo = pagBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return pagamentoTo;

    }

    public ArrayList<PagamentoTO> consultarTodos() {

        try {

            PagamentoBO pagBo = new PagamentoBO();
            fpagamentos = pagBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fpagamentos;
    }

    public ArrayList<PagamentoTO> consultarTodosP(String nome) {

        try {

            PagamentoBO pagBo = new PagamentoBO();
            fpagamentos = pagBo.consultarTodosM(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fpagamentos;
    }

    public void excluir(int id) {
        try {

            PagamentoBO pagBo = new PagamentoBO();
            String ret = pagBo.excluirID(id);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Foma de pagamento excluida com sucesso!");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public void Maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public void somenteNumero(JTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }
}
