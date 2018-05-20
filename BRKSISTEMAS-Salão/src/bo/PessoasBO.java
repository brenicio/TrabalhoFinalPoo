package bo;

import to.PessoasTO;

public abstract interface PessoasBO {

    public String incluir(PessoasTO pessoaTo) throws Exception;
    
    public String alterar(PessoasTO pessoaTo) throws Exception;
}
