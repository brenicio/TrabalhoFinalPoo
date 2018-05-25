package crtl;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import bo.CaixaBO;
import dao.CaixaDAO;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.LimiteDigitosMODEL2;
import model.UpperCaseMODEL;
import to.CaixaTO;
import to.EntradaCaixaTO;
import to.ProdutoDetalheTO;
import to.SaidaCaixaTO;
import to.ServicoDetalheTO;

public class CaixaCRTL {

    private CaixaTO caixaTo;
    private EntradaCaixaTO entradaTo;
    private SaidaCaixaTO saidaTo;
    private CaixaTO caixaConsultaTo;

    public ArrayList<ProdutoDetalheTO> getProdD() {
        return prodD;
    }

    public void setProdD(ArrayList<ProdutoDetalheTO> prodD) {
        this.prodD = prodD;
    }

    public ArrayList<ServicoDetalheTO> getServD() {
        return servD;
    }

    public void setServD(ArrayList<ServicoDetalheTO> servD) {
        this.servD = servD;
    }
    private ArrayList<CaixaTO> caixas;
    private ArrayList<EntradaCaixaTO> entradas;
    private ArrayList<SaidaCaixaTO> saidas;
    private ArrayList<ProdutoDetalheTO> prodD;
    private ArrayList<ServicoDetalheTO> servD;

    public ArrayList<EntradaCaixaTO> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<EntradaCaixaTO> entradas) {
        this.entradas = entradas;
    }

    public ArrayList<SaidaCaixaTO> getSaidas() {
        return saidas;
    }

    public void setSaidas(ArrayList<SaidaCaixaTO> saidas) {
        this.saidas = saidas;
    }

    public EntradaCaixaTO getEntradaTo() {
        return entradaTo;
    }

    public void setEntradaTo(EntradaCaixaTO entradaTo) {
        this.entradaTo = entradaTo;
    }

    public SaidaCaixaTO getSaidaTo() {
        return saidaTo;
    }

    public void setSaidaTo(SaidaCaixaTO saidaTo) {
        this.saidaTo = saidaTo;
    }

    public CaixaTO getCaixaTo() {
        return caixaTo;
    }

    public void setCaixaTo(CaixaTO caixaTo) {
        this.caixaTo = caixaTo;
    }

    public CaixaTO getCaixaConsultaTo() {
        return caixaConsultaTo;
    }

    public void setCaixaConsultaTo(CaixaTO caixaConsultaTo) {
        this.caixaConsultaTo = caixaConsultaTo;
    }

    public ArrayList<CaixaTO> getCaixas() {
        return caixas;
    }

    public void setCaixas(ArrayList<CaixaTO> caixas) {
        this.caixas = caixas;
    }

    public CaixaCRTL() {
        try {
            caixaTo = new CaixaTO();
            caixaConsultaTo = new CaixaTO();
            entradaTo = new EntradaCaixaTO();
            saidaTo = new SaidaCaixaTO();
            prodD = new ArrayList();
            servD = new ArrayList();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public String incluirCaixa() {
        try {
            CaixaBO caixaBo = new CaixaBO();
            String ret = caixaBo.incluir(caixaTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Caixa aberto com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "";
    }

    public void alterarCaixa() {
        try {
            CaixaBO caixaBo = new CaixaBO();
            String ret = caixaBo.alterar(caixaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "caixa fechado com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o caixa!");
        }
    }

    public void alterarSaidaCaixa() throws Exception {

        CaixaBO caixaBo = new CaixaBO();
        String ret = caixaBo.alterarSaidaCaixa(saidaTo);
        if (!"".equals(ret)) {
            JOptionPane.showMessageDialog(null, ret);
        }
    }

    public void alterarObs(CaixaTO caixaTo) throws Exception {
        try {
            CaixaBO caixaBo = new CaixaBO();
            String ret = caixaBo.alterarObs(caixaTo);

            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public CaixaTO consultar(String nome) {

        try {
            CaixaBO caixaBo = new CaixaBO();
            caixaTo = caixaBo.consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return caixaTo;
    }

    public CaixaTO consultarID(int id) {

        try {
            CaixaBO caixaBo = new CaixaBO();
            caixaTo = caixaBo.consultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return caixaTo;
    }

    public CaixaTO valorTotal() {
        try {
            CaixaBO caixaBo = new CaixaBO();
            caixaTo = caixaBo.valorTotal();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular o valor total!");
        }
        return caixaTo;
    }

    public CaixaTO ValorTotalSomenteCaixa() throws Exception {
        CaixaBO caixaBo = new CaixaBO();
        caixaTo = caixaBo.valorTotalSomenteCaixa();
        return caixaTo;
    }

    public void maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }

    public String adicionarDinheiro() {
        try {
            CaixaBO caixaBo = new CaixaBO();
            String ret = caixaBo.adicionarDinheiro(entradaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Dinheiro adicionado com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar!!");
        }
        return "";
    }

    public String adicionarDinheiroDAO() {
        try {
            CaixaDAO dao = new CaixaDAO();
            String ret = dao.adicionarDinheiro2(entradaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Dinheiro adicionado com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar!!");
        }
        return "";
    }

    public String retirarDinheiro() {
        try {
            CaixaBO caixaBo = new CaixaBO();
            String ret = caixaBo.retirarDinheiro(saidaTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Dinheiro retirado com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao retirar!!");
        }
        return "";
    }

    public void somenteNumero(JTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL2(tamanho));
    }

    public ArrayList<EntradaCaixaTO> consultarTodosEntrada() {

        try {
            CaixaBO caixaBo = new CaixaBO();
            entradas = caixaBo.consultarTodosEntrada();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return entradas;
    }

    public ArrayList<EntradaCaixaTO> consultarTodosCli() {

        try {
            CaixaBO caixaBo = new CaixaBO();
            entradas = caixaBo.consultarTodosCli();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return entradas;
    }

    public ArrayList<ProdutoDetalheTO> produtoDetalhe(int codcliente) {

        try {
            CaixaBO caixaBo = new CaixaBO();
            prodD = caixaBo.produtoDetalhe(codcliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return prodD;
    }

    public ArrayList<ServicoDetalheTO> servicoDetalhe(int codcliente) {

        try {
            CaixaBO caixaBo = new CaixaBO();
            servD = caixaBo.servicoDetalhe(codcliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return servD;
    }

    public ArrayList<SaidaCaixaTO> consultarTodosSaida() {

        try {
            CaixaBO caixaBo = new CaixaBO();
            saidas = caixaBo.consultarTodosSaida();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return saidas;
    }

    public void somenteNumero2(JTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL2(tamanho));
    }
}
