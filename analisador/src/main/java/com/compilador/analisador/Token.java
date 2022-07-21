package com.compilador.analisador;

public class Token {
	
	public static final int IDENT = 0;
	public static final int NUMERO = 1;
	public static final int ESPACO = 2;
	public static final int ABRECOLCHETE = 3;
	public static final int FECHACOLCHETE = 4;
	public static final int ABREPARENTESE = 5;
	public static final int FECHAPARENTESE = 6;
	public static final int ELEVADO = 7;
	public static final int VEZES = 8;
	public static final int SOMA = 9;
	public static final int DIVISAO = 10;
	public static final int SUBTRAIR = 11;
	public static final int EXP = 12;
	
private int tipo;
private String termo;
public int getTipo() {
	return tipo;
}
public void setTipo(int tipo) {
	this.tipo = tipo;
}
public String getTermo() {
	return termo;
}
public void setTermo(String termo) {
	this.termo = termo;
}

@Override
public String toString(){
	return	"Token["+ tipo +","+ termo +"]";
	
	
}

}
