package com.compilador.analisador;
import java.util.ArrayList;
import java.util.List;

public class Sintatico {
	private LexScan lexico;
	private Token token;
	private Integer erro;
	private Semantico semantico;
	List<String> casamentos = new ArrayList<>();
	
	public Sintatico(String arq) {
		lexico = new LexScan(arq);
		obterToken();
		
			
		  List<String> pilha = new ArrayList<>();
		  List<String> casamento = new ArrayList<>();
	      erro = 0;
	      pilha.add("E");
	      
	        while (!pilha.isEmpty()  && erro == 0) {

	            if (pilha.get(0) == "E") {
	                if (token.getTipo() == 5) {
	                	pilha.remove(0);
	                	pilha.add(0,"Ei");
	                	pilha.add(0,"T");

	                } else if (token.getTipo() == 12) {
	                 	pilha.remove(0);
	                	pilha.add(0,"Ei");
	                	pilha.add(0,"T");

	                } else if ( token.getTipo() == 1) {
	                    pilha.remove(0);
	                    pilha.add(0,"Ei");
	                    pilha.add(0,"T");

	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) == "Ei") {
	            	
	            	if (token == null) {
		               
	            		pilha.remove(0);
	           		} else if (token.getTipo() == 6) {

	                	pilha.remove(0);

	                } else if (token.getTipo() == 9) {
	  

	                	pilha.remove(0);
	                    pilha.add(0,"Ei");
	                    pilha.add(0,"T");
	                    pilha.add(0,token.getTermo());

	                } else if (token.getTipo() == 11) {
	                 

	                    pilha.remove(0);
	                    pilha.add(0,"Ei");
	                    pilha.add(0,"T");
	                    pilha.add(0,token.getTermo());

	           
	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) == "T") {
	                if ( token.getTipo() == 1) {
	             
	                	pilha.remove(0);
	                	pilha.add(0,"Ti");
	                	pilha.add(0,"P");

	                } else if (token.getTipo() == 5) {
	                   
	                	pilha.remove(0);
	                    pilha.add(0,"Ti");
	                    pilha.add(0,"P");

	                } else if (token.getTipo() == 12) {
	              
	                	pilha.remove(0);
	                    pilha.add(0,"Ti");
	                    pilha.add(0,"P");

	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) ==  "Ti") {
	                //fim de cadeia
                if (token == null) {
           
                	pilha.remove(0);
                } else if (token.getTipo() == 6) {
	             
	                	pilha.remove(0);

	                } else if (token.getTipo() == 8) {
	              
	                	pilha.remove(0);
	                    pilha.add(0,"Ti");
	                    pilha.add(0,"P");
	                    pilha.add(0,token.getTermo());

	                } else if (token.getTipo() == 10) {
	    

	                	pilha.remove(0);
	                    pilha.add(0,"Ti");
	                    pilha.add(0,"P");
	                    pilha.add(0,token.getTermo());

	                } else if (token.getTipo() == 9) {
	             
	                	pilha.remove(0);

	                } else if (token.getTipo() == 11) {
	

	                	pilha.remove(0);

	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) == "P") {
	                if ( token.getTipo() == 1) {

	                	pilha.remove(0);
	                    pilha.add(0,"Pi");
	                    pilha.add(0,"F");

	                } else if (token.getTipo() == 5) {
	  
	                	pilha.remove(0);
	                    pilha.add(0,"Pi");
	                    pilha.add(0,"F");

	                } else if (token.getTipo() == 12 ) {
	              
	                	pilha.remove(0);
	        
	                	pilha.add(0,"]");
	                	pilha.add(0,"F");
	                	pilha.add(0,"[");
	                	pilha.add(0,token.getTermo());
	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) == "Pi") {
	                //fim de cadeia
                 if (token == null) {
                	pilha.remove(0);
                } else if (token.getTipo() == 6) {
	         
	                	pilha.remove(0);

	                } else if (token.getTipo() == 4) {
	            
	                	pilha.remove(0);

	                } else if (token.getTipo() == 8) {
	           
	                	pilha.remove(0);

	                } else if (token.getTipo() == 10) {
	  
	                	pilha.remove(0);

	                } else if (token.getTipo() == 9) {

	                	pilha.remove(0);

	                } else if (token.getTipo() == 11) {

	                	pilha.remove(0);

	                } else if (token.getTipo() == 7) {

	                	pilha.remove(0);
	                	pilha.add(0,"Pi");
	                	pilha.add(0,"F");
	                	pilha.add(0,token.getTermo());


	                } else {
	                    erro = 1;
	                }

	            } else if (pilha.get(0) == "F") {

	                if (token.getTipo() == 1) {
	
	                	pilha.remove(0);
	                	pilha.add(0,"digito");

	                } else if (token.getTipo() == 5) {
	                	pilha.remove(0);
	                	pilha.add(0,")");
	                	pilha.add(0,"E");
	                	pilha.add(0,token.getTermo());
	                } else {
	                    erro = 1;
	                }

	                //IF DOS NAO TERMINAIS PARA FAZER O CASAMENTO
	            } else if (pilha.get(0).contains("digito")) {
	     
	                casamento.add(token.getTermo());
	            
	                pilha.remove(0);
	                obterToken();

	            } else if (pilha.get(0).contains("(")) {

	            	casamento.add(token.getTermo());
		            pilha.remove(0);
		            obterToken();

	            } else if (pilha.get(0).contains(")")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("exp")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("[")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("]")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();
	            } else if (pilha.get(0).contains("*")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("/")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("+")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("-")) {
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();

	            } else if (pilha.get(0).contains("^")) {	   
	            	 casamento.add(token.getTermo());
		                pilha.remove(0);
		                obterToken();
	            } else {
	                erro = 1;
	            }
	        }

	        if (erro == 1) {
	            throw new Error("ERRO SINTATICO");
	        } else {
	        	System.out.println(casamento);
	        	casamentos.addAll(casamento);
	        	semantico = new Semantico();
	        	semantico.semanticScan(casamento);
	        }
		
	}
	
	
	
	
	
	
	private void obterToken() {
		token = lexico.nextToken();
	
	}
	

}
