package to;

import java.util.ArrayList;

public class ItensVendaServicoTO {

    FuncionarioTO funcionarioTo = new FuncionarioTO();
    //ItensVendaServicoTO itens = new ItensVendaServicoTO();
    ArrayList<ItensVendaServicoTO> itensA = new ArrayList();
    ServicoTO servicoTo = new ServicoTO();
    ClienteTO clienteTo = new ClienteTO();
    ProdutoTO produtoTO = new ProdutoTO();

    public ProdutoTO getProdutoTO() {
        return produtoTO;
    }

    public void setProdutoTO(ProdutoTO produtoTO) {
        this.produtoTO = produtoTO;
    }
    
    

    public FuncionarioTO getFuncionarioTo() {
        return funcionarioTo;
       
    }

    public void setFuncionarioTo(FuncionarioTO funcionarioTo) {
        this.funcionarioTo = funcionarioTo;
    }

    public ServicoTO getServicoTo() {
        return servicoTo;
    }

    public void setServicoTo(ServicoTO servicoTo) {
        this.servicoTo = servicoTo;
    }

    public ClienteTO getClienteTo() {
        return clienteTo;
    }

    public void setClienteTo(ClienteTO clienteTo) {
        this.clienteTo = clienteTo;
    }
    
    
    public ArrayList<ItensVendaServicoTO> retornarArray(ItensVendaServicoTO itens) {
        ArrayList<ItensVendaServicoTO> itensA = new ArrayList();
        itensA.add(itens);
        return itensA;

    }
}
