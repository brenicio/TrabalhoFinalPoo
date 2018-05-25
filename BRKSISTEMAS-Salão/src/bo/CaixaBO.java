package bo;

import dao.CaixaDAO;
import to.CaixaTO;
import java.util.ArrayList;
import to.EntradaCaixaTO;
import to.ProdutoDetalheTO;
import to.SaidaCaixaTO;
import to.ServicoDetalheTO;

public class CaixaBO {

    private final CaixaDAO caixaDao;
    CaixaTO caixTo;

    public CaixaBO() throws Exception {
        caixaDao = new CaixaDAO();
        caixTo = new CaixaTO();
    }

    public String incluir(CaixaTO caixaTo) throws Exception {

        String ret = consisteDadosAbrir(caixaTo);
        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.incluir(caixaTo);
        return ret;

    }

    public String alterar(CaixaTO caixaTo) throws Exception {

        String ret = consisteDadosFechar(caixaTo);
        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.alterar(caixaTo);
        return ret;
    }

    public String alterarObs(CaixaTO caixaTo) throws Exception {
        String ret;

        ret = caixaDao.alterarObs(caixaTo);
        return ret;
    }

    public String alterarSaidaCaixa(SaidaCaixaTO saidaTo) throws Exception {
        String ret = "";
        ret = caixaDao.alterarSaidaCaixa(saidaTo);
        return ret;
    }

    private String consisteDadosFechar(CaixaTO caixaTo) {
        if (caixaTo.getValfinal() == null) {
            return "Saldo final não informado!";
        }
        return "";

    }

    private String consisteDadosAbrir(CaixaTO caixaTo) {
        if (caixaTo.getValinicial() == null) {
            return "Valor inicial não informado!";
        }
        return "";
    }

    private String consisteDados2(SaidaCaixaTO saidaTo) {
        if (saidaTo.getValor() == null) {
            return "Valor não informado!";
        }
        return "";
    }

    private String consisteDados3(EntradaCaixaTO entradaTo) {
        if (entradaTo.getValor() == null) {
            return "Valor não informado!";
        }
        return "";
    }

    public CaixaTO consultar(String nome) throws Exception {

        CaixaTO caixaTo = caixaDao.consultar(nome);
        return caixaTo;
    }

    public CaixaTO consultarID(int id) throws Exception {

        CaixaTO caixaTo = caixaDao.consultarID(id);
        return caixaTo;
    }

    public CaixaTO valorTotal() throws Exception {
        CaixaTO caixaTo = caixaDao.valorTotal();
        return caixaTo;
    }

    public CaixaTO valorTotalSomenteCaixa() throws Exception {
        CaixaTO caixaTo = caixaDao.valorTotalSomenteCaixa();
        return caixaTo;
    }

    public String adicionarDinheiro(EntradaCaixaTO entradaTo) throws Exception {
        String ret = consisteDados3(entradaTo);

        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.adicionarDinheiro(entradaTo);
        return ret;
    }

    public String retirarDinheiro(SaidaCaixaTO saidaTo) throws Exception {
        String ret = consisteDados2(saidaTo);
        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.retirarDinheiro(saidaTo);
        return ret;
    }

    public ArrayList<EntradaCaixaTO> consultarTodosEntrada() throws Exception {

        ArrayList entradas = caixaDao.consultarTodosEntrada();
        return entradas;
    }

    public ArrayList<EntradaCaixaTO> consultarTodosCli() throws Exception {

        ArrayList entradas = caixaDao.consultarTodosEntradaCli();
        return entradas;
    }

    public ArrayList<SaidaCaixaTO> consultarTodosSaida() throws Exception {

        ArrayList saidas = caixaDao.consultarTodosSaida();
        return saidas;
    }

    public ArrayList<ProdutoDetalheTO> produtoDetalhe(int codcliente) throws Exception {
        ArrayList prod = caixaDao.produtoDetalhe(codcliente);
        return prod;
    }

    public ArrayList<ServicoDetalheTO> servicoDetalhe(int codcliente) throws Exception {
        ArrayList serv = caixaDao.servicoDetalhe(codcliente);
        return serv;
    }
}
