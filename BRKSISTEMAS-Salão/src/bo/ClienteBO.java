package bo;

import dao.ClienteDAO;
import java.util.ArrayList;
import to.ClienteTO;
import to.PessoasTO;

public class ClienteBO implements PessoasBO {

    private final ClienteDAO clienteDao;
    private ClienteTO cliTo;

    public ClienteBO(){
        clienteDao = new ClienteDAO();
        cliTo = new ClienteTO();
    }

    @Override
    public String Incluir(PessoasTO pessoasTo){
        String ret = consisteDados(pessoasTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = VerificaCliente(pessoasTo);
        if (!ret.equals("")) {

            return ret;
        }
        ret = clienteDao.Incluir(pessoasTo);
        return ret;
    }

    @Override
    public String Alterar(PessoasTO pessoasTo){
        String ret = consisteDados(pessoasTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = clienteDao.Alterar(pessoasTo);
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

    private String VerificaCliente(PessoasTO p) {
        cliTo = (ClienteTO)clienteDao.VerificarCliente(p.getRg(), p.getCpf());
        if (p.getRg().equals(cliTo.getRg()) | p.getCpf().equals(cliTo.getCpf())) {
            return "O RG ou CPF informado já pertence a um Cliente Cadastrado! Verifique os dados informados e tente novamente.";
        }
        ClienteTO to = (ClienteTO)clienteDao.VerificarClienteNome(p.getNome());
        if (p.getNome().equals(to.getNome())) {
            return "Já existe um cliente com o nome de: " + p.getNome() + " !";
        }
        return "";

    }

    @Override
    public PessoasTO Consultar(String nome){
        PessoasTO p = clienteDao.Consultar(nome);
        return p;
    }

    @Override
    public PessoasTO Consultar(int id){
        PessoasTO p = clienteDao.Consultar(id);
        return p;
    }

    @Override
    public ArrayList<PessoasTO> ConsultarTodos(){
        ArrayList<PessoasTO> p = clienteDao.ConsultarTodos();
        return p;
    }

    public ArrayList<PessoasTO> ConsultarTodos(String nome){
        ArrayList<PessoasTO> p = clienteDao.ConsultarTodos(nome);
        return p;
    }
    
    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda(){
        ArrayList<PessoasTO>p = clienteDao.ConsultarTodosClienteAtivosVenda();
        return p;
    }
    
    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda(String nome){
        ArrayList<PessoasTO>p = clienteDao.ConsultarTodosClienteAtivosVenda(nome);
        return p;
    }
    public PessoasTO ConsultarClienteIDVenda(int id) {
        PessoasTO p = clienteDao.ConsultarClienteIDVenda(id);
        return p;
    }
    

    @Override
    public void ExcluirID(long id){
        clienteDao.ExcluirID(id);
    }
}
