package to;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class CaixaTO {
    private int codCaixa;
    private String dtfechamento;
    private String hrfechamento;
    private String dtabertura;
    private String hrabertura;
    private String status;
    private BigDecimal valinicial;
    private BigDecimal valfinal;
    private BigDecimal saldoTotal = null;
    private BigDecimal faltando;
    private String observacao="";

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getFaltando() {
        return faltando;
    }

    public void setFaltando(BigDecimal faltando) {
        this.faltando = faltando;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    
    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDtfechamento() {
        return dtfechamento;
    }

    public void setDtfechamento(String dtfechamento) {
        this.dtfechamento = dtfechamento;
    }

    public String getHrfechamento() {
        return hrfechamento;
    }

    public void setHrfechamento(String hrfechamento) {
        this.hrfechamento = hrfechamento;
    }

    public String getDtabertura() {
        return dtabertura;
    }

    public void setDtabertura(String dtabertura) {
        this.dtabertura = dtabertura;
    }

    public String getHrabertura() {
        return hrabertura;
    }

    public void setHrabertura(String hrabertura) {
        this.hrabertura = hrabertura;
    }

    public BigDecimal getValinicial() {
        return valinicial;
    }

    public void setValinicial(BigDecimal valinicial) {
        this.valinicial = valinicial;
    }

    public BigDecimal getValfinal() {
        return valfinal;
    }

    public void setValfinal(BigDecimal valfinal) {
        this.valfinal = valfinal;
    }

    }
