package crtl;

import bo.ClienteBO;
import bo.FuncionarioBO;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.ClienteTO;
import to.FuncionarioTO;
import to.PessoasTO;

public class PessoasCRTL {

    private PessoasTO pessoasTo;
    private ArrayList<PessoasTO> pessoas;
    private FuncionarioBO funcBo;
    private ClienteBO cliBo;

    public PessoasCRTL() {
        pessoas = new ArrayList();
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

    public PessoasTO ConsultarID(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            return funcBo.ConsultarID(((FuncionarioTO) p).getMatricula());
        } else {
            return cliBo.ConsultarID(((ClienteTO) p).getCodCliente());
        }
    }

    public ArrayList<PessoasTO> ConsultarTodos(String tipo) {
        if (tipo.equals("funcionario")) {
            return funcBo.ConsultarTodos();
        } else {
            return cliBo.ConsultarTodos();
        }
    }

    public void Excluir(PessoasTO p) {
        if (p instanceof FuncionarioTO) {
            funcBo.ExcluirID(((FuncionarioTO) p).getMatricula());
        } else {
            cliBo.ExcluirID(((ClienteTO) p).getCodCliente());
        }
    }

    

}
