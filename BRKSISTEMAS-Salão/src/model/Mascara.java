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

    public static void mascaraCPF(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mascaraTelCel(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void mascaraData(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void mascaraCTPS(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.#####.##-#")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void mascaraTelefone(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void mascaraCep(JFormattedTextField mask) {
        try {
            mask.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
        } catch (ParseException e) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void Maiuscula(JTextField maior) {
        maior.setDocument(new UpperCaseMODEL());
    }

    public static void somenteNumero(JFormattedTextField numero, int tamanho) {
        numero.setDocument(new LimiteDigitosMODEL(tamanho));
    }
}
