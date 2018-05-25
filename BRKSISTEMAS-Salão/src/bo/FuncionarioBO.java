package bo;

import to.FuncionarioTO;
import dao.FuncionarioDAO;
import java.util.ArrayList;
import to.PessoasTO;

public class FuncionarioBO implements PessoasBO {

    private final FuncionarioDAO funcionarioDao;
    private FuncionarioTO funcionarioTo;

    public FuncionarioBO() {
        funcionarioDao = new FuncionarioDAO();
        funcionarioTo = new FuncionarioTO();

    }

    @Override
    public String incluir(PessoasTO pessoasTo) {
        String ret = consisteDados(pessoasTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = verificaFuncionario(pessoasTo);
        if (!ret.equals("")) {

            return ret;
        }

        ret = funcionarioDao.incluir(pessoasTo);
        return ret;
    }

    @Override
    public String alterar(PessoasTO pessoaTo) {
        String ret = consisteDados((FuncionarioTO) pessoaTo);
        if (!ret.equals("")) {
            return ret;
        }

        ret = funcionarioDao.alterar((FuncionarioTO) pessoaTo);
        return ret;
    }

    private String verificaFuncionario(PessoasTO p) {
        FuncionarioTO funcTo = (FuncionarioTO) p;

        funcionarioTo = (FuncionarioTO) funcionarioDao.verificarFuncionario(funcTo.getRg(), funcTo.getCpf(), funcTo.getMatricula());
        if (funcTo.getRg().equals(funcionarioTo.getRg()) | funcTo.getCpf().equals(funcionarioTo.getCpf())) {
            return "O RG ou CPF informado já pertence a um Funcionario Cadastrado! Verifique os dados informados e tente novamente.";
        }
        if (funcTo.getMatricula() == funcionarioTo.getMatricula()) {
            return "Já existe um funcionario com a matricula: " + funcTo.getMatricula() + " digite outra matricula!";
        }
        return "";

    }

    private String consisteDados(PessoasTO p) {
        funcionarioTo = (FuncionarioTO) p;
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

    @Override
    public PessoasTO consultar(String nome) {
        PessoasTO p = funcionarioDao.consultar(nome);
        return p;
    }

    @Override
    public PessoasTO consultar(int id) {
        PessoasTO p = funcionarioDao.consultar(id);
        return p;
    }

    @Override
    public ArrayList<PessoasTO> consultarTodos() {
        ArrayList<PessoasTO> p = funcionarioDao.consultarTodos();
        return p;
    }

    @Override
    public void excluirID(long id) {
        funcionarioDao.excluirID(id);
    }
}
