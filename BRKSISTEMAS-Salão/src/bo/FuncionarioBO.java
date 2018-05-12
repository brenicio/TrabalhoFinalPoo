package bo;

import to.FuncionarioTO;
import dao.FuncionarioDAO;
import java.util.ArrayList;

public class FuncionarioBO extends PessoaBO {

    private final FuncionarioDAO funcionarioDao;
    private FuncionarioTO funcionarioTo;

    public FuncionarioBO() throws Exception {
        funcionarioDao = new FuncionarioDAO();
        funcionarioTo = new FuncionarioTO();

    }

    public String incluir(FuncionarioTO funcionarioTo) throws Exception {
        String ret = consisteDados(funcionarioTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = VerificaFuncionario(funcionarioTo);
        if (!ret.equals("")) {

            return ret;
        }

        ret = funcionarioDao.incluir(funcionarioTo);
        //  System.out.println(ret);
        return ret;
    }

    public String alterar(FuncionarioTO funcionarioTo) throws Exception {
        String ret = consisteDados(funcionarioTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = funcionarioDao.alterar(funcionarioTo);
        return ret;
    }

    private String VerificaFuncionario(FuncionarioTO funcTo) throws Exception {
        funcionarioTo = funcionarioDao.VerificarFuncionario(funcTo.getRg(), funcTo.getCpf(), funcTo.getMatricula());
        if (funcTo.getRg().equals(funcionarioTo.getRg()) | funcTo.getCpf().equals(funcionarioTo.getCpf())) {
            return "O RG ou CPF informado já pertence a um Funcionario Cadastrado! Verifique os dados informados e tente novamente.";
        }
        //FuncionarioTO to = funcionarioDao.VerificarClienteNome(clienteTo.getNomeCli());
        if (funcTo.getMatricula() == funcionarioTo.getMatricula()) {
            return "Já existe um funcionario com a matricula: " + funcTo.getMatricula() + " digite outra matricula!";
        }
        return "";

    }

    private String consisteDados(FuncionarioTO funcionarioTo) {
        if (funcionarioTo.getMatricula() == 0) {
            return "Matricula não informada!";
        }
        if (funcionarioTo.getNome().equals("")) {
            return "Nome não informado!";
        }
        if (funcionarioTo.getCargo().equals("")) {

            return "Cargo não informado!";
        }
        if (funcionarioTo.getCpf().equals("")) {
            return "Cpf não informado!";
        }
        if (funcionarioTo.getRg().equals("")) {
            return "RG não informado!";
        }

        return "";
    }

    public FuncionarioTO Consultar(String nome) throws Exception {
        FuncionarioDAO funcDao = new FuncionarioDAO();
        FuncionarioTO funcTo = funcDao.Consultar(nome);
        return funcTo;
    }

    public FuncionarioTO ConsultarID(int id) throws Exception {
        FuncionarioDAO funcDao = new FuncionarioDAO();
        FuncionarioTO funcTo = funcDao.ConsultarID(id);
        return funcTo;
    }

    public ArrayList<FuncionarioTO> consultarTodos() throws Exception {
        FuncionarioDAO funcDao = new FuncionarioDAO();
        ArrayList funcionarios = funcDao.consultarTodos();
        return funcionarios;
    }

    public void excluirID(long id) throws Exception {
        FuncionarioDAO funcDao = new FuncionarioDAO();
        funcDao.excluirID(id);
    }
}
