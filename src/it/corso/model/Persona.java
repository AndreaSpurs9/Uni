package it.corso.model;

public class Persona {
	
	private String nome;
	private String cognome;
	private int eta;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	@Override
	public String toString() {
		return "nome:" + nome + ", cognome:" + cognome + ", età:" + eta;
	}
	
}
