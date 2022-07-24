package com.compilador.analisador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LexScan {
	private char[] conteudo;
	private int estado;
	private int posicao;
	
	public LexScan(String arq) {
		
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(arq));
			conteudo = (new String(bytes)).toCharArray();
		} catch (IOException e) {
	
			e.printStackTrace();
		} 
	}
	
	
	public Token nextToken() {
		
		if(isEOF()) {
			return null;
		}
		estado = 0;
		String termo = "";
		char c;
		Token token = null;
		while(true) {
			c = nextChar();
			switch(estado) {
			
			case 0:
				if(c == 'e') {
					termo += c;
					estado = 6;
				}else if(isAbreColchete(c)) {
						termo += c;
						estado = 9;
				}else if(isFechaColchete(c)){
					termo += c;
					estado = 10;
				}else if(isAbreParentese(c)){
					termo += c;
					estado = 11;
				}else if(isFechaParentese(c)){
					termo += c;
					estado = 12;
				}else if(isSoma(c)){
					termo += c;
					estado = 13;
				}else if(isVezes(c)){
					termo += c;
					estado = 14;
				}else if(isElevado(c)){
					termo += c;
					estado = 15;
				}else if(isSubtrair(c)){
					termo += c;
					estado = 16;
				}else if(isDivisao(c)){
					termo += c;
					estado = 17;
				}else if(isLetra(c)){
					termo += c;
					estado = 1;
				
				}else if (isDigito(c)){
					termo += c;
					estado = 3;
					
				}else if (isEspaco(c)){
					termo += c;
					estado = 5;
				}else {
					throw new RuntimeException("token nao reconhecido");
				}
				break;
			case 1:
				if(isLetra(c) || isDigito(c)) {
					termo += c;
					estado = 1;
				}else {
					estado = 2;
					termo += c;
				}
				break;
			case 2:
				token = new Token();
				token.setTipo(Token.IDENT);
				token.setTermo(termo);
				back();
				return token;
			case 3:
				if(isDigito(c)) {
					termo += c;
					estado = 3;
				}else if(isFechaColchete(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isFechaParentese(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isSoma(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isVezes(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isElevado(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isSubtrair(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(isDivisao(c)){
					token = new Token();
					token.setTipo(Token.NUMERO);
					token.setTermo(termo);
					back();
					return token;
				}else if(!isLetra(c) && !isEspaco(c)) {
					termo += c;
					estado = 4;
				}else if(isEspaco(c)) {
					
					estado = 4;
				
				}else {
					throw new RuntimeException("número nao reconhecido");
				}
				break;	
			case 4:
		
				token = new Token();
				token.setTipo(Token.NUMERO);
				token.setTermo(termo);
				back();
				return token;
			
			case 5:
				if(isEOF()) {
					return null;
				}
				if(isEspaco(c)) {
				
					estado = 5;
				}else {
					token = new Token();
					token.setTipo(Token.ESPACO);
					token.setTermo(termo);
					back();
					return token;
				}
				break;
			case 6:
				if(c == 'x') {
					termo += c;
					estado = 7;
				}else {
					termo += c;
					estado = 1;
				}
				break;
			case 7:
				if(c == 'p') {
					termo += c;
					estado = 8;
				}else {
					termo += c;
					estado = 1;
				}
				break;
			case 8:
				if(isLetra(c) || isDigito(c)) {
					termo += c;
					estado = 1;
				}else {
					token = new Token();
					token.setTipo(Token.EXP);
					token.setTermo(termo);
					back();
					return token;
				}
				break;
			case 9:
				if(isLetra(c)) {
					termo += c;
					estado = 1;					
				}else {
					token = new Token();
					token.setTipo(Token.ABRECOLCHETE);
					token.setTermo(termo);
					back();
					return token;
				}
				break;
			case 10:
				token = new Token();
				token.setTipo(Token.FECHACOLCHETE);
				token.setTermo(termo);
				back();
				return token;
			case 11:
				token = new Token();
				token.setTipo(Token.ABREPARENTESE);
				token.setTermo(termo);
				back();
				return token;
			case 12:
				token = new Token();
				token.setTipo(Token.FECHAPARENTESE);
				token.setTermo(termo);
				back();
				return token;
			case 13:
				token = new Token();
				token.setTipo(Token.SOMA);
				token.setTermo(termo);
				back();
				return token;
			case 14:
				token = new Token();
				token.setTipo(Token.VEZES);
				token.setTermo(termo);
				back();
				return token;
			case 15:
				token = new Token();
				token.setTipo(Token.ELEVADO);
				token.setTermo(termo);
				back();
				return token;
			case 16:
				token = new Token();
				token.setTipo(Token.SUBTRAIR);
				token.setTermo(termo);
				back();
				return token;
			case 17:
				token = new Token();
				token.setTipo(Token.DIVISAO);
				token.setTermo(termo);
				back();
				return token;
				
				
			}
			
			
		}
	}
	
	private boolean isLetra(char c) {
		return (c>='a' && c<='z') || (c>='A' && c<='Z');
					
	}
	
	private boolean isDigito(char c) {
		return (c>='0' && c<='9') ;
					
	}
	
	private boolean isEspaco(char c) {
		return c==' '|| c=='\n' || c=='\t';
					
	}
	private boolean isVezes(char c) {
		return c=='*';
					
	}
	private boolean isElevado(char c) {
		return c=='^';
					
	}
	private boolean isSoma(char c) {
		return c=='+';
					
	}
	private boolean isSubtrair(char c) {
		return c=='-';
					
	}
	private boolean isDivisao(char c) {
		return c=='/';
					
	}
	private boolean isAbreColchete(char c) {
		return c=='[';
					
	}
	private boolean isFechaColchete(char c) {
		return c==']';
					
	}
	private boolean isAbreParentese(char c) {
		return c=='(';
					
	}
	private boolean isFechaParentese(char c) {
		return c==')';
					
	}
	private boolean isExp(char c) {
		return c==')';
					
	}
	private boolean isEOF() {
		return posicao == conteudo.length ;
					
	}
	
	private char nextChar() {
		if(isEOF()) {
			return 0;
		}else {
		return conteudo[posicao++];
		}
	}
	
	private void back() {
		if(!isEOF()) {
		 posicao-- ;
		}	
	}
}
