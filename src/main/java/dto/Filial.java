package dto;

public class Filial {

    public static final String TABELA = "R030FIL";
    public static final String CAMPOS = "NOMFIL, CODFIL, NUMEMP";

    private String nomfil;
    private String codfil;
    private String numemp;

    public String getNomfil() {
        return nomfil;
    }

    public void setNomfil(String nomfil) {
        this.nomfil = nomfil;
    }

    public String getCodfil() {
        return codfil;
    }

    public void setCodfil(String codfil) {
        this.codfil = codfil;
    }

    public String getNumemp() {
        return numemp;
    }

    public void setNumemp(String numemp) {
        this.numemp = numemp;
    }
}
