package dao;

public class RequestDataProvider {

    private String usuario;
    private String senha;
    private String encriptacao;
    private String campos;
    private String tabela;
    private String valorMax;
    private String valorMin;
    private String param1;
    private String param2;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEncriptacao() {
        return encriptacao;
    }

    public void setEncriptacao(String encriptacao) {
        this.encriptacao = encriptacao;
    }

    public String getCampos() {
        return campos;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getValorMax() {
        return valorMax;
    }

    public void setValorMax(String valorMax) {
        this.valorMax = valorMax;
    }

    public String getValorMin() {
        return valorMin;
    }

    public void setValorMin(String valorMin) {
        this.valorMin = valorMin;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}