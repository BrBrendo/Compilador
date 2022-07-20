package com.compilador.analisador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LexScan {
	private char[] conteudo;
	
	public LexScan(String arq) {
		
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(arq));
		} catch (IOException e) {
	
			e.printStackTrace();
		} 
	}

}
