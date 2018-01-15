package dto;

public class Empresa {

    public static final String TABELA = "R030EMP";
    public static final String CAMPOS = "NOMEMP, NUMEMP";

    private String numemp;
    private String nomemp;

    public String getNumemp() {
        return numemp;
    }

    public void setNumemp(String numemp) {
        this.numemp = numemp;
    }

    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }
}
