package dto;

public class Funcionario {

    public static final String TABELA = "R034FUN";
    public static final String CAMPOS = "NUMEMP,CODFIL,TABORG,NUMLOC,TIPCOL,NUMCAD,NOMFUN,NUMCPF";


    private String numcad;
    private String nomfun;
    private String numcpf;

    private String numemp;
    private String codfil;
    private String taborg;
    private String numloc;
    private String tipcol;

    public String getNumcad() {
        return numcad;
    }

    public void setNumcad(String numcad) {
        this.numcad = numcad;
    }

    public String getNomfun() {
        return nomfun;
    }

    public void setNomfun(String nomfun) {
        this.nomfun = nomfun;
    }

    public String getNumcpf() {
        return numcpf;
    }

    public void setNumcpf(String numcpf) {
        this.numcpf = numcpf;
    }

    public String getNumemp() {
        return numemp;
    }

    public void setNumemp(String numemp) {
        this.numemp = numemp;
    }

    public String getCodfil() {
        return codfil;
    }

    public void setCodfil(String codfil) {
        this.codfil = codfil;
    }

    public String getTaborg() {
        return taborg;
    }

    public void setTaborg(String taborg) {
        this.taborg = taborg;
    }

    public String getNumloc() {
        return numloc;
    }

    public void setNumloc(String numloc) {
        this.numloc = numloc;
    }

    public String getTipcol() {
        return tipcol;
    }

    public void setTipcol(String tipcol) {
        this.tipcol = tipcol;
    }
}
