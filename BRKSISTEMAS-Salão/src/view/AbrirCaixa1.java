/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crtl.CaixaCRTL;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kamila
 */
public class AbrirCaixa1 extends javax.swing.JInternalFrame {

    CaixaCRTL crtl = new CaixaCRTL();
    Date data = new Date();
    Calendar hora;
    BigDecimal valorInicial;
    Caixa1 caixa = new Caixa1();

    public AbrirCaixa1(Caixa1 caixa) {
        initComponents();
        this.caixa = caixa;
        formataPreco(txtValorInicial);
        btnAbrir.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtValorInicial = new javax.swing.JFormattedTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Abrir Caixa");

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/1433364306_f-check_256.png"))); // NOI18N
        btnAbrir.setText("Abrir o Caixa");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor Inicial do Caixa:");

        txtValorInicial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtValorInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtValorInicialMouseExited(evt);
            }
        });
        txtValorInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorInicialActionPerformed(evt);
            }
        });
        txtValorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorInicialFocusLost(evt);
            }
        });
        txtValorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorInicialKeyTyped(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Abrir caixa grande.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAbrir)
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        crtl.getCaixaTo().setValinicial(valorInicial);
        crtl.getCaixaTo().setDtabertura(getDate());
        crtl.getCaixaTo().setHrabertura(getTime());
        crtl.getCaixaTo().setStatus("Aberto");
        crtl.incluirCaixa();
        LimparCampos();
        caixa.Atualizar();
        btnAbrir.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void txtValorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorInicialFocusLost
        if (!"".equals(txtValorInicial.getText())) {
            String sv = txtValorInicial.getText();
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            valorInicial = valor;
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            crtl.somenteNumero2(txtValorInicial, valorFormatado.length());
            txtValorInicial.setText(valorFormatado);
        }
    }//GEN-LAST:event_txtValorInicialFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorInicialKeyTyped

    }//GEN-LAST:event_txtValorInicialKeyTyped

    private void txtValorInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorInicialActionPerformed

    }//GEN-LAST:event_txtValorInicialActionPerformed

    private void txtValorInicialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorInicialMouseExited
        if (!"".equals(txtValorInicial.getText())) {
            String sv = txtValorInicial.getText();
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            valorInicial = valor;
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            crtl.somenteNumero2(txtValorInicial, valorFormatado.length());
            txtValorInicial.setText(valorFormatado);
        }
    }//GEN-LAST:event_txtValorInicialMouseExited

    private void txtValorInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorInicialKeyPressed
        if ("".equals(txtValorInicial.getText())) {
            crtl.somenteNumero2(txtValorInicial, 10);
        }
    }//GEN-LAST:event_txtValorInicialKeyPressed
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

    private void LimparCampos() {
        txtValorInicial.setText("");
    }

    private void formataPreco(JTextField txt) {
        crtl.somenteNumero(txt, 40);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JFormattedTextField txtValorInicial;
    // End of variables declaration//GEN-END:variables
}
