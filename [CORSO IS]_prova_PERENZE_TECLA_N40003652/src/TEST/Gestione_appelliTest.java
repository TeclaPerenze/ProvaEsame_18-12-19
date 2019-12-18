package TEST;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CONTROL.Gestione_appelli;
import CONTROL.Gestione_corsi;
import ENTITY.Appello;
import ENTITY.Corso;
import ENTITY.Studente;
import ENTITY.Studente_prenotato;

public class Gestione_appelliTest {
	Gestione_appelli GA;
	Gestione_corsi GC;
	@Before
	public void setUp() throws Exception {
		GA= new Gestione_appelli();
		GC= new Gestione_corsi();
	}

	@After
	public void tearDown() throws Exception {
		GA = null;
		GC = null;
	}

	
	@Test
	public void test01() throws Exception{      //caso 1 corso abbia 0 appelli esito negativo crea lista  nulla studenti;
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);  //hai inserito il corso
				
		Appello appello1 = GA.CreaAppello(corso1); //hai solo creato l'appello ma non lo hai inserito
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		assertEquals(0,lista_prenotati.size());		
	}

	@Test
	public void test02() throws Exception{      //caso 1 corso abbia 1 appelli e 0 studenti crea lista nulla;
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
				
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		assertEquals(0,lista_prenotati.size());		
	}
	
	@Test
	public void test03() throws Exception{      // due studenti vanno all appello 1 ma voglio la lista dell appello 2 quindi lista deve uscire 0
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		GC.InserisciCorso(corso2);
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Appello appello2 = GA.CreaAppello(corso2);
		GA.InserisciAppello(appello2);
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		LinkedList<Studente_prenotato> lista_prenotati= appello2.getStudentep();
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello1);
		
		assertEquals(0,lista_prenotati.size());		
	
	}
	
	@Test
	public void test04() throws Exception{      //caso 1 corso abbia 1 appelli e 1 studente non  abbia prenotato crea lista nulla;
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
				
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Studente studente3= GA.CreaStudente("Chiara","Lopez","N333");
		GA.InserisciStudente(studente3, appello1);
				
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		assertEquals(0,lista_prenotati.size());		
	}
	
	@Test
	public void test05() throws Exception{      //caso 0 corso abbia 1 appelli e 1 studente  crea lista nulla;
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		
				
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		assertEquals(0,lista_prenotati.size());		
	}
	
	@Test
	public void test06() throws Exception{      // due studenti vanno a 2 appelli diversi  ma voglio la lista dell appello 3 quindi lista deve uscire 0
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		GC.InserisciCorso(corso2);
		
		Corso corso3 = GC.creaCorso("Analisi2","De maio",6);
		GC.InserisciCorso(corso2); 
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Appello appello2 = GA.CreaAppello(corso2);
		GA.InserisciAppello(appello2);
		
		Appello appello3 = GA.CreaAppello(corso3);
		GA.InserisciAppello(appello3);
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello3.getStudentep();
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello2);
		
		assertEquals(0,lista_prenotati.size());		
	
	}
	
	@Test
	public void test07() throws Exception{      // due studenti  studenti vanno a 2 appelli   entrambe le liste piene
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		GC.InserisciCorso(corso2);
		
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Appello appello2 = GA.CreaAppello(corso2);
		GA.InserisciAppello(appello2);
		
		
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		LinkedList<Studente_prenotato> lista_prenotati1= appello2.getStudentep();
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello2);
		
		assertEquals(1,lista_prenotati.size());
		assertEquals(1,lista_prenotati1.size());
	
	}
	
	@Test
	public void test08() throws Exception{      // due studenti vanno allo stesso appello , lista contiene  2
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
				
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello1);
		
		assertEquals(2,lista_prenotati.size());
		
	
	}
	@Test
	public void test09() throws Exception{      // due studenti  studenti vanno a 2 corsi  ma solo 1 corso ha l appello due liste una piena e una vuota FORSE INUTILE
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		GC.InserisciCorso(corso2);
		
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Appello appello2 = GA.CreaAppello(corso2);		
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		LinkedList<Studente_prenotato> lista_prenotati1= appello2.getStudentep();
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudente(studente2, appello2);
		
		assertEquals(1,lista_prenotati.size());
		assertEquals(0,lista_prenotati1.size());
	
	}
	@Test
	public void test10() throws Exception{      // due studenti vanno a 2 appelli diversi  ma voglio la lista dell appello 3 quindi lista deve uscire 0
		
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
		Appello appello2 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello2);
		
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		LinkedList<Studente_prenotato> lista_prenotati1= appello2.getStudentep();
		
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello1);
		
		assertEquals(2,lista_prenotati.size());		
		assertEquals(0,lista_prenotati1.size());
	
	}
	@Test
	public void test11() throws Exception{      //caso 3 corso con 3 appelli con esito positivo 2 studenti;
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		Corso corso2 = GC.creaCorso("Fisica 1","Andreone",9);
		Corso corso3 = GC.creaCorso("Analisi 2","De maio",6);
		
		GC.InserisciCorso(corso1);
		GC.InserisciCorso(corso2);
		GC.InserisciCorso(corso3);
		
		Appello appello1 = GA.CreaAppello(corso1);
		Appello appello2 = GA.CreaAppello(corso2);
		Appello appello3 = GA.CreaAppello(corso3);
		
		GA.InserisciAppello(appello1);
		GA.InserisciAppello(appello2);
		GA.InserisciAppello(appello3);
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1= GA.CreaStudentePrenotato(studente1);
		
		Studente studente2= GA.CreaStudente("Sara","Rossi","N222");
		Studente_prenotato s_p2 = GA.CreaStudentePrenotato(studente2);
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p2, appello2);
		GA.InserisciStudentep(s_p2, appello3);

		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		LinkedList<Studente_prenotato> lista_prenotati1= appello2.getStudentep();
		LinkedList<Studente_prenotato> lista_prenotati2= appello3.getStudentep();
		
		
		assertEquals(1,lista_prenotati.size());		
		assertEquals(1,lista_prenotati1.size());
		assertEquals(1,lista_prenotati2.size());
		
		
	}
	@Test
	public void test12() throws Exception{      // stesso  studente va allo stesso appello , lista contiene  1
		Corso corso1 = GC.creaCorso("Analisi 1", "De maio",9);
		GC.InserisciCorso(corso1);
		
		
		Appello appello1 = GA.CreaAppello(corso1);
		GA.InserisciAppello(appello1);
		
				
		
		Studente studente1= GA.CreaStudente("Mario","Perrotta","N111");
		Studente_prenotato s_p1 = GA.CreaStudentePrenotato(studente1);
		
		
		
		
		LinkedList<Studente_prenotato> lista_prenotati= appello1.getStudentep();
		
		
		GA.InserisciStudentep(s_p1, appello1);
		GA.InserisciStudentep(s_p1, appello1);
		
		assertEquals(1,lista_prenotati.size());
}
}
