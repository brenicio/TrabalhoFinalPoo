/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crtl.PessoasCRTL;
import model.TableMODEL;
import java.util.ArrayList;
import java.util.Iterator;
import model.Mascara;
import to.FuncionarioTO;

/**
 *
 * @author Brenicio
 */
public class ConsultarFuncionario1 extends javax.swing.JInternalFrame {

    ManterFuncionario funcionarios = new ManterFuncionario();
    ManterUsuario Usuario = new ManterUsuario();
    FuncionarioTO funcTo = new FuncionarioTO();
    PessoasCRTL funcCrtl = new PessoasCRTL();
    String telaSelecionada;
    Iterator ito;
    public static VendasEfetuadasServico venda = new VendasEfetuadasServico();

    /* Creates new form ConsultarFuncionario1
     */
    public ConsultarFuncionario1(String tela) {
        telaSelecionada = tela;
        initComponents();
        preencherTabela();

        if (telaSelecionada.equalsIgnoreCase("funcionario")) {
            MenuPrincipal.getPainel().add(funcionarios);
            funcionarios.setVisible(true);
        }
    }

    public ConsultarFuncionario1(VendasEfetuadasServico parent, String tela) {
        this.venda = parent;
        telaSelecionada = tela;
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cbOpcao = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JFormattedTextField();

        setTitle("Consultar Funcionario");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/ok 24x24.png"))); // NOI18N
        jButton4.setText("Selecionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/excluir 24x24.png"))); // NOI18N
        jButton5.setText("cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome Funcionário", "Matricula" }));

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableFuncionarios);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/visualizar.png"))); // NOI18N
        jButton1.setText("Pesquisar");

        txtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMouseClicked(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(450, 130, 1076, 552);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int linha = jTableFuncionarios.getSelectedRow();
        funcTo.setNome(jTableFuncionarios.getValueAt(linha, 1).toString());
        funcTo.setMatricula(Integer.parseInt(jTableFuncionarios.getModel().getValueAt(linha, 0).toString()));
        funcTo.setCargo(jTableFuncionarios.getModel().getValueAt(linha, 2).toString());
        funcTo.setRg(jTableFuncionarios.getModel().getValueAt(linha, 3).toString());
        funcTo.setCpf(jTableFuncionarios.getModel().getValueAt(linha, 4).toString());
        funcTo.setCelular(jTableFuncionarios.getModel().getValueAt(linha, 5).toString());
        funcTo.setTelefone(jTableFuncionarios.getModel().getValueAt(linha, 6).toString());
        funcTo.setEmail(jTableFuncionarios.getModel().getValueAt(linha, 7).toString());
        funcTo.setEndereco(jTableFuncionarios.getModel().getValueAt(linha, 8).toString());
        funcTo.setCidade(jTableFuncionarios.getModel().getValueAt(linha, 9).toString());
        funcTo.setCep(jTableFuncionarios.getModel().getValueAt(linha, 10).toString());
        funcTo.setSexo(jTableFuncionarios.getModel().getValueAt(linha, 11).toString());
        funcTo.setTelefoneRecado(jTableFuncionarios.getModel().getValueAt(linha, 12).toString());
        funcTo.setCts(jTableFuncionarios.getModel().getValueAt(linha, 13).toString());
        funcTo.setSerie(jTableFuncionarios.getModel().getValueAt(linha, 14).toString());
        funcTo.setDatanasc(jTableFuncionarios.getModel().getValueAt(linha, 15).toString());
        funcTo.setUf(jTableFuncionarios.getModel().getValueAt(linha, 16).toString());
        funcTo.setSetor(jTableFuncionarios.getModel().getValueAt(linha, 17).toString());

        if (telaSelecionada.equalsIgnoreCase("usuario")) {
            Usuario.recebendo(funcTo);
            this.dispose();
            Usuario.setVisible(true);
        } else if (telaSelecionada.equals("venda")) {
            venda.RecebendoDadosFuncionario(funcTo);
            this.dispose();
            venda.setVisible(true);
        } else {
            funcionarios.recebendo(funcTo);
            this.dispose();
            funcionarios.setVisible(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked

        int linha = jTableFuncionarios.getSelectedRow();
        if (cbOpcao.getSelectedIndex() == 0) {
            txtPesquisa.setText(jTableFuncionarios.getValueAt(linha, 1).toString());
        } else {
            txtPesquisa.setText(jTableFuncionarios.getValueAt(linha, 0).toString());
        }

    }//GEN-LAST:event_jTableFuncionariosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        if (cbOpcao.getSelectedIndex() == 0) {
            Maiuscula();
        } else {
            somenteNumeros();
        }
    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        preencherTabela2();
        if (txtPesquisa.getText().equalsIgnoreCase("")) {
            preencherTabela();
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed
    private void preencherTabela() {
        ArrayList<FuncionarioTO> dados = new ArrayList();
        ArrayList dados1 = new ArrayList();

        ito = funcCrtl.consultarTodos("funcionario").iterator();
        while (ito.hasNext()) {
            dados.add((FuncionarioTO) ito.next());
        }

        for (int i = 0; i < dados.size(); i++) {
            dados1.add(new Object[]{dados.get(i).getMatricula(), dados.get(i).getNome(), dados.get(i).getCargo(), dados.get(i).getRg(), dados.get(i).getCpf(), dados.get(i).getCelular(), dados.get(i).getTelefone(), dados.get(i).getEmail(), dados.get(i).getEndereco(), dados.get(i).getCidade(), dados.get(i).getCep(), dados.get(i).getSexo(), dados.get(i).getTelefoneRecado(), dados.get(i).getCts(), dados.get(i).getSerie(), dados.get(i).getDatanasc(), dados.get(i).getUf(), dados.get(i).getSetor()});
        }

        String[] Colunas = new String[]{"Matricula", "Nome", "Cargo", "RG", "CPF", "Celular", "Telefone", "Email", "Endereço",
            "Cidade", "Cep", "Sexo", "TelefoneRecado", "CTPS", "Serie", "DataNasc", "UF", "Setor"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableFuncionarios.setModel(modelo);

        jTableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(0).setMaxWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(1).setMaxWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(0).setMinWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(1).setMinWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(2).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(2).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setMinWidth(200);

        jTableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTableFuncionarios.setAutoResizeMode(jTableFuncionarios.AUTO_RESIZE_OFF);
    }

    public void preencherTabela2() {
        funcTo.setMatricula(Integer.parseInt(txtPesquisa.getText()));
        if (cbOpcao.getSelectedIndex() == 0) {
            funcTo = (FuncionarioTO) funcCrtl.consultar(funcTo);
        } else {
            funcTo = (FuncionarioTO) funcCrtl.consultar(Integer.parseInt(txtPesquisa.getText()), "funcionario");
        }
        ArrayList dados1 = new ArrayList();

        dados1.add(new Object[]{funcTo.getMatricula(), funcTo.getNome(), funcTo.getCargo(), funcTo.getRg(), funcTo.getCpf(), funcTo.getCelular(), funcTo.getTelefone(), funcTo.getEmail(), funcTo.getEndereco(), funcTo.getCidade(),
            funcTo.getCep(), funcTo.getSexo(), funcTo.getTelefoneRecado(), funcTo.getCts(), funcTo.getSerie(), funcTo.getDatanasc(), funcTo.getUf()});

        String[] Colunas = new String[]{"Matricula", "Nome", "Cargo", "RG", "CPF", "Celular", "Telefone", "Email", "Endereço",
            "Cidade", "Cep", "Sexo", "TelefoneRecado", "CTPS", "Serie", "DataNasc", "UF"};

        TableMODEL modelo = new TableMODEL(dados1, Colunas);
        jTableFuncionarios.setModel(modelo);

        jTableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(0).setMaxWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(1).setMaxWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(0).setMinWidth(80);
        jTableFuncionarios.getColumnModel().getColumn(1).setMinWidth(600);
        jTableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(2).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(2).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(3).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(4).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(5).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(7).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(8).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(9).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(10).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(11).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(12).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(13).setMinWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setMaxWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(14).setMinWidth(200);

        jTableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTableFuncionarios.setAutoResizeMode(jTableFuncionarios.AUTO_RESIZE_OFF);

    }

    public void Maiuscula() {
        Mascara.Maiuscula(txtPesquisa);
    }

    public void somenteNumeros() {
        Mascara.somenteNumero(txtPesquisa, 4);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbOpcao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JFormattedTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
