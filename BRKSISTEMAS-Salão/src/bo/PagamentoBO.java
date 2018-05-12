package bo;
import dao.PagamentoDAO;
import to.PagamentoTO;
import java.util.ArrayList;
public class PagamentoBO {
    private final PagamentoDAO pagamentoDao;
    PagamentoTO pagTo;
    public PagamentoBO(){
        pagamentoDao = new PagamentoDAO();
        pagTo = new PagamentoTO();
    }
    public String incluir(PagamentoTO pagamentoTo) throws Exception {
         pagTo = pagamentoDao.VerificarPagamento(pagamentoTo);
        String ret=consisteDados(pagamentoTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = pagamentoDao.incluir(pagamentoTo);

        return ret;

    }
     public String alterar(PagamentoTO pagamentoTo) throws Exception {
        pagTo = pagamentoDao.VerificarPagamento(pagamentoTo);
        String ret = consisteDados(pagamentoTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = pagamentoDao.alterar(pagamentoTo);
        return ret;
    }
     private String consisteDados(PagamentoTO pagamentoTo) {

        if (pagamentoTo.getDescpagamento().equals(pagTo.getDescpagamento())) {
            return "A Forma de pagamento informada já existe!";
        }

        if (pagamentoTo.getDescpagamento().equals("")) {
            return "Forma de pagamento não informada!";
        }
        if (pagamentoTo.getTipopagamento().equals("")){
            return "Tipo de pagamento não informado!";
        }
        return "";
    }
     public PagamentoTO Consultar(String nome) throws Exception {

        PagamentoTO pagamentoTo = pagamentoDao.Consultar(nome);
        return pagamentoTo;
    }
     public PagamentoTO ConsultarID(int id) throws Exception {

        PagamentoTO pagamentoTo = pagamentoDao.ConsultarID(id);
        return pagamentoTo;
    }
     public ArrayList<PagamentoTO> consultarTodos() throws Exception {

        ArrayList fpagamentos = pagamentoDao.consultarTodos();
        return fpagamentos;
    }
     public ArrayList<PagamentoTO> consultarTodosM(String nome) throws Exception {

        ArrayList fpagamentos = pagamentoDao.consultarTodosP(nome);
        return fpagamentos;
    }
     public String excluirID(long id) throws Exception {
        String ret = pagamentoDao.excluirID(id);
        return ret;
    }
}
