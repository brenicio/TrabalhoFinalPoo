package crtl;
import bo.ProdutoBO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.LimiteDigitosMODEL2;
import model.UpperCaseMODEL2;
import to.CategoriaTO;
import to.MarcaTO;
import to.ProdutoTO;
public class ProdutoCRTL {
    private ProdutoTO produtoTo;
    private ProdutoTO produtoConsultaTO;
    private ArrayList<ProdutoTO> produtos;
    private ArrayList<String> marcas;
    private ArrayList<String> categorias;
    private MarcaTO marcaTo;
    private CategoriaTO catTo;

    public ArrayList<String> getMarcas() {
        return marcas;
    }

    public void setMarcas(ArrayList<String> marcas) {
        this.marcas = marcas;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public MarcaTO getMarcaTo() {
        return marcaTo;
    }

    public void setMarcaTo(MarcaTO marcaTo) {
        this.marcaTo = marcaTo;
    }

    public CategoriaTO getCatTo() {
        return catTo;
    }

    public void setCatTo(CategoriaTO catTo) {
        this.catTo = catTo;
    }
    

    public ProdutoTO getProdutoTo() {
        return produtoTo;
    }

    public void setProdutoTo(ProdutoTO produtoTo) {
        this.produtoTo = produtoTo;
    }

    public ProdutoTO getProdutoConsultaTO() {
        return produtoConsultaTO;
    }

    public void setProdutoConsultaTO(ProdutoTO produtoConsultaTO) {
        this.produtoConsultaTO = produtoConsultaTO;
    }

    public ArrayList<ProdutoTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoTO> produtos) {
        this.produtos = produtos;
    }
    public ProdutoCRTL() {
        try {
            produtoTo = new ProdutoTO();
            produtoConsultaTO = new ProdutoTO();
            marcaTo = new MarcaTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }
    
    public String incluirProduto() {
        try {
            ProdutoBO produtoBo = new ProdutoBO();
            String ret = produtoBo.incluir(produtoTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Produto incluido com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }
    public void alterarProduto() {
        try {
            ProdutoBO produtoBo = new ProdutoBO();
            String ret = produtoBo.alterar(produtoTo);
             if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }
    public ProdutoTO consultar(String nome) {

        try {
            ProdutoBO produtoBo = new ProdutoBO();
            produtoTo = produtoBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return produtoTo;

    }
    public ProdutoTO consultarID(int id) {

        try {
            ProdutoBO produtoBo = new ProdutoBO();
            produtoTo = produtoBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return produtoTo;

    }
    public MarcaTO consultarNOME(String nome){
        try{
            ProdutoBO produtoBo = new ProdutoBO();
            marcaTo = produtoBo.ConsultarNOME(nome);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return marcaTo;
    }
    public CategoriaTO consultarNOME2(String nome){
        try{
            ProdutoBO produtoBo = new ProdutoBO();
            catTo = produtoBo.ConsultarNOME2(nome);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return catTo;
    }
    public ArrayList<ProdutoTO> consultarTodos() {

        try {

            ProdutoBO produtoBo = new ProdutoBO();
            produtos = produtoBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }
    
    public ArrayList<String> consultarMarcas() {

        try {

            ProdutoBO produtoBo = new ProdutoBO();
            marcas = produtoBo.consultarMarcas();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return marcas;
    }
    public ArrayList<String> consultarCategorias() {

        try {

            ProdutoBO produtoBo = new ProdutoBO();
            categorias = produtoBo.consultarCategorias();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categorias;
    }
    public ArrayList<ProdutoTO> consultarTodosP(String nome) {

        try {

            ProdutoBO produtoBo = new ProdutoBO();
            produtos = produtoBo.consultarTodosP(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }
    public void excluir(int id) {
        try {

            ProdutoBO produtoBo = new ProdutoBO();
           String ret =  produtoBo.excluirID(id);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }
//    public void mascaraValor(JFormattedTextField mask){
//            try{
//            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#,###.##")));
//            }catch(ParseException e){
//                e.printStackTrace();
//            }
//         }
    public void Maiuscula(JTextField maior){
            maior.setDocument(new UpperCaseMODEL2());
        }
    public void somenteNumero(JTextField numero, int tamanho){
            numero.setDocument(new LimiteDigitosMODEL(tamanho));
        }
    public void somenteNumero2(JTextField numero, int tamanho){
            numero.setDocument(new LimiteDigitosMODEL2(tamanho));
        }
    
}
