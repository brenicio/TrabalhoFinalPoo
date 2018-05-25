package bo;

import dao.VendaDAO;
import to.ItemVendaTO;
import to.VendaTO;

public class VendaBO {

    private final VendaDAO vendaDao;
    VendaTO vendaTo;
    ItemVendaTO itemTo;

    public VendaBO() throws Exception {
        vendaDao = new VendaDAO();
        vendaTo = new VendaTO();
        itemTo = new ItemVendaTO();
    }

    public String incluirVenda(VendaTO vendaTo) throws Exception {

//        prodTo = produtoDao.VerificarProduto(produtoTo.getDescrProd());
        String ret = "";

        ret = vendaDao.incluirVenda(vendaTo);

        return ret;

    }

    public String incluirItemVenda(ItemVendaTO itemTo) throws Exception {

//        prodTo = produtoDao.VerificarProduto(produtoTo.getDescrProd());
        String ret = "";

        ret = vendaDao.incluirItemVenda(itemTo);
        return ret;

    }

    public String incluirItemVendaProd(ItemVendaTO itemTo) throws Exception {

//        prodTo = produtoDao.VerificarProduto(produtoTo.getDescrProd());
        String ret = "";

        ret = vendaDao.incluirItemVendaProd(itemTo);

        return ret;
    }
}
