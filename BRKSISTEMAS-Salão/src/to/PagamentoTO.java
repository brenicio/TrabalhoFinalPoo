package to;
public class PagamentoTO {
   String descpagamento;
   String tipopagamento;
   int qtdparcela=0;
   int codformapagamento=0;

    public int getCodformapagamento() {
        return codformapagamento;
    }

    public void setCodformapagamento(int codformapagamento) {
        this.codformapagamento = codformapagamento;
    }

    public String getDescpagamento() {
        return descpagamento;
    }

    public void setDescpagamento(String descpagamento) {
        this.descpagamento = descpagamento;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public int getQtdparcela() {
        return qtdparcela;
    }

    public void setQtdparcela(int qtdparcela) {
        this.qtdparcela = qtdparcela;
    }
}
