package bo;

import java.util.ArrayList;
import to.PessoasTO;

public abstract interface PessoasBO {

    public String Incluir(PessoasTO pessoaTo);
    
    public String Alterar(PessoasTO pessoaTo);
    
    public PessoasTO Consultar(String nome);
    
    public PessoasTO Consultar(int id);
    
    public ArrayList<PessoasTO> ConsultarTodos();
    
    public void ExcluirID(long id);
}
