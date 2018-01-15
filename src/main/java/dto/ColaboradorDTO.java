package dto;

public class ColaboradorDTO {
	
	private String nome;
	private String matricula;
	private String empresa;
	private String unidade;
	private String setor;
	private String email;
    
	private Boolean ativo;
	
	private String pabx;
	private String cargo;
	private String cpf;
	
	@Override
	public String toString() {
		return "ColaboradorDTO [nome=" + nome + ", matricula=" + matricula + ", empresa=" + empresa + ", unidade="
				+ unidade + ", setor=" + setor + ", email=" + email + ", ativo=" + ativo + ", pabx=" + pabx + ", cargo=" + cargo + ", cpf=" + cpf + "]";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getPabx() {
		return pabx;
	}
	public void setPabx(String pabx) {
		this.pabx = pabx;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
