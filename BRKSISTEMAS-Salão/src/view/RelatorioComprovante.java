package view;

import dao.Conexao;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioComprovante {

    public void EmitirCupom(int codentradacaixa) {
        try {
            Conexao con = new Conexao();
            String SQL = "select c.nome,c.cpf, v.totalven,s.descricao from cliente c \n" +
                    "join venda v on v.codcliente=c.codcliente \n" +
                    "join itenvenda iv on iv.codvenda=v.codvenda\n" +
                    "join servico s on s.codservico=iv.codservico\n" +
                    "join entradacaixa ec on v.codvenda=ec.codvenda\n" +
                    "where ec.codentradacaixa="+codentradacaixa+";";
            JOptionPane.showMessageDialog(null, SQL);
            con.conectaBD();
            ResultSet rs = con.executaConsulta(SQL);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            HashMap map = new HashMap();
            String arquivo = "C:\\Users\\Brenicio\\SkyDrive\\Projetos\\BRKSISTEMAS-Salão\\BRKSISTEMAStodas4.1\\BRKSISTEMAStodas4\\BRKSISTEMAS-Salão\\Nova Pasta\\relatorioComprovante.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, jrRS);
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            jrviewer.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o relatório.");
        }
    }
}
