package view;

import crtl.MarcaCRTL;
import java.util.ArrayList;
import model.TableMODEL;
import to.MarcaTO;

public class ConsultarMarca extends javax.swing.JInternalFrame {

    ManterMarca enviaDados = new ManterMarca();
    MarcaCRTL crtl = new MarcaCRTL();

    public ConsultarMarca() {
        initComponents();
        preencherTabela();
        MenuPrincipal.getPainel().add(enviaDados);
        enviaDados.setVisible(true);
       // enviaDados.toBack();

//        MenuPrincipal.getPainel().add(enviaDados);
//        enviaDados.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOpcao = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMarca = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Consultar Marca");

        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descrição", "Codigo" }));

        jTableMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableMarca);

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/ok 24x24.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/excluir 24x24.png"))); // NOI18N
        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/visualizar.png"))); // NOI18N
        btnPesquisa.setText("Pesquisar");

        txtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMouseClicked(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisa)
                    .addComponent(btnSelecionar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setBounds(450, 130, 446, 320);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha = jTableMarca.getSelectedRow();
        crtl.getMarcaTo().setNomeMarca(jTableMarca.getValueAt(linha, 1).toString());
        crtl.getMarcaTo().setCodMarca(Integer.parseInt(jTableMarca.getModel().getValueAt(linha, 0).toString()));

        enviaDados.recebendo(crtl.getMarcaTo());
        this.dispose();
        enviaDados.setVisible(true);

    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed

    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        if(cbOpcao.getSelectedIndex()==0){
           preencherTabela2(); 
        }else{
            preencherTabela3();
        }
        
        if (txtPesquisa.getText().equalsIgnoreCase("")) {
            preencherTabela();
        }
        
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        if(cbOpcao.getSelectedIndex()==0){
            Maiuscula();
        }else{
            somenteNumero();
        }
    }//GEN-LAST:event_txtPesquisaMouseClicked
    public void preencherTabela() {
        MarcaCRTL marcCrtl = new MarcaCRTL();
        ArrayList<MarcaTO> dados = new ArrayList();
        ArrayList dados1 = new ArrayList();
        dados = marcCrtl.consultarTodos();
        int i = 0;
        while (i < dados.size()) {
            dados1.add(new Object[]{dados.get(i).getCodMarca(), dados.get(i).getNomeMarca()});
            i++;

        }
        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableMarca.setModel(modelo);
        jTableMarca.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableMarca.getTableHeader().setReorderingAllowed(false);
        jTableMarca.setAutoResizeMode(jTableMarca.AUTO_RESIZE_OFF);
    }

    public void preencherTabela2() {
        MarcaTO marcTo = new MarcaTO();
        MarcaCRTL marcCrtl = new MarcaCRTL();        
        ArrayList<MarcaTO> dados = new ArrayList();
        ArrayList dados1 = new ArrayList();

        dados = marcCrtl.consultarTodosM(txtPesquisa.getText());

        int i = 0;
        while (i < dados.size()) {
            dados1.add(new Object[]{dados.get(i).getCodMarca(), dados.get(i).getNomeMarca()});
            i++;

        }
        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableMarca.setModel(modelo);
        jTableMarca.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableMarca.getTableHeader().setReorderingAllowed(false);
        jTableMarca.setAutoResizeMode(jTableMarca.AUTO_RESIZE_OFF);
    }

    public void preencherTabela3() {

        MarcaTO marcTo = new MarcaTO();
        MarcaCRTL marcCrtl = new MarcaCRTL();
        ArrayList dados1 = new ArrayList();

        marcTo = marcCrtl.consultarID(Integer.parseInt(txtPesquisa.getText()));

        dados1.add(new Object[]{marcTo.getCodMarca(), marcTo.getNomeMarca()});

        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableMarca.setModel(modelo);
        jTableMarca.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableMarca.getTableHeader().setReorderingAllowed(false);
        jTableMarca.setAutoResizeMode(jTableMarca.AUTO_RESIZE_OFF);

    }

   public void Maiuscula(){
       crtl.Maiuscula(txtPesquisa);
   }
   public void somenteNumero(){
       crtl.somenteNumero(txtPesquisa, 4);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cbOpcao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMarca;
    private javax.swing.JFormattedTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
