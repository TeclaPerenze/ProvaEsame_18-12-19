package CONTROL;

import java.time.LocalDate;
import java.util.LinkedList;

import ENTITY.Appello;
import ENTITY.Corso;
import ENTITY.Data_appello;
import ENTITY.Studente;
//import ENTITY.Data_appello;
import ENTITY.Studente_prenotato;

import ENTITY.Tipo_appello;
import ENTITY.Tipo_luogo;

public class Gestione_appelli {
	
	LinkedList<Appello> a_list;
	
	public Gestione_appelli(){
		a_list= new LinkedList<Appello>();   // costruttore 
	}
	
	
	// tutti i crea
	public Appello CreaAppello(Corso c) {  
		Appello a = new Appello(c);
		return a;
	}
	
	public Studente CreaStudente(String nome, String cognome, String m) {
		Studente s = new Studente(nome,cognome,m);
		return s;
	}
	
	
	public Studente_prenotato CreaStudentePrenotato(Studente matricola) {
		Studente_prenotato s_p = new Studente_prenotato(matricola);
		return  s_p;
		
	}
	
	public Data_appello CreaData(Tipo_luogo l,Tipo_appello ta,LocalDate data) {
		Data_appello date = new Data_appello(l,ta,data);
		return date;
			}
	
	
	   // gli inserisci
	public void InserisciAppello(Appello a) {
		a_list.add(a);
		}
	
	public void RimuoviAppello(Appello a) {
		a_list.remove(a);
	 }
		
	public void InserisciStudente(Studente s ,Appello a) {
		a.getStudente().add(s);
	}
	
	public void InserisciStudentep(Studente_prenotato s, Appello a) {
		
		
		for (Studente_prenotato stud : a.getStudentep()){
			if( s== stud) {
				a.getStudentep().remove(s);
				System.out.println( "\n ERRORE: studente già prenotato \n");
				break;
			}
		}a.getStudentep().add(s);
		
	}
	
	
	public void RimuoviStudentep(Studente_prenotato s,Appello a) {
		a.getStudentep().remove(s);
	}
	
	
	
	public void InserisciDataAppello(Data_appello date, Appello a) {
		a.getDataAppello().add(date);
		
	}
	public void RimuoviDataAppello(Data_appello date, Appello a) {
		a.getDataAppello().remove(date);
	}
	
	
	
	//leggi
	public LinkedList<Studente_prenotato> readallstudenti(Appello a) {  //visualizza lista studenti prenotati all'interno della lista appelli
		return a.getStudentep();
	}
	
	public LinkedList<Data_appello> readalldate(Appello a){
		return a.getDataAppello();
		}
	}
