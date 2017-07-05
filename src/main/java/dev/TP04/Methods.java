package dev.TP04;

import java.util.Scanner;

public class Methods {

	 static void list(Pizza[] pizzas, int j) {
		int i = 0;
		while (i < j) {
			System.out.println(pizzas[i].toString());
			i++;
		}
	}

	 static int addPizza(Pizza[] pizzas, int j) {
		String code;
		String nom;
		Double prix;
		Scanner scann = new Scanner(System.in);
		System.out.println("Veuillez saisir le code");
		code = scann.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		nom = scann.next();
		System.out.println("Veuillez saisir le prix");
		prix = scann.nextDouble();
		pizzas[j] = new Pizza(j, code, nom, prix);
		j++;
		return j;
	}

	 static void modifyPizza(Pizza[] pizzas, int j) {
		Scanner scann = new Scanner(System.in);
		System.out.println("Veuillez saisir le code de la pizza a modifier:"); 
		System.out.println("99 pour abandonner");															
																				
		String code = scann.next();

		if (!code.equals("99")) {

			int a=checkList(code, pizzas, j); //It returns the position of the code searched
			

			
			if (a<j){
				
				String nom;
				Double prix;
				System.out.println("Introduisez le noveau code");
				code = scann.next();
				System.out.println("Introduisez le noveau nom (sans espace)");
				nom = scann.next();
				System.out.println("Introduisez le noveau prix");
				prix = scann.nextDouble();

				pizzas[a].setPizza(code, nom, prix);}
		
			else{System.out.println("Code not found");} }
	}

	 static int deletePizza(int j, Pizza[] pizzas) {
		System.out.println("Veuillez saisir le code de la pizza a eliminer:");
		System.out.println("99 pour abandonner");

		String code;

		Scanner scann = new Scanner(System.in);
		code = scann.next();

		if (!code.equals("99")) {

			int a=checkList(code, pizzas, j); //It returns the position of the code searched
			
			if (a<j){
				reestructure (pizzas, a, j);
				pizzas[j] = null;
				j--;}}
			else{System.out.println("Code not found");} //In case the code is not found
		
		return j;}

	
//It returns the position of the code searched
private static int checkList(String Q, Pizza[] pizzas, int j){
	
	
	/* Busqueda en la matriz a ver si encuentra el codigo */
	int a = 0;
	boolean c = false;
	do {

		if (Q.equals(pizzas[a].getCode())) {
			c = true;
		} else if (!Q.equals(pizzas[a].getCode())) {
			a++;
		}

	} while (c == false && a<j);
	
	
	
	return a;
}

//It reestructure the table to eliminate the gaps
private static void reestructure (Pizza[] pizzas, int a, int j){
	// Reestructuracion de la tabla
	int b;
	while (a <(j-1)) {

					b = a + 1;
					
					String code = pizzas[b].getCode();
					String nom = pizzas[b].getNom();
					Double prix = pizzas[b].getPrix();
					pizzas[a].setPizza(code, nom, prix);
					a++;}
}


}
