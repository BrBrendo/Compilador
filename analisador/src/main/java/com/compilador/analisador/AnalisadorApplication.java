package com.compilador.analisador;


public class AnalisadorApplication {

	public static void main(String[] args) {
		LexScan scan = new LexScan("input.txt");
		Token token = null;
		Sintatico sintatico = new Sintatico("input.txt");
		
			sintatico.toString();
		
	}

}
