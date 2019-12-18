package ENTITY;

public class Studente {
	private String nome;
	private String cognome;
	private String matricola;
	
	
	public Studente() {
		this.cognome = "";
		this.matricola = "";
		this.nome = "";
	}
	
	public Studente(String nome, String cognome, String matricola) {
		this.nome= nome;
		this.cognome= cognome;
		this.matricola= matricola;
	}
	
	public void setNome( String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	public void SetCognome( String cognome) {
		this.cognome= cognome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getMatricola() {
		return matricola;
	}
	
	public String ToString() {
		return ("Studente: "+ nome+ " "+ cognome+" "+ matricola+"\n");
	}
}
