package ENTITY;

public class Studente_prenotato {
	private String matricola;
	
	
	public Studente_prenotato() {
		this.matricola ="";
		
	}
	public Studente_prenotato(Studente matricola ) {
		this.matricola= matricola.getMatricola();
		
	}
	
	public void setMatricola(Studente matricola) {
		this.matricola = matricola.getMatricola();
	}
	public String getMatricola() {
		return matricola;
	}
	public String toString() {
		return("\n Studente Prenotato: "+ getMatricola());
		
	}
}
