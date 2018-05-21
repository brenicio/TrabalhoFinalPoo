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
    private ClienteBO cliBo;

    public PessoasCRTL() {
        funcBo = new FuncionarioBO();
        cliBo = new ClienteBO();
    }

    public String Incluir() {
        String ret;
        if (pessoasTo instanceof FuncionarioTO) {

            ret = funcBo.Incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }

        } else {

            ret = cliBo.Incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        }
    }

    public String Alterar() {
        String ret;
        if (pessoasTo instanceof FuncionarioTO) {

            ret = funcBo.Incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        } else {

            ret = cliBo.Incluir(pessoasTo);
            if (!"".equals(ret)) {
                return ret;
            } else {
                return "limpar";
            }
        }
    }

    public PessoasTO Consultar(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            return funcBo.Consultar(p.getNome());
        } else {
            return cliBo.Consultar(p.getNome());
        }
    }

    public PessoasTO Consultar(int id, String tipo) {        
            return cliBo.Consultar(id);        
    }

    public ArrayList<PessoasTO> ConsultarTodos(String tipo) {
        if (tipo.equals("funcionario")) {
            return funcBo.ConsultarTodos();
        } else {
            return cliBo.ConsultarTodos();
        }
    }

    public ArrayList<PessoasTO> ConsultarTodos(String nome, String tipo) {
        return cliBo.ConsultarTodos(nome);
    }

    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda() {
        return cliBo.ConsultarTodosAtivosClienteVenda();
    }

    public ArrayList<PessoasTO> ConsultarTodosAtivosClienteVenda(String nome) {
        return cliBo.ConsultarTodosAtivosClienteVenda(nome);
    }

    public PessoasTO ConsultarClienteIDVenda(int id) {
        return cliBo.ConsultarClienteIDVenda(id);
    }

    public void Excluir(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            funcBo.ExcluirID(((FuncionarioTO) p).getMatricula());
        } else {
            cliBo.ExcluirID(((ClienteTO) p).getCodCliente());
        }
    }

    public PessoasTO getPessoasTo() {
        return pessoasTo;
    }

    public void setPessoasTo(PessoasTO pessoasTo) {
        this.pessoasTo = pessoasTo;
    }

}
