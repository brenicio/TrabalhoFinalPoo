package view;

import crtl.CategoriaCRTL;
import java.util.ArrayList;
import model.TableMODEL;
import to.CategoriaTO;

public class ConsultarCategoria extends javax.swing.JInternalFrame {

    ManterCategoria enviaDados = new ManterCategoria();
    CategoriaCRTL crtl = new CategoriaCRTL();

    public ConsultarCategoria() {
        initComponents();
        preencherTabela();
        MenuPrincipal.getPainel().add(enviaDados);
        enviaDados.setVisible(true);
        // enviaDados.toBack();

//        MenuPrincipal.getPainel().add(enviaDados);
//        enviaDados.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        cbOpcao = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Consultar Categoria");

        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Descrição", "Codigo"}));

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {},
                    {},
                    {},
                    {},
                    {}
                },
                new String[]{}
        ));
        jScrollPane2.setViewportView(jTableCategoria);

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
                                                .addGap(45, 45, 45)
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
    }// </editor-fold>                        

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = jTableCategoria.getSelectedRow();
        crtl.getCategoriaTo().setNomeCategoria(jTableCategoria.getValueAt(linha, 1).toString());
        crtl.getCategoriaTo().setCodCategoria(Integer.parseInt(jTableCategoria.getModel().getValueAt(linha, 0).toString()));

        enviaDados.recebendo(crtl.getCategoriaTo());
        this.dispose();
        enviaDados.setVisible(true);

    }

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {

    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {
        if (cbOpcao.getSelectedIndex() == 0) {
            preencherTabela2();
        } else {
            preencherTabela3();
        }

        if (txtPesquisa.getText().equalsIgnoreCase("")) {
            preencherTabela();
        }

    }

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {
        if (cbOpcao.getSelectedIndex() == 0) {
            Maiuscula();
        } else {
            somenteNumero();
        }
    }

    public void preencherTabela() {
        CategoriaCRTL marcCrtl = new CategoriaCRTL();
        ArrayList<CategoriaTO> dados = new ArrayList();
        ArrayList dados1 = new ArrayList();
        dados = marcCrtl.consultarTodos();
        int i = 0;
        while (i < dados.size()) {
            dados1.add(new Object[]{dados.get(i).getCodCategoria(), dados.get(i).getNomeCategoria()});
            i++;

        }
        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableCategoria.setModel(modelo);
        jTableCategoria.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableCategoria.getTableHeader().setReorderingAllowed(false);
        jTableCategoria.setAutoResizeMode(jTableCategoria.AUTO_RESIZE_OFF);
    }

    public void preencherTabela2() {
        CategoriaTO marcTo = new CategoriaTO();
        CategoriaCRTL marcCrtl = new CategoriaCRTL();
        ArrayList<CategoriaTO> dados = new ArrayList();
        ArrayList dados1 = new ArrayList();

        dados = marcCrtl.consultarTodosM(txtPesquisa.getText());

        int i = 0;
        while (i < dados.size()) {
            dados1.add(new Object[]{dados.get(i).getCodCategoria(), dados.get(i).getNomeCategoria()});
            i++;

        }
        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableCategoria.setModel(modelo);
        jTableCategoria.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableCategoria.getTableHeader().setReorderingAllowed(false);
        jTableCategoria.setAutoResizeMode(jTableCategoria.AUTO_RESIZE_OFF);
    }

    public void preencherTabela3() {

        CategoriaTO marcTo = new CategoriaTO();
        CategoriaCRTL marcCrtl = new CategoriaCRTL();
        ArrayList dados1 = new ArrayList();

        marcTo = marcCrtl.consultarID(Integer.parseInt(txtPesquisa.getText()));

        dados1.add(new Object[]{marcTo.getCodCategoria(), marcTo.getNomeCategoria()});

        String[] Colunas = new String[]{"Codigo", "Nome"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableCategoria.setModel(modelo);
        jTableCategoria.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableCategoria.getTableHeader().setReorderingAllowed(false);
        jTableCategoria.setAutoResizeMode(jTableCategoria.AUTO_RESIZE_OFF);

    }

    public void Maiuscula() {
        crtl.maiuscula(txtPesquisa);
    }

    public void somenteNumero() {
        crtl.somenteNumero(txtPesquisa, 4);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cbOpcao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JFormattedTextField txtPesquisa;
    // End of variables declaration                   
}
