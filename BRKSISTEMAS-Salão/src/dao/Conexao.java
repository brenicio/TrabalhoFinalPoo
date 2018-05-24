package dao;

import java.sql.*;

//******************************************************************//
//  CLASSE DE PERSISTÊNCIA PARA CONEXÃO COM O BANCO DE DADOS        //
//  Atributos:                                                      //
//      Connection con                                              //
//      Statement st                                                //
//      ResultSet rs                                                //
//      String driver = "org.postgresql.Driver";                    //
//      private String driver = "org.postgresql.Driver";            //
//      private String url = "jdbc:postgresql://localhost:5432/asa";//
//      private String login = "postgres";                          //
//      private String password = "aaaaaa";                         //
//  Métodos:                                                        //
//      void conectaBD()                                            //
//      void desconectaBD()                                         //
//      void executaSQL(String SQL)                                 //
//      ResultSet executaConsulta(String SQL)                       //
//      int executaConsultaSerial(String SQL)                       //
//******************************************************************//
public class Conexao {

    private Connection con;
    private Statement st;
    public ResultSet rs;
    /*
    private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String url = "jdbc:odbc:asa";
    private String login = "access";
    private String password = "aaaaaa";
     */
    private String driver = "org.postgresql.Driver";
    //private String url = "jdbc:postgresql://127.0.0.1:5432/asa";
    private String url = "jdbc:postgresql://localhost:5432/db_paulo";
    private String login = "postgres";
    private String password = "bgv6098";

    //******************************************************************************//
    //  - Construtor para o objeto da classe Conexao                                //
    //******************************************************************************//
    public Conexao() {
    }

    //******************************************************************************//
    //  - Método para estabelecer uma conexao com o banco de dados, com base nos    //
    //  parametros: driver, url, login e password                                   //
    //******************************************************************************//
    public void conectaBD() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, login, password);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Falha ao conectar no BD!!");
        }
    }

    //******************************************************************************//
    //  - Método para encerrar uma conexao com o recordset e a conexao prorpiamente //
    //  dita                                                                        //
    //******************************************************************************//
    public void desconectaBD() {
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Falha ao desconectar do BD!!");
        }
    }

    //******************************************************************************//
    //  - Método para executar uma instrução SQL no banco de dados                  //
    //******************************************************************************//
    public void executaSQL(String SQL) throws Exception {
        st.execute(SQL);

    }

    //******************************************************************************//
    //  - Método para executars uma instrução SQL no banco de dados, retornando o    //
    //  recordset resultante da instrução SQL                                       //
    //******************************************************************************//
    public ResultSet executaConsulta(String SQL) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(SQL);
            return rs;
        } catch (Exception e) {
            System.out.println("Falha na consulta!!");
        }
        return rs;
    }

    //******************************************************************************//
    //  - Método para a busca do ultimo registro gerado de qualquer tabela que tenha//
    //  um campo autonumeração, a tabela será identificada no parametro SQL         //
    //******************************************************************************//    
    public int executaConsultaSerial(String SQL) {
        int codigo = 0;
        try {
            rs = st.executeQuery(SQL);
            rs.next();
            return rs.getInt("currval");
        } catch (Exception e) {
            System.out.println("Falha na consulta serial!!");
        }
        return codigo;
    }
}
