package ENTITY;

import java.util.LinkedList;

public class Appello {
  
  private Corso corso;
  LinkedList<Data_appello> data;
  LinkedList<Studente_prenotato> studentep;
  private String nome_appello;
  LinkedList<Studente> studente;
  
  
 
  
  	public Appello() {
	  this.data= null;
	  this.corso= new Corso();
	  this.studentep= null;
	  this.nome_appello= "";
	  this.studente=null;
	  

  }
  
  	public Appello(Corso c) {
  		this.data = new LinkedList<Data_appello>();
  		this.corso= c;
  		this.studentep= new LinkedList<Studente_prenotato>();
  		this.nome_appello= c.getNomeCorso();
  		this.studente= new LinkedList<Studente>();
  		
  	}
  	
  	public void setData (LinkedList<Data_appello> data) {
  		this.data = data;
  	}
  	public LinkedList<Data_appello> getDataAppello() {
  		return data;
  	}
  	public void setNomeCorso(Corso c) {
  		this.corso = c;
  	}
  	public Corso getNomeCorso() {
  		return corso;
  	}
  	public void setStudentep (LinkedList<Studente_prenotato> studentep) {
  		this.studentep = studentep;
  	}
  	public LinkedList<Studente_prenotato> getStudentep() {
  		return studentep;
  	}
  	public void setNomeAppello(Corso c) {
  		this.nome_appello=c.getNomeCorso();
  	}
  	public String getNomeAppello(){
  		return nome_appello;
  	}
  	public LinkedList<Studente> getStudente() {
  		return studente;
  	}
  	
  	public String ToString() {
  		return ("Appello: "+this.nome_appello+" "+getNomeCorso().toString()+" "+getNomeAppello()+" ");
  	}
}
