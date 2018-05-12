

package to;

import java.math.BigDecimal;

/**
 *
 * @author Brenicio
 */
public class ServicoDetalheTO {
    private String descricaoserv = "";
    private String cliente = "";
    private String nomefunc = "";
    private BigDecimal valorvenda = new BigDecimal(0.0);

    public String getDescricaoserv() {
        return descricaoserv;
    }

    public void setDescricaoserv(String descricaoserv) {
        this.descricaoserv = descricaoserv;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNomefunc() {
        return nomefunc;
    }

    public void setNomefunc(String nomefunc) {
        this.nomefunc = nomefunc;
    }

    public BigDecimal getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(BigDecimal valorvenda) {
        this.valorvenda = valorvenda;
    }

    public BigDecimal getTotalven() {
        return totalven;
    }

    public void setTotalven(BigDecimal totalven) {
        this.totalven = totalven;
    }
    private BigDecimal totalven = new BigDecimal(0.0);
    
}
