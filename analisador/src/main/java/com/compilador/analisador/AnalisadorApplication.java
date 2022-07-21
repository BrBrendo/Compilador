package com.compilador.analisador;


public class AnalisadorApplication {

	public static void main(String[] args) {
		LexScan scan = new LexScan("input.txt");
		Token token = null;
		do{
			token = scan.nextToken();
			System.out.println(token);
		}while(token!=null); 
	}

}
