package dto;

public class Cargo {

    public static final String TABELA = "R024CAR";
    public static final String CAMPOS = "CODCAR, ESTCAR, TITCAR";
    public static final String CAMPO_CODCAR = "CODCAR";
    public static final String CAMPO_ESTCAR = "ESTCAR";
    public static final String CAMPO_TITCAR = "TITCAR";


    private String codcar;
    private String estcar;
    private String titcar;

    public String getCodcar() {
        return codcar;
    }

    public void setCodcar(String codcar) {
        this.codcar = codcar;
    }

    public String getEstcar() {
        return estcar;
    }

    public void setEstcar(String estcar) {
        this.estcar = estcar;
    }

    public String getTitcar() {
        return titcar;
    }

    public void setTitcar(String titcar) {
        this.titcar = titcar;
    }
}
