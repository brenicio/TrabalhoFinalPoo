package bo;

import java.util.ArrayList;
import to.PessoasTO;

public abstract interface PessoasBO {

    public String incluir(PessoasTO pessoaTo);

    public String alterar(PessoasTO pessoaTo);

    public PessoasTO consultar(String nome);

    public PessoasTO consultar(int id);

    public ArrayList<PessoasTO> consultarTodos();

    public void excluirID(long id);
}
