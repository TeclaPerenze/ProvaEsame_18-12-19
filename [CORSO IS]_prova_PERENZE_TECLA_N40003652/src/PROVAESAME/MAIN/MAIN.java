package PROVAESAME.MAIN;

import java.time.LocalDate;
import java.time.Month;

import CONTROL.Gestione_appelli;
import CONTROL.Gestione_corsi;
import ENTITY.Appello;
import ENTITY.Corso;
import ENTITY.Data_appello;
import ENTITY.Studente;
import ENTITY.Studente_prenotato;

import ENTITY.Tipo_appello;
import ENTITY.Tipo_luogo;

public class MAIN {

	public static void main(String[] args) {
		// studenti, nell appello metti gli studenti prenotati e basta, cosi quando vai a stampare appelli ti trovi solo gli studenti prenotati

		Gestione_appelli GA = new Gestione_appelli();
		Gestione_corsi GC= new Gestione_corsi();
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		Corso corso3 = GC.creaCorso("Analisi 2","De maio",6);
		
		Data_appello data1= GA.CreaData (Tipo_luogo.AULA ,Tipo_appello.ORALE, LocalDate.of(2010, Month.APRIL,5));
		Data_appello data2= GA.CreaData (Tipo_luogo.LABORATORIO ,Tipo_appello.PROVA_CALCOLATORE, LocalDate.of(2010, Month.FEBRUARY,7));
		Data_appello data3= GA.CreaData (Tipo_luogo.AULA ,Tipo_appello.SCRITTO, LocalDate.of(2010, Month.APRIL,15));
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente studente3= GA.CreaStudente("Chiara","Lopez","N333");
		
		Studente_prenotato s_p1= GA.CreaStudentePrenotato(studente1);
		Studente_prenotato s_p2= GA.CreaStudentePrenotato(studente2);
		
		
	
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciDataAppello(data1, appello1);
		GA.InserisciDataAppello(data2, appello1);
		GA.InserisciStudentep(s_p2, appello1);
		GA.InserisciStudentep(s_p1, appello1);
		
		
		
		System.out.println("APPELLO \n Corso correlato: \n"+appello1.getNomeCorso().toString()+"\n\n"+" STUDENTI PRENOTATI: "+GA.readallstudenti(appello1).toString()+"\n\n "+
		"DATE : "+GA.readalldate(appello1).toString()+"\n\n\n");
		
		
		Appello appello2 = GA.CreaAppello(corso2);
		GA.InserisciDataAppello(data1, appello2);
		GA.InserisciDataAppello(data3, appello2);
		GA.InserisciStudentep(s_p2, appello2);
		
		
		
		System.out.println("APPELLO \n Corso correlato: \n"+appello2.getNomeCorso().toString()+"\n\n"+" STUDENTI PRENOTATI: "+GA.readallstudenti(appello2).toString()+"\n\n "+
		"DATE : "+GA.readalldate(appello2).toString()+"\n\n\n");
		
		Appello appello3 = GA.CreaAppello(corso3);
		GA.InserisciDataAppello(data2, appello3);
		GA.InserisciDataAppello(data3, appello3);
		GA.InserisciStudentep(s_p2, appello3);
		GA.InserisciStudentep(s_p1, appello3);
		GA.InserisciStudentep(s_p1, appello3);
		
		
		
		System.out.println("APPELLO \n Corso correlato: \n"+appello3.getNomeCorso().toString()+"\n\n"+" STUDENTI PRENOTATI: "+GA.readallstudenti(appello3).toString()+"\n\n "+
		"DATE : "+GA.readalldate(appello3).toString());
		
		}
	}


