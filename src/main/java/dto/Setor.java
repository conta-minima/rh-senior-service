package dto;

public class Setor {

    public static final String TABELA = "R016ORN";
    public static final String CAMPOS = "NOMLOC,NUMLOC,TABORG";
    public static final String CAMPO_NOMLOC = "NOMLOC";
    public static final String CAMPO_NUMLOC = "NUMLOC";
    public static final String CAMPO_TABORG = "TABORG";

    private String numloc;
    private String taborg;
    private String nomloc;

    public String getNumloc() {
        return numloc;
    }

    public void setNumloc(String numloc) {
        this.numloc = numloc;
    }

    public String getTaborg() {
        return taborg;
    }

    public void setTaborg(String taborg) {
        this.taborg = taborg;
    }

    public String getNomloc() {
        return nomloc;
    }

    public void setNomloc(String nomloc) {
        this.nomloc = nomloc;
    }
}
