package to;

import java.math.BigDecimal;

public class SaidaCaixaTO {
    private int codSaidaCaixa;
    private int codCaixa;
    private String descricao;
    private String datasaidac;
    private String horasaidac;
    private String tipoMovimentacao;
    private String nomeUsuario;
    private BigDecimal valor;
    private int codUsuario;
    private String nomeCliente = "";

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    

    public int getCodSaidaCaixa() {
        return codSaidaCaixa;
    }

    public void setCodSaidaCaixa(int codSaidaCaixa) {
        this.codSaidaCaixa = codSaidaCaixa;
    }

    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatasaidac() {
        return datasaidac;
    }

    public void setDatasaidac(String datasaidac) {
        this.datasaidac = datasaidac;
    }

    public String getHorasaidac() {
        return horasaidac;
    }

    public void setHorasaidac(String horasaidac) {
        this.horasaidac = horasaidac;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
}
