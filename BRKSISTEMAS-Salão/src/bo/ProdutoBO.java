package bo;
import dao.ProdutoDAO;
import java.util.ArrayList;
import to.CategoriaTO;
import to.MarcaTO;
import to.ProdutoTO;
public class ProdutoBO {
     private final ProdutoDAO produtoDao;
    ProdutoTO prodTo;
     public ProdutoBO() throws Exception {
        produtoDao = new ProdutoDAO();
        prodTo = new ProdutoTO();
    }
     
     public String incluir (ProdutoTO produtoTo) throws Exception{
        
//        prodTo = produtoDao.VerificarProduto(produtoTo.getDescrProd());
        
        String ret = consisteDados(produtoTo);
        
        
       if (!ret.equals("")) {
            return ret; 
        }
       
          ret = produtoDao.incluir(produtoTo); 
         
        return ret; 
       
                        
    }
     
     public String alterar (ProdutoTO produtoTo) throws Exception{
        String ret = consisteDados(produtoTo);
        if (!ret.equals("")){
            return ret;
        }
        
        ret = produtoDao.alterar(produtoTo);
        return ret;
    }
     
     private String consisteDados(ProdutoTO produtoTo){
//        if(produtoTo.getDescrProd().equals(prodTo.getDescrProd())){
//            return "O Produto informado já existe!";
//        }
        if (produtoTo.getDescrProd().equals("")) {
           return "Descrição não informada!";   
           
        }
        if (produtoTo.getCodBarra() == 0) {
            
            return "Codigo de barra não informado!";
        }
        if (produtoTo.getCodMarca() == 0){
            return "Marca não informada!";
        }
        if (produtoTo.getLucroProd()== 0){
            return "Lucro não informado!";
        }
        if (produtoTo.getQtdeProd()== 0){
            return "Quantidade não informada!";
        }
        if (produtoTo.getValorCusto()== 0){
            return "Valor de custo não informado!";
        }
        if (produtoTo.getValorVenda()== 0){
            return "Valor de venda não informado!";
        }
        

         
      return "";
    }
     
     public ProdutoTO Consultar(String nome) throws Exception {
        ProdutoTO produtoTo = produtoDao.Consultar(nome);       
        return produtoTo;
    }
     public ProdutoTO ConsultarID(int id) throws Exception {
        ProdutoTO produtoTo = produtoDao.ConsultarID(id);       
        return produtoTo;
    }
     public MarcaTO ConsultarNOME(String nome)throws Exception{
         MarcaTO marcaTo = produtoDao.ConsultarNOME(nome);
         return marcaTo;
     }
     public CategoriaTO ConsultarNOME2(String nome)throws Exception{
         CategoriaTO catTo = produtoDao.ConsultarNOME2(nome);
         return catTo;
     }
     public ProdutoTO ConsultarIDF(int id) throws Exception{
       ProdutoTO produtoTo = produtoDao.ConsultarIDF(id);
       return produtoTo;
     }
     public ArrayList <ProdutoTO> consultarTodos() throws Exception {
        ArrayList usuarios = produtoDao.consultarTodos();
        return usuarios;
    }
     public ArrayList <String> consultarMarcas() throws Exception{
         ArrayList<String> marcas = produtoDao.consultarMarca();
         return marcas;
     }
     public ArrayList <String> consultarCategorias() throws Exception{
         ArrayList<String> categorias = produtoDao.consultarCategoria();
         return categorias;
     }
     public String excluirID (long id) throws Exception {
        String ret = produtoDao.excluirID(id);
        return ret;
    }
     public ArrayList<ProdutoTO> consultarTodosP(String nome) throws Exception {

        ArrayList produtos = produtoDao.consultarTodosP(nome);
        return produtos;
    }
}
