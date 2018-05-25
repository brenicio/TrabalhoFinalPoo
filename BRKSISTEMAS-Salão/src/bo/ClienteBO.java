package bo;

import dao.ClienteDAO;
import java.util.ArrayList;
import to.ClienteTO;
import to.PessoasTO;

public class ClienteBO implements PessoasBO {

    private final ClienteDAO clienteDao;
    private ClienteTO cliTo;

    public ClienteBO() {
        clienteDao = new ClienteDAO();
        cliTo = new ClienteTO();
    }

    @Override
    public String incluir(PessoasTO pessoasTo) {
        String ret = consisteDados(pessoasTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = verificaCliente(pessoasTo);
        if (!ret.equals("")) {

            return ret;
        }
        ret = clienteDao.incluir(pessoasTo);
        return ret;
    }

    @Override
    public String alterar(PessoasTO pessoasTo) {
        String ret = consisteDados(pessoasTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = clienteDao.alterar(pessoasTo);
        return ret;
    }

    private String consisteDados(PessoasTO p) {

        if (p.getNome().equals("")) {
            return "Nome não informado";
        }
        if (p.getRg().equals("")) {

            return "RG não informado";
        }
        if (p.getCpf().replace("-", "").replace(".", "").replace(" ", "").equals("")) {
            return "CPF não informado";
        }
        return "";
    }

    private String verificaCliente(PessoasTO p) {
        cliTo = (ClienteTO) clienteDao.verificarCliente(p.getRg(), p.getCpf());
        if (p.getRg().equals(cliTo.getRg()) | p.getCpf().equals(cliTo.getCpf())) {
            return "O RG ou CPF informado já pertence a um Cliente Cadastrado! Verifique os dados informados e tente novamente.";
        }
        ClienteTO to = (ClienteTO) clienteDao.verificarClienteNome(p.getNome());
        if (p.getNome().equals(to.getNome())) {
            return "Já existe um cliente com o nome de: " + p.getNome() + " !";
        }
        return "";
    }

    @Override
    public PessoasTO consultar(String nome) {
        PessoasTO p = clienteDao.consultar(nome);
        return p;
    }

    @Override
    public PessoasTO consultar(int id) {
        PessoasTO p = clienteDao.consultar(id);
        return p;
    }

    @Override
    public ArrayList<PessoasTO> consultarTodos() {
        ArrayList<PessoasTO> p = clienteDao.consultarTodos();
        return p;
    }

    public ArrayList<PessoasTO> ConsultarTodos(String nome) {
        ArrayList<PessoasTO> p = clienteDao.consultarTodos(nome);
        return p;
    }

    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda() {
        ArrayList<PessoasTO> p = clienteDao.consultarTodosClienteAtivosVenda();
        return p;
    }

    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda(String nome) {
        ArrayList<PessoasTO> p = clienteDao.consultarTodosClienteAtivosVenda(nome);
        return p;
    }

    public PessoasTO consultarClienteIDVenda(int id) {
        PessoasTO p = clienteDao.consultarClienteIDVenda(id);
        return p;
    }

    @Override
    public void excluirID(long id) {
        clienteDao.excluirID(id);
    }
}
