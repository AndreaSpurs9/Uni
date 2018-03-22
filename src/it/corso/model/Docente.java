package it.corso.model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Docente extends Persona {

	String regex="([0-9]{5})";
	String matricola;
	String corso;
	
	
	public String getCorso() {
		return corso;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		Scanner input=new Scanner(System.in);
		while(check(regex, matricola)==false){
			System.out.println("\nLa matricola inserita è in un formato non valido. Inserire una matricola valida\n");
			matricola=input.next();
		}
		this.matricola = matricola;
	}

	public static boolean check(String regex, String matricola){
		if(Pattern.matches(regex, matricola))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Docente: [" + super.toString() + " matricola:" + matricola + ", corso:" + corso + "]";
	}
}
