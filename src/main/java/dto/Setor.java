package dto;

public class Setor {

    public static final String TABELA = "R016ORN";
    public static final String CAMPOS = "NOMLOC,NUMLOC,TABORG";

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
