package bo;

import to.PessoaTO;

public abstract interface PessoaBO {

    public String incluir(PessoaTO pessoaTo) throws Exception;
    
    public String alterar(PessoaTO pessoaTo) throws Exception;
}
