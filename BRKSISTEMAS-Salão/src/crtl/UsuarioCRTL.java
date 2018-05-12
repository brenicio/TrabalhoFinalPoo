/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtl;

import bo.UsuarioBO;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.LimiteDigitosMODEL;
import model.UpperCaseMODEL;
import to.UsuarioTO;

public class UsuarioCRTL {

    private UsuarioTO usuarioTo;
    private UsuarioTO usuarioConsultaTO;
    private ArrayList<UsuarioTO> usuarios;

    public UsuarioTO getUsuarioTo() {
        return usuarioTo;
    }

    public void setUsuarioTo(UsuarioTO usuarioTo) {
        this.usuarioTo = usuarioTo;
    }

    public UsuarioTO getUsuarioConsultaTO() {
        return usuarioConsultaTO;
    }

    public void setUsuarioConsultaTO(UsuarioTO usuarioConsultaTO) {
        this.usuarioConsultaTO = usuarioConsultaTO;
    }

    public ArrayList<UsuarioTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioTO> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioCRTL() {
        try {
            usuarioTo = new UsuarioTO();
            usuarioConsultaTO = new UsuarioTO();
        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public String incluirUsuario() {
        try {
            UsuarioBO usuarioBo = new UsuarioBO();
            String ret = usuarioBo.incluir(usuarioTo);
            if (ret != "") {
                JOptionPane.showMessageDialog(null, ret);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário incluido com sucesso!");
            }
            return "";
        } catch (Exception ex) {
            System.out.println("Erro ao incluir!!");
        }

        return "";
    }

    public void alterarUsuario() {
        try {
            UsuarioBO usuarioBo = new UsuarioBO();
            String ret = usuarioBo.alterar(usuarioTo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");

        }

    }

    public UsuarioTO consultar(String nome) {

        try {
            UsuarioBO usuarioBo = new UsuarioBO();
            usuarioTo = usuarioBo.Consultar(nome);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return usuarioTo;

    }

    public UsuarioTO consultarID(int id) {

        try {
            UsuarioBO usuarioBo = new UsuarioBO();
            usuarioTo = usuarioBo.ConsultarID(id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return usuarioTo;

    }

    public UsuarioTO consultarIDF(int id) {
        try {
            UsuarioBO usuarioBo = new UsuarioBO();
            usuarioTo = usuarioBo.ConsultarIDF(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return usuarioTo;
    }

    public ArrayList<UsuarioTO> consultarTodos() {

        try {

            UsuarioBO usuarioBo = new UsuarioBO();
            usuarios = usuarioBo.consultarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }

    public void excluir(int id) {
        try {

            UsuarioBO usuBo = new UsuarioBO();
            usuBo.excluirID(id);
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }
    public void Maiuscula(JTextField maior){
            maior.setDocument(new UpperCaseMODEL());
        }

    public void LimpaTela() {
        usuarioTo.setCodUsuario(0);
        usuarioTo.setMatriculaFunc(0);
        usuarioTo.setNomeUsuario("");
        usuarioTo.setSenhaUsuario("");
        usuarioTo.setTipoUsuario("");

    }

}
