package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UpperCaseMODEL extends PlainDocument {

    @Override
    public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws BadLocationException {

        super.insertString(offs, str.toUpperCase().replaceAll("[^a-z |^A-Z^ ]", ""), a);

    }

    public void replace(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        super.insertString(offs, str.toUpperCase().replaceAll("[^a-z |^A-Z^ ]", ""), a);

    }
}
