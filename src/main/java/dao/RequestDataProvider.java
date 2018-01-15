package dao;

public class RequestDataProvider {

    private String usuario;
    private String senha;
    private String encriptacao;
    private String campos;
    private String tabela;

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
}