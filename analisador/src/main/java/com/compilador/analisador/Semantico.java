package com.compilador.analisador;

import java.util.ArrayList;
import java.util.List;

public class Semantico {
	
	
	public void semanticScan(List<String> casamento) {
		List<String> resolvido = new ArrayList<>();
		resolvido = resolverParentese(casamento);
		resolvido = resolver(resolvido);
			  
	  System.out.println(resolvido.toString());
	  
	 
	}
	
	private List<String> resolverParentese(List<String> casamento) {
		
	List<String> entreParentese = new ArrayList<>();
		
		for (int i = 0; i < casamento.size(); i++) {
			
			 if (casamento.contains("(")) {	
				 
				 for (int j = 0; j < casamento.size(); j++) {
					 
						if(casamento.get(j).contains("(") ) {
							// faz chamada recursiva para calcular
							int l=j+1;
							do {
													
							
							entreParentese.add(casamento.get(l));
							casamento.remove(l);
							
							}while(!casamento.get(l).contains(")"));
							 entreParentese =  resolver(entreParentese);
							//remove parenteses
							casamento.remove(j);
							casamento.remove(j);
							//remove parenteses
				      		casamento.add(j,entreParentese.get(0));
							i = 0;
						}
					}
			 
			 }
			 
		}
		
		
		return casamento ;
		
	}
	
	
	private List<String> resolver(List<String> casamento) {
		
		for (int i = 0; i < casamento.size(); i++) {
			  
			  if (casamento.contains("exp")) {	
				for (int j = 0; j < casamento.size(); j++) {
					if(casamento.get(j).contains("exp") ) {
						
						int var1 = Integer.parseInt(casamento.get(j+2));	     
			      		int res =  (int) Math.exp(var1);
			      		casamento.remove(j);
			      		casamento.remove(j);
			      		casamento.remove(j+1);
			      		casamento.remove(j);
			      		casamento.add(j,String.valueOf(res));
			      		i = 0;
					}
				}
			  }
			  
			  if (casamento.contains("^")) {	
					for (int j = 0; j < casamento.size(); j++) {
						if(casamento.get(j).contains("^") ) {
							
							int var1 = Integer.parseInt(casamento.get(j-1));	     
							int var2 = Integer.parseInt(casamento.get(j+1));
				      		int res = (int) Math. pow(var1,var2);
				      		
				      		casamento.add(j,String.valueOf(res));
				      		casamento.remove(j-1);
				      		casamento.remove(j+1);
				      		casamento.remove(j);
				      		i = 0;
						}
					}
				  }
			  
			  if (casamento.contains("*")) {	
					for (int j = 0; j < casamento.size(); j++) {
						if(casamento.get(j).contains("*") ) {
							
							int var1 = Integer.parseInt(casamento.get(j-1));
				      		int var2 = Integer.parseInt(casamento.get(j+1));
				      		int res = var1 * var2;
				      		casamento.add(j,String.valueOf(res));
				      		casamento.remove(j-1);
				      		casamento.remove(j+1);
				      		casamento.remove(j);
				      		i = 0;
						}
					}
				  }
			  if (casamento.contains("/")) {	
					for (int j = 0; j < casamento.size(); j++) {
						if(casamento.get(j).contains("/") ) {
							
							int var1 = Integer.parseInt(casamento.get(j-1));
				      		int var2 = Integer.parseInt(casamento.get(j+1));
				      		int res = var1 / var2;
				      		casamento.add(j,String.valueOf(res));
				      		casamento.remove(j-1);
				      		casamento.remove(j+1);
				      		casamento.remove(j);
				      		i = 0;
						}
					}
			  	}
					
					  if (casamento.contains("+")) {	
							for (int j = 0; j < casamento.size(); j++) {
								if(casamento.get(j).contains("+") ) {
									
									int var1 = Integer.parseInt(casamento.get(j-1));
						      		int var2 = Integer.parseInt(casamento.get(j+1));
						      		int res = var1 + var2;
						      		casamento.add(j,String.valueOf(res));
						      		casamento.remove(j-1);
						      		casamento.remove(j+1);
						      		casamento.remove(j);
						      		i = 0;
								}
							}
						  }
					  
					  
					  if (casamento.contains("-")) {	
							for (int j = 0; j < casamento.size(); j++) {
								if(casamento.get(j).contains("-") ) {
									
						      		int var1 = Integer.parseInt(casamento.get(j-1));
						      		int var2 = Integer.parseInt(casamento.get(j+1));
						      		int res = var1 - var2;
						      		casamento.add(j,String.valueOf(res));
						      		casamento.remove(j-1);
						      		casamento.remove(j+1);
						      		casamento.remove(j);
						      		i = 0;
								}
							}
						  }
		
		}
		return casamento;
		
	}
	
}
