package to;

import java.math.BigDecimal;

public class EntradaCaixaTO {
   private int codEntradaCaixa;
   private int codCaixa;
   private int codVenda;
   private String descricao;
   private String dataEntracaC;
   private String hora;
   private String nomeUsuario;
   private BigDecimal valor=null;
   private int codUsuario;
   private String tipoMovimentacao;
   private BigDecimal totalVenda= new BigDecimal(0.0);
   private String nomeCliente;
   private int codcliente;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

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

    public int getCodEntradaCaixa() {
        return codEntradaCaixa;
    }

    public void setCodEntradaCaixa(int codEntradaCaixa) {
        this.codEntradaCaixa = codEntradaCaixa;
    }

    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataEntracaC() {
        return dataEntracaC;
    }

    public void setDataEntracaC(String dataEntracaC) {
        this.dataEntracaC = dataEntracaC;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }
}
