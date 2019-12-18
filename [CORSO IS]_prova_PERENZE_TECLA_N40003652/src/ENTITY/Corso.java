package ENTITY;

public class Corso {
	private String nome_corso;
	private String nome_docente;
	private int numero_crediti;
	
	
	public Corso() {
		this.nome_corso="";
		this.nome_docente="";
		this.numero_crediti=0;
	}

	
		public Corso(String nome_corso, String nome_docente,int numero_crediti) {
			this.nome_corso= nome_corso;
			this.nome_docente= nome_docente;
			this.numero_crediti= numero_crediti;
		}
		
		
		public void setNomeCorso(String nome_corso) {
			this.nome_corso= nome_corso;
		}
		public String getNomeCorso() {
			return nome_corso;
		}
		
		public void setNomeDocente(String nome_docente) {
			this.nome_docente= nome_docente;
		}
		public String getNomeDocente() {
			return nome_docente;
		}
		public void setNumeroCrediti(int numero_crediti) {
			this.numero_crediti= numero_crediti;
		}
		public int getNumeroCrediti() {
			return numero_crediti;
		}
		public String toString() {
			return (" materia :"+getNomeCorso()+"\n docente: "+getNomeDocente()+" \n crediti: "+getNumeroCrediti());
		}
	
}

