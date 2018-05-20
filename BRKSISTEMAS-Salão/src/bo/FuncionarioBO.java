package bo;

import to.FuncionarioTO;
import dao.FuncionarioDAO;
import java.util.ArrayList;
import to.PessoaTO;

public class FuncionarioBO implements PessoaBO {

    private static FuncionarioDAO funcionarioDao;
    private static FuncionarioTO funcionarioTo;

    public FuncionarioBO() throws Exception {
        funcionarioDao = new FuncionarioDAO();
        funcionarioTo = new FuncionarioTO();

    }

    @Override
    public String incluir(PessoaTO pessoaTo) throws Exception {
        FuncionarioTO funcTo = (FuncionarioTO) pessoaTo;
        String ret = consisteDados(funcTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = VerificaFuncionario(funcTo);
        if (!ret.equals("")) {

            return ret;
        }

        ret = funcionarioDao.incluir((FuncionarioTO) funcTo);
        return ret;
    }

    
    @Override
    public String alterar(PessoaTO pessoaTo) throws Exception {
        PessoaTO cliente = pessoaTo;
        String ret = consisteDados((FuncionarioTO) pessoaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = funcionarioDao.alterar((FuncionarioTO) pessoaTo);
        return ret;
    }

    private static String VerificaFuncionario(FuncionarioTO funcTo) throws Exception {
        funcionarioTo = funcionarioDao.VerificarFuncionario(funcTo.getRg(), funcTo.getCpf(), funcTo.getMatricula());
        if (funcTo.getRg().equals(funcionarioTo.getRg()) | funcTo.getCpf().equals(funcionarioTo.getCpf())) {
            return "O RG ou CPF informado já pertence a um Funcionario Cadastrado! Verifique os dados informados e tente novamente.";
        }
        if (funcTo.getMatricula() == funcionarioTo.getMatricula()) {
            return "Já existe um funcionario com a matricula: " + funcTo.getMatricula() + " digite outra matricula!";
        }
        return "";

    }

    private static String consisteDados(FuncionarioTO funcionarioTo) {
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
