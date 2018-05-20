package to;

public class ClienteTO extends PessoasTO {

    private int codCliente;
    private String cmfotoCli;
    private String statusCli;
    private String datapriVisita;
    private String dataultVisita;
    private String dataCadastro;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCmfotoCli() {
        return cmfotoCli;
    }

    public void setCmfotoCli(String cmfotoCli) {
        this.cmfotoCli = cmfotoCli;
    }

    public String getStatusCli() {
        return statusCli;
    }

    public void setStatusCli(String statusCli) {
        this.statusCli = statusCli;
    }

    public String getDatapriVisita() {
        return datapriVisita;
    }

    public void setDatapriVisita(String datapriVisita) {
        this.datapriVisita = datapriVisita;
    }

    public String getDataultVisita() {
        return dataultVisita;
    }

    public void setDataultVisita(String dataultVisita) {
        this.dataultVisita = dataultVisita;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
}
