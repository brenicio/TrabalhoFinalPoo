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

    public CaixaTO Consultar(String nome) throws Exception {

        CaixaTO caixaTo = caixaDao.Consultar(nome);
        return caixaTo;
    }

    public CaixaTO ConsultarID(int id) throws Exception {

        CaixaTO caixaTo = caixaDao.ConsultarID(id);
        return caixaTo;
    }

    public CaixaTO ValorTotal() throws Exception {
        CaixaTO caixaTo = caixaDao.ValorTotal();
        return caixaTo;
    }

    public CaixaTO ValorTotalSomenteCaixa() throws Exception {
        CaixaTO caixaTo = caixaDao.ValorTotalSomenteCaixa();
        return caixaTo;
    }

    public String AdicionarDinheiro(EntradaCaixaTO entradaTo) throws Exception {
        String ret = consisteDados3(entradaTo);

        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.AdicionarDinheiro(entradaTo);
        return ret;

    }

    public String RetirarDinheiro(SaidaCaixaTO saidaTo) throws Exception {
        String ret = consisteDados2(saidaTo);
        if (!ret.equals("")) {
            return ret;
        }
        ret = caixaDao.RetirarDinheiro(saidaTo);
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

    public ArrayList<ProdutoDetalheTO> ProdutoDetalhe(int codcliente) throws Exception {
        ArrayList prod = caixaDao.ProdutoDetalhe(codcliente);
        return prod;
    }

    public ArrayList<ServicoDetalheTO> ServicoDetalhe(int codcliente) throws Exception {
        ArrayList serv = caixaDao.ServicoDetalhe(codcliente);
        return serv;
    }
}
