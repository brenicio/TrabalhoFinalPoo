package to;

import java.math.BigDecimal;

public class ProdutoTO {

    private int codMarca = 0;
    private int codBarra = 0;
    private int codProd = 0;
    private int codCategoria = 0;
    private String categoria;
    private String nomeMarca;
    private String descrProd;
    private String cmFoto;
    //  private int qtdeEstoque=0;
    private double valorCusto = 0;
    private double valorVenda = 0;
    private int qtdeProd = 0;
    private double lucroProd = 0;
    private BigDecimal valortotal;
    private int quantidadetotal;

    public ProdutoTO() {
        this.descrProd = "";
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public int getQuantidadetotal() {
        return quantidadetotal;
    }

    public void setQuantidadetotal(int quantidadetotal) {
        this.quantidadetotal = quantidadetotal;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescrProd() {
        return descrProd;
    }

    public void setDescrProd(String descrProd) {
        this.descrProd = descrProd;
    }

    public String getCmFoto() {
        return cmFoto;
    }

    public void setCmFoto(String cmFoto) {
        this.cmFoto = cmFoto;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQtdeProd() {
        return qtdeProd;
    }

    public void setQtdeProd(int qtdeProd) {
        this.qtdeProd = qtdeProd;
    }

    public double getLucroProd() {
        return lucroProd;
    }

    public void setLucroProd(double lucroProd) {
        this.lucroProd = lucroProd;
    }

}
