package model;

import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

public final class TableMODEL extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public TableMODEL(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    public void setremove(int indice) {
        linhas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public void limpaTabela() {
        int size = getRowCount();
        getLinhas().clear();
        // fireTableRowsDeleted(0, size);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }

}
