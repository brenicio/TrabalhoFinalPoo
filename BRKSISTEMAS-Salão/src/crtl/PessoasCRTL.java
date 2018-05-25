package crtl;

import bo.ClienteBO;
import bo.FuncionarioBO;
import java.util.ArrayList;
import to.ClienteTO;
import to.FuncionarioTO;
import to.PessoasTO;

public class PessoasCRTL {

    private PessoasTO pessoasTo;
    private final FuncionarioBO funcBo;
    private final ClienteBO cliBo;

    public PessoasCRTL() {
        funcBo = new FuncionarioBO();
        cliBo = new ClienteBO();
    }

    public String incluir() {
        String ret;
        if (pessoasTo instanceof FuncionarioTO) {

            ret = funcBo.incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }

        } else {

            ret = cliBo.incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        }
    }

    public String alterar() {
        String ret;
        if (pessoasTo instanceof FuncionarioTO) {

            ret = funcBo.alterar(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        } else {
            ret = cliBo.alterar(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        }
    }

    public PessoasTO consultar(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            return funcBo.consultar(p.getNome());
        } else {
            return cliBo.consultar(p.getNome());
        }
    }

    public PessoasTO consultar(int id, String tipo) {
        return cliBo.consultar(id);
    }

    public ArrayList<PessoasTO> consultarTodos(String tipo) {
        if (tipo.equals("funcionario")) {
            return funcBo.consultarTodos();
        } else {
            return cliBo.consultarTodos();
        }
    }

    public ArrayList<PessoasTO> consultarTodos(String nome, String tipo) {
        return cliBo.ConsultarTodos(nome);
    }

    public ArrayList<PessoasTO> consultarTodosAtivosClienteVenda() {
        return cliBo.ConsultarTodosAtivosClienteVenda();
    }

    public ArrayList<PessoasTO> consultarTodosAtivosClienteVenda(String nome) {
        return cliBo.ConsultarTodosAtivosClienteVenda(nome);
    }

    public PessoasTO consultarClienteIDVenda(int id) {
        return cliBo.consultarClienteIDVenda(id);
    }

    public void excluir(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            funcBo.excluirID(((FuncionarioTO) p).getMatricula());
        } else {
            cliBo.excluirID(((ClienteTO) p).getCodCliente());
        }
    }

    public PessoasTO getPessoasTo() {
        return pessoasTo;
    }

    public void setPessoasTo(PessoasTO pessoasTo) {
        this.pessoasTo = pessoasTo;
    }
}
