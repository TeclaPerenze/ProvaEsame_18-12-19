package CONTROL;

import java.util.LinkedList;

import ENTITY.Corso;

public class Gestione_corsi {

	
	LinkedList<Corso> c_list;
	
	
	public Gestione_corsi() {
		c_list = new LinkedList<Corso>();
	}
	
	
	public Corso creaCorso(String nome_corso, String nome_docente,int numero_crediti) {
		Corso c= new Corso(nome_corso,nome_docente,numero_crediti);
		return c;
	}
	 public void InserisciCorso(Corso c) {
		 c_list.add(c);
	 }
	public void RimuoviCorso(Corso c) {
		c_list.remove(c);
	}
;}
