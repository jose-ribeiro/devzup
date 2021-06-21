package com.devzup.desafio.domain.entidades;

import java.util.Scanner;

public class carroTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("numero");
		int diaDaSemana = sc.nextInt();
		
		switch(diaDaSemana) {
		case 0 :
			case 1:
			System.out.println("Segunda feira");
			break;
		case 2:
			case 3:
			System.out.println("Terça feira");
			break;
		case 4:
			case 5:
			System.out.println("Quarta feira");
			break;
		case 6:
			case 7:
			System.out.println("Quinta feira");
			break;
		case 8:
			case 9:
			System.out.println("Sexta feira");
			break;

		}
		
		 		 sc.close();

	}

}
