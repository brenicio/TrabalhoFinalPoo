package bo;

import dao.ServicoDAO;
import java.util.ArrayList;
import to.ServicoTO;

public class ServicoBO {

    private final ServicoDAO servicoDao;
    ServicoTO servTo;

    public ServicoBO() throws Exception {
        servicoDao = new ServicoDAO();
        servTo = new ServicoTO();
    }

    public String incluir(ServicoTO servicoTo) throws Exception {
        String ret = consisteDados(servicoTo);
        if (!ret.equals("")) {
            return ret;
        }
        ret = verificaServico(servicoTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = servicoDao.incluir(servicoTo);

        return ret;

    }

    public String alterar(ServicoTO servicoTo) throws Exception {
        String ret = consisteDados(servicoTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = servicoDao.alterar(servicoTo);
        return ret;
    }

    private String consisteDados(ServicoTO servicoTo) {

        if (servicoTo.getDescrServico().equals("")) {
            return "Descrição não informada";
        }
        return "";
    }

    private String verificaServico(ServicoTO servicoTo) throws Exception {
        servTo = servicoDao.VerificarServicos(servicoTo.getDescrServico());
        if (servicoTo.getDescrServico().equals(servTo.getDescrServico())) {
            return "A Descrição do Serviço informada já existe no sistema!";
        }
        return "";
    }

    public ServicoTO consultar(String nome) throws Exception {
        ServicoTO servicoTo = servicoDao.Consultar(nome);
        return servicoTo;
    }

    public ServicoTO consultarID(int id) throws Exception {
        ServicoTO servicoTo = servicoDao.ConsultarID(id);
        return servicoTo;
    }

    public ArrayList<ServicoTO> consultarTodos() throws Exception {
        ArrayList clientes = servicoDao.consultarTodos();
        return clientes;
    }

    public ArrayList<ServicoTO> consultarTodosC(String nome) throws Exception {
        ArrayList clientes = servicoDao.consultarTodosC(nome);
        return clientes;
    }

    public String excluirID(long id) throws Exception {
        String ret;
        ret = servicoDao.excluirID(id);
        return ret;
    }
}
