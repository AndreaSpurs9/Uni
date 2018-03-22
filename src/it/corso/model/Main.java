package it.corso.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	static HashMap<String, Studente> studenti = new HashMap<String, Studente>(0);
	static HashMap<String, Docente> docenti = new HashMap<String, Docente>(0);
	static String regexStud = "([a-z])+([0-9]{3})";
	static String regexDoc = "([0-9]{1})";

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int scelta = 0;

		System.out.println("****BENVENUTO****");
		System.out.println("Cosa vuoi fare?");

		do {
			System.out.println("------------------");
			System.out.println("1 - Inserisci Studente");
			System.out.println("2 - Inserisci Docente");
			System.out.println("3 - Cerca Studente");
			System.out.println("4 - Cerca Docente");
			System.out.println("5 - Stampa riepilogo");
			System.out.println("6 - Elimina elemento");
			System.out.println("7 - Termina programma");

			scelta = input.nextInt();
			input.nextLine();

			switch (scelta) {

			case 1:
				inserisciStud();
				break;

			case 2:
				inserisciProf();
				break;

			case 3:
				cercaStud();
				break;

			case 4:
				cercaProf();
				break;

			case 5:
				stampaRiepilogo();
				break;

			case 6:
				elimina();
				break;
			case 7:
				input.close();
				System.out.println("***ARRIVEDERCI***");
				break;
			}

		} while (scelta != 7);

	}

	private static void stampaRiepilogo() {

		Collection<Studente> collStud = studenti.values();
		Collection<Docente> collDoc = docenti.values();
		Iterator<Studente> itStud = collStud.iterator();
		Iterator<Docente> itDoc = collDoc.iterator();
		System.out.println("LISTA STUDENTI:");
		while (itStud.hasNext()) {
			Persona p = itStud.next();
			System.out.println(p);
		}
		System.out.println("LISTA DOCENTI:");
		while (itDoc.hasNext()) {
			Persona x = itDoc.next();
			System.out.println(x);
		}

	}

	private static void cercaProf() {
		if (!docenti.isEmpty()) {
			System.out.println("Inserisci la matricola del docente: ");
			String matricola = input.next();
			while (!Pattern.matches(regexDoc, matricola)) {
				System.out
						.println("\nLa matricola inserita è in un formato non valido. Inserire una matricola valida\n");
				matricola = input.next();
			}
			if (docenti.containsKey(matricola))
				System.out.println(docenti.get(matricola));
			else {
				System.out.println("Elemento non presente");
			}
		} else
			System.out.println("Nessun docente presente");
	}

	private static void cercaStud() {
		if (!studenti.isEmpty()) {
			System.out.println("Inserisci la matricola dello studente: ");
			String matricola = input.next();
			while (!Pattern.matches(regexStud, matricola)) {
				System.out
						.println("\nLa matricola inserita è in un formato non valido. Inserire una matricola valida\n");
				matricola = input.next();
			}
			if (studenti.containsKey(matricola))
				System.out.println(studenti.get(matricola));
			else {
				System.out.println("Elemento non presente");
			}
		} else
			System.out.println("Nessuno studente presente");
	}

	private static void inserisciProf() {
		Docente doc = new Docente();
		String matricola;
		boolean controllo = false;
		System.out.println("***Inserimento docente***");
		System.out.println("Matricola: ");
		do {
			//
			matricola = input.next();
			controllo = false;
			Collection<Docente> collDoc = docenti.values();
			Iterator<Docente> itDoc = collDoc.iterator();
			while (itDoc.hasNext()) {
				Docente x = itDoc.next();
				if (matricola.equals(x.getMatricola())) {
					controllo = true;
					System.out.println("matricola gia presente, inseriscine una nuova");
				}
			}
		} while (controllo);
		doc.setMatricola(matricola);
		System.out.println("Nome: ");
		doc.setNome(input.next());
		System.out.println("Cognome: ");
		doc.setCognome(input.next());
		System.out.println("Eta: ");
		doc.setEta(input.nextInt());
		System.out.println("Corso");
		doc.setCorso(input.next());
		System.out.println("");
		docenti.put(doc.getMatricola(), doc);

	}

	private static void inserisciStud() {
		String matricola;
		boolean controllo = false;
		Studente stud = new Studente();
		System.out.println("***Inserimento studente***");
		System.out.println("Matricola: ");

		do {
			//
			matricola = input.next();
			controllo = false;
			Collection<Studente> collStud = studenti.values();
			Iterator<Studente> itStud = collStud.iterator();
			while (itStud.hasNext()) {
				Studente x = itStud.next();
				if (matricola.equals(x.getMatricola())) {
					controllo = true;
					System.out.println("matricola gia presente, inseriscine una nuova");
				}
			}
		} while (controllo);
		stud.setMatricola(matricola);
		//
		System.out.println("Nome: ");
		stud.setNome(input.next());
		System.out.println("Cognome: ");
		stud.setCognome(input.next());
		System.out.println("Eta: ");
		stud.setEta(input.nextInt());
		System.out.println("Facolta");
		stud.setFacolta(input.next());
		System.out.println("");
		studenti.put(stud.getMatricola(), stud);
	}

	private static void elimina() {
		if (!studenti.isEmpty() || !docenti.isEmpty()) {
			System.out.println("Vuoi eliminare uno studente o un docente?\n1)Studente\n2)Docente");
			int scelta = input.nextInt();
			if (scelta == 1) {
				if (!studenti.isEmpty()) {
					Collection<Studente> collStud = studenti.values();
					Iterator<Studente> itStud = collStud.iterator();
					System.out.println("LISTA STUDENTI:");
					while (itStud.hasNext()) {
						Persona p = itStud.next();
						System.out.println(p);
					}
					System.out.println("Inserisci la matricola dello studente da eliminare: ");
					String mat = input.next();
					studenti.remove(mat);
					System.out.println("studente eliminato!");
				} else
					System.out.println("Non sono presenti studenti");
			} else if (scelta == 2) {
				if (!docenti.isEmpty()) {
					Collection<Docente> collDoc = docenti.values();
					Iterator<Docente> itDoc = collDoc.iterator();
					System.out.println("LISTA DOCENTI:");
					while (itDoc.hasNext()) {
						Persona x = itDoc.next();
						System.out.println(x);
					}
					System.out.println("Inserisci la matricola del docente da eliminare: ");
					String mat = input.next();
					docenti.remove(mat);
					System.out.println("docente eliminato!");
				} else
					System.out.println("Non sono presenti docenti");
			}
		} else
			System.out.println("Nulla da eliminare");
	}

}
