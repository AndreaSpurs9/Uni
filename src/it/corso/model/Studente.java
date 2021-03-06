package it.corso.model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Studente extends Persona {

	String regex="([a-z])+([0-9]{3})";
	String matricola;
	String facolta;
	
	
	
	public String getFacolta() {
		return facolta;
	}


	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		Scanner input=new Scanner(System.in);
		while(check(regex, matricola)==false){
			System.out.println("\nLa matricola inserita � in un formato non valido. Inserire una matricola valida\n");
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
		return "Studente: [" + super.toString() + " matricola:" + matricola + ", facolt�:" + facolta + "]";
	}
}
