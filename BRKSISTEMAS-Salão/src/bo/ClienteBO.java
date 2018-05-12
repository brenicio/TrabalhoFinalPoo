package bo;

import dao.ClienteDAO;
import java.util.ArrayList;
import to.ClienteTO;
import to.PessoaTO;

public class ClienteBO extends PessoaBO {

    private final ClienteDAO clienteDao;
    private ClienteTO cliTo;

    public ClienteBO() throws Exception {
        clienteDao = new ClienteDAO();
        cliTo = new ClienteTO();
    }

    @Override
    public String incluir(PessoaTO pessoaTo) throws Exception {

        PessoaTO cliente = pessoaTo;

        String ret = consisteDados((ClienteTO) cliente);
        if (!ret.equals("")) {
            return ret;
        }

        ret = VerificaCliente((ClienteTO) cliente);
        if (!ret.equals("")) {

            return ret;
        }

        ret = clienteDao.incluir((ClienteTO) cliente);

        return ret;

    }

    public String alterar(ClienteTO clienteTo) throws Exception {
        String ret = consisteDados(clienteTo);
        if (!ret.equals("")) {
            //  JOptionPane.showMessageDialog(null, "chegou em BOif-1");
            return ret;

        }

        ret = clienteDao.alterar(clienteTo);
        return ret;
    }

    private String consisteDados(ClienteTO clienteTo) {

        if (clienteTo.getNomeCli().equals("")) {
            return "Nome não informado";
        }
        if (clienteTo.getRgCli().equals("")) {

            return "RG não informado";
        }
        if (clienteTo.getCpfCli().replace("-", "").replace(".", "").replace(" ", "").equals("")) {
            return "CPF não informado";
        }

        return "";
    }

    private String VerificaCliente(ClienteTO clienteTo) throws Exception {
        cliTo = clienteDao.VerificarCliente(clienteTo.getRgCli(), clienteTo.getCpfCli());
        if (clienteTo.getRgCli().equals(cliTo.getRgCli()) | clienteTo.getCpfCli().equals(cliTo.getCpfCli())) {
            return "O RG ou CPF informado já pertence a um Cliente Cadastrado! Verifique os dados informados e tente novamente.";
        }
        ClienteTO to = clienteDao.VerificarClienteNome(clienteTo.getNomeCli());
        if (clienteTo.getNomeCli().equals(to.getNomeCli())) {
            return "Já existe um cliente com o nome de: " + clienteTo.getNomeCli() + " !";
        }
        return "";

    }

    public ClienteTO Consultar(String nome) throws Exception {
        ClienteTO clienteTo = clienteDao.Consultar(nome);
        return clienteTo;
    }

    public ClienteTO ConsultarID(int id) throws Exception {
        ClienteTO clienteTo = clienteDao.ConsultarID(id);
        return clienteTo;
    }

    public ArrayList<ClienteTO> consultarTodos() throws Exception {
        ArrayList clientes = clienteDao.consultarTodos();
        return clientes;
    }

    public ArrayList<ClienteTO> consultarTodosC(String nome) throws Exception {
        ArrayList clientes = clienteDao.consultarTodosC(nome);
        return clientes;
    }

    public String excluirID(long id) throws Exception {
        String ret;
        ret = clienteDao.excluirID(id);
        return ret;
    }
}
