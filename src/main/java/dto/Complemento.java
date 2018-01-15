package dto;

public class Complemento {

    public static final String TABELA = "R034CPL";
    public static final String CAMPOS = "EMAPAR, EMACOM, NUMEMP, TIPCOL, NUMCAD";

    private String emapar;
    private String emacom;
    private String numemp;
    private String tipcol;
    private String numcad;

    public String getEmapar() {
        return emapar;
    }

    public void setEmapar(String emapar) {
        this.emapar = emapar;
    }

    public String getEmacom() {
        return emacom;
    }

    public void setEmacom(String emacom) {
        this.emacom = emacom;
    }

    public String getNumemp() {
        return numemp;
    }

    public void setNumemp(String numemp) {
        this.numemp = numemp;
    }

    public String getTipcol() {
        return tipcol;
    }

    public void setTipcol(String tipcol) {
        this.tipcol = tipcol;
    }

    public String getNumcad() {
        return numcad;
    }

    public void setNumcad(String numcad) {
        this.numcad = numcad;
    }
}
