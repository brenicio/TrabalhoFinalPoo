package to;

import java.math.BigDecimal;

/**
 *
 * @author Brenicio
 */
public class ProdutoDetalheTO {

    private String descricaoprod = "";
    private String cliente = "";
    private BigDecimal valorvenda = new BigDecimal(0.0);
    private BigDecimal totalvenda = new BigDecimal(0.0);
    private int qtdeven = 0;

    public String getDescricaoprod() {
        return descricaoprod;
    }

    public void setDescricaoprod(String descricaoprod) {
        this.descricaoprod = descricaoprod;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(BigDecimal valorvenda) {
        this.valorvenda = valorvenda;
    }

    public BigDecimal getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(BigDecimal totalvenda) {
        this.totalvenda = totalvenda;
    }

    public int getQtdeven() {
        return qtdeven;
    }

    public void setQtdeven(int qtdeven) {
        this.qtdeven = qtdeven;
    }

}
