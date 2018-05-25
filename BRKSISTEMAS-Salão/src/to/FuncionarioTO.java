package to;

public class FuncionarioTO extends PessoasTO {

    private int matricula = 0;
    private String cargo;
    private String cts;
    private String serie;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCts() {
        return cts;
    }

    public void setCts(String cts) {
        this.cts = cts;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

}
