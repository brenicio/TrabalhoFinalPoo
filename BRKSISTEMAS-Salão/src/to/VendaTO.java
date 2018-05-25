/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.math.BigDecimal;

/**
 *
 * @author Brenicio
 */
public class VendaTO {

    private int codvenda;
    private int codusuario;
    private int codFuncionario;
    private int codCliente;
    private int codformapagamento;
    private String descricaoven;
    private BigDecimal precoven;
    private String dataven;
    private String horaven;
    private BigDecimal totalven;
    private BigDecimal trocoven;
    private String statusven;
    private String observacoes;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getCodvenda() {
        return codvenda;
    }

    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public int getCodformapagamento() {
        return codformapagamento;
    }

    public void setCodformapagamento(int codformapagamento) {
        this.codformapagamento = codformapagamento;
    }

    public String getDescricaoven() {
        return descricaoven;
    }

    public void setDescricaoven(String descricaoven) {
        this.descricaoven = descricaoven;
    }

    public BigDecimal getPrecoven() {
        return precoven;
    }

    public void setPrecoven(BigDecimal precoven) {
        this.precoven = precoven;
    }

    public String getDataven() {
        return dataven;
    }

    public void setDataven(String dataven) {
        this.dataven = dataven;
    }

    public String getHoraven() {
        return horaven;
    }

    public void setHoraven(String horaven) {
        this.horaven = horaven;
    }

    public BigDecimal getTotalven() {
        return totalven;
    }

    public void setTotalven(BigDecimal totalven) {
        this.totalven = totalven;
    }

    public BigDecimal getTrocoven() {
        return trocoven;
    }

    public void setTrocoven(BigDecimal trocoven) {
        this.trocoven = trocoven;
    }

    public String getStatusven() {
        return statusven;
    }

    public void setStatusven(String statusven) {
        this.statusven = statusven;
    }

}
