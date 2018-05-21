/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author breni
 */
public class Mascara {

    public void mascaraCPF(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mascaraTelCel(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mascaraData(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mascaraCTPS(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.#####.##-#")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mascaraTelefone(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mascaraCep(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void Maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }
}
