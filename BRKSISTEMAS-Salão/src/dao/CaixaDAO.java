package dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import to.CaixaTO;
import to.EntradaCaixaTO;
import to.ProdutoDetalheTO;
import to.SaidaCaixaTO;
import to.ServicoDetalheTO;

public class CaixaDAO {

    public String incluir(CaixaTO caixaTo) throws Exception {
        try {
            Conexao teste = new Conexao();
            String SQL;
            SQL = "INSERT INTO caixa (dtabertura,hrabertura,valinicial,status)"
                    + "VALUES ('" + caixaTo.getDtabertura() + "','" + caixaTo.getHrabertura() + "','" + caixaTo.getValinicial() + "','" + caixaTo.getStatus() + "')";
            teste.conectaBD();
            teste.executaSQL(SQL);
            teste.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public String alterar(CaixaTO caixaTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE caixa SET dtfechamento='" + caixaTo.getDtfechamento() + "',hrfechamento='" + caixaTo.getHrfechamento() + "', status='" + caixaTo.getStatus() + "', valfinal='" + caixaTo.getValfinal() + "', saldototal='" + caixaTo.getSaldoTotal() + "', faltando='" + caixaTo.getFaltando() + "' WHERE codcaixa=" + caixaTo.getCodCaixa() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public String alterarObs(CaixaTO caixaTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;
            JOptionPane.showMessageDialog(null, "Observação gravada com sucesso!");
            SQL = "UPDATE caixa SET observacao='" + caixaTo.getObservacao() + "' WHERE codcaixa=" + caixaTo.getCodCaixa() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";

        } catch (Exception e) {
            throw e;
        }
    }

    public String alterarSaidaCaixa(SaidaCaixaTO saidaTo) throws Exception {
        try {
            CaixaTO caixaTo = new CaixaTO();
            CaixaDAO caixaDao = new CaixaDAO();
            caixaTo = caixaDao.Consultar("Aberto");
            Conexao con = new Conexao();
            String SQL;

            SQL = "INSERT INTO saidacaixa (codcaixa,descricao,datasaidac,horasaidac,valor,codusuario,tipomov)"
                    + "VALUES ('" + caixaTo.getCodCaixa() + "','" + saidaTo.getDescricao() + "','" + saidaTo.getDatasaidac() + "','" + saidaTo.getHorasaidac() + "','" + saidaTo.getValor() + "'," + saidaTo.getCodUsuario() + ",'" + saidaTo.getTipoMovimentacao() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public CaixaTO Consultar(String nome) throws Exception {

        Conexao con = new Conexao();
        String SQL;
        CaixaTO caixa = new CaixaTO();
        SQL = "SELECT * FROM caixa WHERE status='" + nome + "'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {

            if (rs.next()) {

                caixa.setDtabertura(rs.getString("dtabertura"));
                caixa.setDtfechamento(rs.getString("dtfechamento"));
                caixa.setHrabertura(rs.getString("hrabertura"));
                caixa.setHrfechamento(rs.getString("hrfechamento"));
                caixa.setValfinal(rs.getBigDecimal("valfinal"));
                caixa.setValinicial(rs.getBigDecimal("valinicial"));
                caixa.setStatus(rs.getString("status"));
                caixa.setCodCaixa(rs.getInt("codcaixa"));
                caixa.setObservacao(rs.getString("observacao"));

            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return caixa;
    }

    public CaixaTO ConsultarID(int id) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        CaixaTO caixa = new CaixaTO();
        SQL = "SELECT * FROM caixa WHERE codcaixa = " + id + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);
        try {

            if (rs.next()) {

                caixa.setDtabertura(rs.getString("dtabertura"));
                caixa.setDtfechamento(rs.getString("dtfechamento"));
                caixa.setHrabertura(rs.getString("hrabertura"));
                caixa.setHrfechamento(rs.getString("hrfechamento"));
                caixa.setValfinal(rs.getBigDecimal("valfinal"));
                caixa.setValinicial(rs.getBigDecimal("valinicial"));
                caixa.setStatus(rs.getString("status"));

            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return caixa;
    }

    public ArrayList<ProdutoDetalheTO> ProdutoDetalhe(int codcliente) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        ArrayList<ProdutoDetalheTO> prodA = new ArrayList();
        SQL = "select  descricaoprod,ct.nome as cliente,valorvenda,v.totalven,qtdeven from itenvendaprod ivp\n"
                + "JOIN produto p on ivp.codbarra = p.codbarra\n"
                + "JOIN venda v on ivp.codvenda = v.codvenda\n"
                + "JOIN entradacaixa ec on ec.codvenda = v.codvenda\n"
                + "JOIN caixa c on ec.codcaixa = c.codcaixa\n"
                + "JOIN cliente ct on v.codcliente = ct.codcliente\n"
                + "where c.status = 'Aberto' and ct.codcliente = " + codcliente + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);

        try {

            while (rs.next()) {
                ProdutoDetalheTO prodD = new ProdutoDetalheTO();
                prodD.setDescricaoprod(rs.getString("descricaoprod"));
                prodD.setCliente(rs.getString("cliente"));
                prodD.setValorvenda(rs.getBigDecimal("valorvenda"));
                prodD.setTotalvenda(rs.getBigDecimal("totalven"));
                prodD.setQtdeven(rs.getInt("qtdeven"));
                prodA.add(prodD);
            }
            return prodA;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        return prodA;
    }

    public ArrayList<ServicoDetalheTO> ServicoDetalhe(int codcliente) throws Exception {

        Conexao teste = new Conexao();
        String SQL;
        ArrayList<ServicoDetalheTO> servA = new ArrayList();
        SQL = "select s.descricao as descricaoserv,ct.nome as cliente,f.nomefunc,precounit as valorvenda,v.totalven from itenvenda iv\n"
                + "JOIN servico s on iv.codservico = s.codservico\n"
                + "JOIN venda v on iv.codvenda = v.codvenda\n"
                + "JOIN entradacaixa ec on ec.codvenda = v.codvenda\n"
                + "JOIN caixa c on ec.codcaixa = c.codcaixa\n"
                + "JOIN cliente ct on v.codcliente = ct.codcliente\n"
                + "JOIN funcionario f on iv.codfuncionario = f.matricula\n"
                + "where c.status = 'Aberto' and ct.codcliente =" + codcliente + "";
        teste.conectaBD();
        ResultSet rs = teste.executaConsulta(SQL);

        try {

            while (rs.next()) {
                ServicoDetalheTO servD = new ServicoDetalheTO();
                servD.setCliente(rs.getString("cliente"));
                servD.setDescricaoserv(rs.getString("descricaoserv"));
                servD.setNomefunc(rs.getString("nomefunc"));
                servD.setValorvenda(rs.getBigDecimal("valorvenda"));
                servD.setTotalven(rs.getBigDecimal("totalven"));
                servA.add(servD);
            }
            return servA;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        teste.desconectaBD();

        return servA;
    }

    public String AdicionarDinheiro(EntradaCaixaTO entradaTo) {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO entradacaixa (codcaixa,codvenda,descricao,dataentradac,hora,valor,codusuario,tipomov) VALUES(" + entradaTo.getCodCaixa() + "," + entradaTo.getCodVenda() + ",'" + entradaTo.getDescricao() + "','" + entradaTo.getDataEntracaC() + "','" + entradaTo.getHora() + "','" + entradaTo.getValor() + "'," + entradaTo.getCodUsuario() + ",'" + entradaTo.getTipoMovimentacao() + "')";
            con.conectaBD();
            con.executaSQL(SQL);

            con.desconectaBD();
            return "";
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados CAIXA");
            throw e;
        }

    }

    public String AdicionarDinheiro2(EntradaCaixaTO entradaTo) {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO entradacaixa (codcaixa,descricao,dataentradac,hora,valor,codusuario,tipomov) VALUES(" + entradaTo.getCodCaixa() + ",'" + entradaTo.getDescricao() + "','" + entradaTo.getDataEntracaC() + "','" + entradaTo.getHora() + "','" + entradaTo.getValor() + "'," + entradaTo.getCodUsuario() + ",'" + entradaTo.getTipoMovimentacao() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }

    }

    public String RetirarDinheiro(SaidaCaixaTO saidaTo) {
        try {
            Conexao con = new Conexao();
            String SQL;
            SQL = "INSERT INTO saidacaixa(codcaixa,descricao,datasaidac,horasaidac,valor,codusuario,tipomov) VALUES(" + saidaTo.getCodCaixa() + ",'" + saidaTo.getDescricao() + "','" + saidaTo.getDatasaidac() + "','" + saidaTo.getHorasaidac() + "','" + saidaTo.getValor() + "'," + saidaTo.getCodUsuario() + ",'" + saidaTo.getTipoMovimentacao() + "')";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<EntradaCaixaTO> consultarTodosEntrada() throws Exception {
        ArrayList<EntradaCaixaTO> entradaA = new ArrayList();
        try {
//*********************************************
            //RECUPERA TODOS OS ALUNOS DO BANCO
            //*********************************************
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "select * from cliente c inner join venda v on c.codcliente=v.codcliente right join entradacaixa ec on ec.codvenda=v.codvenda \n"
                    + "inner join caixa cx on cx.codcaixa=ec.codcaixa WHERE cx.status='Aberto' order by hora";
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                EntradaCaixaTO entrada = new EntradaCaixaTO();
                entrada.setCodCaixa(rs.getInt("codcaixa"));
                entrada.setCodEntradaCaixa(rs.getInt("codentradacaixa"));
                entrada.setCodUsuario(rs.getInt("codusuario"));
                entrada.setCodVenda(rs.getInt("codvenda"));
                entrada.setDataEntracaC(rs.getString("dataentradac"));
                entrada.setDescricao(rs.getString("descricao"));
                entrada.setHora(rs.getString("hora"));
                entrada.setTipoMovimentacao(rs.getString("tipomov"));
                entrada.setValor(rs.getBigDecimal("valor"));
                entrada.setNomeCliente(rs.getString("nome"));
                entradaA.add(entrada);
            }
            return entradaA;
        } catch (Exception e) {
            System.out.println(e);
        }
        return entradaA;
    }

    public ArrayList<EntradaCaixaTO> consultarTodosEntradaCli() throws Exception {
        ArrayList<EntradaCaixaTO> entradaA = new ArrayList();
        try {
//*********************************************
            //RECUPERA TODOS OS ALUNOS DO BANCO
            //*********************************************
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "select DISTINCT c.codcliente,c.nome, v.dataven,SUM(CAST(v.totalven as real)) as totalven, ec.tipomov from cliente c\n"
                    + "JOIN venda v on v.codcliente = c.codcliente\n"
                    + "JOIN  entradacaixa ec on ec.codvenda = v.codvenda\n"
                    + "JOIN caixa cx on cx.codcaixa = ec.codcaixa\n"
                    + "where cx.status='Aberto'\n"
                    + "GROUP BY c.codcliente, v.dataven, ec.tipomov";

            rs = con.executaConsulta(SQL);

            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            calendar.setTime(date);

            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                EntradaCaixaTO entrada = new EntradaCaixaTO();
                entrada.setCodcliente(rs.getInt("codcliente"));
                entrada.setNomeCliente(rs.getString("nome"));
                entrada.setTotalVenda(rs.getBigDecimal("totalven"));
                entrada.setDataEntracaC(rs.getString("dataven"));
                entrada.setHora(calendar.getTime().toString());
                entrada.setTipoMovimentacao(rs.getString("tipomov"));
                entradaA.add(entrada);
            }
            return entradaA;
        } catch (Exception e) {
            System.out.println(e);
        }
        return entradaA;
    }

    public ArrayList<SaidaCaixaTO> consultarTodosSaida() throws Exception {
        ArrayList<SaidaCaixaTO> saidaA = new ArrayList();
        try {

            //*********************************************
            //RECUPERA TODOS OS ALUNOS DO BANCO
            //*********************************************
            ResultSet rs;
            Conexao con = new Conexao();
            con.conectaBD();
            String SQL = "SELECT * FROM SAIDACAIXA sc,CAIXA c WHERE c.status ='Aberto' and sc.codcaixa = c.codcaixa and sc.valor >'0' ORDER BY horasaidac";
            rs = con.executaConsulta(SQL);
            //***********************************************
            //PARA CADA ALUNO MONTA UM TO E ADICONA O MESMO AO ARRAYLIST
            //************************************************************
            while (rs.next()) {
                SaidaCaixaTO saida = new SaidaCaixaTO();
                saida.setCodCaixa(rs.getInt("codcaixa"));
                saida.setCodSaidaCaixa(rs.getInt("codsaidacaixa"));
                saida.setCodUsuario(rs.getInt("codusuario"));
                saida.setDatasaidac(rs.getString("datasaidac"));
                saida.setDescricao(rs.getString("descricao"));
                saida.setHorasaidac(rs.getString("horasaidac"));
                saida.setTipoMovimentacao(rs.getString("tipomov"));
                saida.setValor(rs.getBigDecimal("valor"));
                saidaA.add(saida);
            }

            return saidaA;

        } catch (Exception e) {
            System.out.println(e);

        }
        return saidaA;
    }

    public CaixaTO ValorTotal() throws Exception {
        Conexao con = new Conexao();
        CaixaTO caixa = new CaixaTO();
        String SQL;
        SQL = "select (((select (case when sum(cast(valor as real)) is null then 0 else sum(cast(valor as real)) end) from entradacaixa e, caixa c where e.codcaixa = c.codcaixa and c.status = 'Aberto')+\n"
                + "(select sum(cast(valinicial as real))from caixa where status ='Aberto')-(select sum(cast(valor as real)) from saidacaixa s, caixa c where s.codcaixa = c.codcaixa and c.status='Aberto'))) as VALORTOTALCAIXA";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {
            if (rs.first()) {
                caixa.setSaldoTotal(rs.getBigDecimal("VALORTOTALCAIXA"));
            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return caixa;
    }

    public CaixaTO ValorTotalSomenteCaixa() throws Exception {
        Conexao con = new Conexao();
        CaixaTO caixa = new CaixaTO();
        String SQL;
        SQL = "select sum(cast(valinicial as real)) as valorTotalCaixa from caixa where status ='Aberto'";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {
            if (rs.first()) {
                caixa.setSaldoTotal(rs.getBigDecimal("valorTotalCaixa"));
            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return caixa;
    }

    public CaixaTO ValorTotalEntrada() throws Exception {
        Conexao con = new Conexao();
        CaixaTO caixa = new CaixaTO();
        String SQL;
        SQL = "select ((valortotal)-(saidacaixa)) as total FROM\n"
                + "\n"
                + "(select ((select sum(cast(valinicial as real)) from caixa where status='Aberto')+(select (case when (sum(cast(valor as real))) is null then 0 else sum(cast(valor as real)) end) \n"
                + "from entradacaixa e, caixa c where c.status='Aberto' and c.codcaixa = e.codcaixa )) as ValorTotal, (select sum(cast(valor as real)) from saidacaixa sc JOIN caixa c on sc.codcaixa = c.codcaixa and c.status = 'Aberto') as saidacaixa from caixa c left join entradacaixa ec on \n"
                + "c.codcaixa=ec.codcaixa and c.status ='Aberto' LIMIT 1) as temp";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {
            if (rs.first()) {
                caixa.setSaldoTotal(rs.getBigDecimal("total"));
            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return caixa;
    }

    public CaixaTO valorEntrada0() throws Exception {
        Conexao con = new Conexao();
        CaixaTO caixa = new CaixaTO();
        String SQL;
        SQL = "select ((select (case when sum(cast(valor as real)) is null then 0 else sum(cast(valor as real))end) from entradacaixa e, caixa c where c.status='Aberto' and c.codcaixa = e.codcaixa)) as ValorTotal\n"
                + "from caixa c left join entradacaixa ec on c.codcaixa=ec.codcaixa and c.status ='Aberto' LIMIT 1";
        con.conectaBD();
        ResultSet rs = con.executaConsulta(SQL);
        try {
            if (rs.first()) {
                caixa.setSaldoTotal(rs.getBigDecimal("ValorTotal"));
            }
            return caixa;
        } catch (Exception e) {
            System.out.println("Falha ao executar o sql e a pegar os dados");
        }
        rs.close();
        con.desconectaBD();

        return caixa;
    }

    public String alterarValorInicial(CaixaTO caixaTo) throws Exception {
        try {
            Conexao con = new Conexao();
            String SQL;

            SQL = "UPDATE caixa SET valinicial='" + caixaTo.getValinicial() + "' WHERE codcaixa=" + caixaTo.getCodCaixa() + "";
            con.conectaBD();
            con.executaSQL(SQL);
            con.desconectaBD();
            return "";
        } catch (Exception e) {
            throw e;
        }
    }

}
