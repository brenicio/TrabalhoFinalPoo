package to;

import java.util.ArrayList;

public class ItensVendaProdutoTO {

    ArrayList<ItensVendaServicoTO> itensA = new ArrayList();
    ProdutoTO produtoTO = new ProdutoTO();

    public ProdutoTO getProdutoTO() {
        return produtoTO;
    }

    public void setProdutoTO(ProdutoTO produtoTO) {
        this.produtoTO = produtoTO;
    }

    public ArrayList<ItensVendaProdutoTO> retornarArray(ItensVendaProdutoTO itens) {
        ArrayList<ItensVendaProdutoTO> itensA = new ArrayList();
        itensA.add(itens);
        return itensA;
    }
}
