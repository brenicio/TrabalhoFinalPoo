package crtl;

import bo.VendaBO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.LimiteDigitosMODEL2;
import to.ItemVendaTO;
import to.VendaTO;

public class VendaCRTL {

    private VendaTO vendaTo;
    private ItemVendaTO itemTo;
    private ArrayList<VendaTO> vendas;
    private ArrayList<ItemVendaTO> itens;

    public VendaCRTL() {
        vendaTo = new VendaTO();
        itemTo = new ItemVendaTO();
    }

    public VendaTO getVendaTo() {
        return vendaTo;
    }

    public void setVendaTo(VendaTO vendaTo) {
        this.vendaTo = vendaTo;
    }

    public ItemVendaTO getItemTo() {
        return itemTo;
    }

    public void setItemTo(ItemVendaTO itemTo) {
        this.itemTo = itemTo;
    }

 
    public ArrayList<VendaTO> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<VendaTO> vendas) {
        this.vendas = vendas;
    }

    public ArrayList<ItemVendaTO> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVendaTO> itens) {
        this.itens = itens;
    }

    public String incluirVenda() {
        try {
            VendaBO vendaBo = new VendaBO();
            String ret = vendaBo.incluirVenda(vendaTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Venda incluida com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "";
    }

    public String incluirItemVenda() {
        try {
            VendaBO vendaBo = new VendaBO();
            //   JOptionPane.showMessageDialog(null, itemTo.getCodFuncionario() +" "+itemTo.getCodvenda()+" "+itemTo.getCodServico()+" "+itemTo.getPrecoUnit()+"");
            String ret = vendaBo.incluirItemVenda(itemTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                // JOptionPane.showMessageDialog(null, "Item incluido com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }

    public String incluirItemVendaProd() {
        try {
            VendaBO vendaBo = new VendaBO();
            //   JOptionPane.showMessageDialog(null, itemTo.getCodFuncionario() +" "+itemTo.getCodvenda()+" "+itemTo.getCodServico()+" "+itemTo.getPrecoUnit()+"");
            String ret = vendaBo.incluirItemVendaProd(itemTo);
            if (!"".equals(ret)) {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                // JOptionPane.showMessageDialog(null, "Item incluido com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }
        return "";
    }

    public void somenteNumero(JTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }

    public void somenteNumero2(JTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL2(tamanho));
    }

}
