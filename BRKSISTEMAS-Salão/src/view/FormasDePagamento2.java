                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crtl.CaixaCRTL;
import crtl.VendaCRTL;
import dao.CaixaDAO;
import dao.VendaDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import to.CaixaTO;
import to.EntradaCaixaTO;
import to.PagamentoTO;
import to.ProdutoTO;
import to.VendaTO;

/**
 *
 * @author suporte
 */
public class FormasDePagamento2 extends javax.swing.JInternalFrame {

    int codFp = 0;
    ArrayList<ProdutoTO> produto = new ArrayList();
    BigDecimal vendaTotal;
    String descricaoven;
    ArrayList codProdutos = new ArrayList();
    ArrayList quantidade = new ArrayList();
    VendaCRTL crtl = new VendaCRTL();
    ArrayList prod = new ArrayList();
    ArrayList quant = new ArrayList();
    VendasEfetuadass vendas = new VendasEfetuadass();
    VendaDAO vendaDao = new VendaDAO();
    int codcli = 0;

    /**
     * Creates new form FormasDePagamento1
     *
     * @param produtos
     * @param quantidade
     * @param vendaTotall
     * @param descricaovenn
     * @param parent
     */
    public FormasDePagamento2(ArrayList produtos, ArrayList quantidade, BigDecimal vendaTotall, String descricaovenn, VendasEfetuadass parent, int codcli) {
        this.vendas = parent;
        produto = produtos;
        vendaTotal = vendaTotall;
        descricaoven = descricaovenn;
        prod = produtos;
        quant = quantidade;
        BuscarItensVenda();
        initComponents();
        txtFp.setEditable(false);
        this.codcli = codcli;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDinheiro = new javax.swing.JTextField();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCartaoCredito = new javax.swing.JTextField();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCartaoDebito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtFp = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formas de Pagamento");

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Dinheiro");

        txtDinheiro.setBackground(new java.awt.Color(240, 240, 240));
        txtDinheiro.setText("R$");

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane4.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtDinheiro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cartão de Crédito");

        txtCartaoCredito.setBackground(new java.awt.Color(240, 240, 240));
        txtCartaoCredito.setText("R$");

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane5.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtCartaoCredito, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cartão de Débito");

        txtCartaoDebito.setBackground(new java.awt.Color(240, 240, 240));
        txtCartaoDebito.setText("R$");

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane8.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(txtCartaoDebito, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4)
            .addComponent(jLayeredPane5)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane3.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Observações:");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/1433364306_f-check_256.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total à Pagar:");

        txtTotal.setBackground(new java.awt.Color(240, 240, 240));
        txtTotal.setText("R$");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/1433364385_delete.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Selecionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtFp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtFp.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtFp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFp, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        setBounds(450, 130, 453, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ConsultarFormaPag formapag = new ConsultarFormaPag(this, true, "vendaProd");
        formapag.setModal(true);
        formapag.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (codFp == 0) {
            JOptionPane.showMessageDialog(null, "Forma de Pagamento não foi selecionada! Selecione uma para concluir a venda.");
        } else {
            try {
                realizarVenda();
            } catch (Exception ex) {
                Logger.getLogger(FormasDePagamento2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void realizarVenda() throws Exception {
        ProdutoTO produto = new ProdutoTO();
        BuscarItensVenda();
        int e = 0;
        int quantidadeProd = 0;
        int quantidadeVenda = 0;
        int total = 0;
        String resultado = "";
        //    JOptionPane.showMessageDialog(null, "Entrando em prod size");
        while (e < prod.size()) {
            try {
                produto = vendaDao.ConsultarItemID(Integer.parseInt(prod.get(e).toString()));
                quantidadeProd = produto.getQtdeProd();
                // JOptionPane.showMessageDialog(null, quantidadeProd);
                quantidadeVenda = Integer.parseInt(quant.get(e).toString());
                total = quantidadeProd - quantidadeVenda;

                if (total < 0) {
                    JOptionPane.showMessageDialog(null, "Não tem estoque suficiente do produto ' " + produto.getDescrProd() + " ' para realizar essa venda!");
                    resultado = "Falha";
                }

            } catch (Exception ex) {
                Logger.getLogger(FormasDePagamento2.class.getName()).log(Level.SEVERE, null, ex);
            }
            e++;
        }

        //JOptionPane.showMessageDialog(null, "saindo de prod size");
        if (resultado.equals("Falha")) {
            JOptionPane.showMessageDialog(null, "Não foi possivel concluir a venda!");
        } else {
            // JOptionPane.showMessageDialog(null, "Entrando em consultar o caixa!");
            CaixaDAO caixaDao = new CaixaDAO();
            CaixaCRTL caixa = new CaixaCRTL();
            CaixaTO caixaTo = new CaixaTO();
            ArrayList<ProdutoTO> produtos = new ArrayList();

            VendaTO vendaTo = new VendaTO();

            caixaTo = caixa.consultar("Aberto");
            EntradaCaixaTO entrada = new EntradaCaixaTO();

           // JOptionPane.showMessageDialog(null, "saindo do consultar o caixa!");
           // JOptionPane.showMessageDialog(null, "Entrando em consultar id venda!");
          //  JOptionPane.showMessageDialog(null, "Saindo de consultar id venda!");
            BuscarItensVenda();
            int i = 0;

            // JOptionPane.showMessageDialog(null, "Entrando em venda!");
            crtl.getVendaTo().setCodformapagamento(codFp);
            crtl.getVendaTo().setCodusuario(8);
            crtl.getVendaTo().setDataven(getDate());
            crtl.getVendaTo().setDescricaoven(descricaoven);
            crtl.getVendaTo().setHoraven(getTime());
            crtl.getVendaTo().setObservacoes(txtObs.getText());
            crtl.getVendaTo().setTotalven(vendaTotal);
            crtl.getVendaTo().setCodCliente(codcli);
            crtl.getVendaTo().setTipo("P");
            crtl.incluirVenda();
            //  JOptionPane.showMessageDialog(null, "Saindo de venda!");
            try {
                vendaTo = vendaDao.ConsultarID();
            } catch (Exception ex) {
                Logger.getLogger(FormasDePagamento2.class.getName()).log(Level.SEVERE, null, ex);
            }

           // JOptionPane.showMessageDialog(null, "Entrando itens venda!");
            while (i < prod.size()) {
                crtl.getItemTo().setCodproduto(Integer.parseInt(prod.get(i).toString()));
                crtl.getItemTo().setQtde(Integer.parseInt(quant.get(i).toString()));
                //JOptionPane.showMessageDialog(null, vendaTo.getCodvenda());
                crtl.getItemTo().setCodvenda(vendaTo.getCodvenda());
//                System.out.println(prod.get(i));
//                System.out.println(quantidade.get(i));
                crtl.incluirItemVendaProd();
                i++;
            }

          //  JOptionPane.showMessageDialog(null, "saindo de itens venda!");
            //JOptionPane.showMessageDialog(null, "Entrando subtração de quantidade");
            int e1 = 0;
            while (e1 < prod.size()) {
                try {
                    produto = vendaDao.ConsultarItemID(Integer.parseInt(prod.get(e1).toString()));
                    produto.setQtdeProd(produto.getQtdeProd() - (Integer.parseInt(quant.get(e1).toString())));
                    vendaDao.alterarQuantidadeProdutos(produto);
                } catch (Exception ex) {
                    Logger.getLogger(FormasDePagamento2.class.getName()).log(Level.SEVERE, null, ex);
                }
                e1++;
            }
           // JOptionPane.showMessageDialog(null, "Saindo de subtração de quantidade");

           // JOptionPane.showMessageDialog(null, "Entrando adicionar dinheiro no caixa!");
            entrada.setCodCaixa(caixaTo.getCodCaixa());
            entrada.setCodUsuario(2);
            entrada.setCodVenda(vendaTo.getCodvenda());
            entrada.setDataEntracaC(getDate());
            entrada.setHora(getTime());
            entrada.setDescricao(descricaoven);
            entrada.setTipoMovimentacao("Venda");
            entrada.setValor(vendaTotal);

            caixaDao.AdicionarDinheiro(entrada);

           // JOptionPane.showMessageDialog(null, "Saindo de adicionar dinheiro no caixa!");
            //AVISA SE TEM ALGUM PRODUTO DEPOIS DA VENDA COM QUANTIDADE = 0
            // JOptionPane.showMessageDialog(null, "Entrando em verificar produto = 0");
            int t = 0;
            BuscarItensVenda();
            int quantidadeProdV;
            int quantidadeVendaV;
            while (t < prod.size()) {
                try {
                    produto = vendaDao.ConsultarItemID(Integer.parseInt(prod.get(t).toString()));
                    quantidadeProdV = produto.getQtdeProd();
                    // JOptionPane.showMessageDialog(null, quantidadeProd);

                    if (quantidadeProdV == 0) {
                        JOptionPane.showMessageDialog(null, "Atenção! O Produto ' " + produto.getDescrProd() + " ' está em falta no estoque.");

                    }

                } catch (Exception ex) {
                    Logger.getLogger(FormasDePagamento2.class.getName()).log(Level.SEVERE, null, ex);
                }
                t++;
            }
            //  JOptionPane.showMessageDialog(null, "Saindo de verifica produto = 0");

            vendas.Cancelar();
            vendas.toFront();
            this.dispose();
        }
    }

    public void recebendo(PagamentoTO pagto) {
        NumberFormat nf1 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado1 = nf1.format(vendaTotal);
        txtTotal.setText(valorFormatado1);

        codFp = pagto.getCodformapagamento();

        String desc = pagto.getDescpagamento();
        String tipo = pagto.getTipopagamento();
        if (desc.equals("DINHEIRO")) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(vendaTotal);
            txtDinheiro.setText(valorFormatado);

            txtCartaoCredito.setText("");
            txtCartaoDebito.setText("");
        } else if (desc.equals("CARTÃO") && tipo.equals("A VISTA")) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(vendaTotal);
            txtCartaoDebito.setText(valorFormatado);

            txtDinheiro.setText("");
            txtCartaoCredito.setText("");
        } else {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(vendaTotal);
            txtCartaoCredito.setText(valorFormatado);

            txtCartaoDebito.setText("");
            txtDinheiro.setText("");
        }
        String txt = pagto.getDescpagamento() + " " + pagto.getTipopagamento() + "-PARCELAS: " + pagto.getQtdparcela();
        txtFp.setText(txt);
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void BuscarItensVenda() {
        int i = 0;

        while (i < prod.size()) {
            codProdutos.add(prod.get(i));
            quantidade.add(quant.get(i));
//           System.out.println(codProdutos.get(i));
//           System.out.println(quantidade.get(i));
            i++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCartaoCredito;
    private javax.swing.JTextField txtCartaoDebito;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextField txtFp;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
