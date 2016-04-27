package br.com.metrics.analiser.common;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import br.com.metrics.analiser.exception.PathViolationExcepton;
import br.com.metrics.analiser.exception.ExceptionHandler;

public class FileUtilsTest {
	
	@Test
	public void testarArquivoNormal() {
		try{
		FileUtils fileUtils = new FileUtils();
		String teste = new String();
		teste = "teste";
		Assert.assertEquals(true,fileUtils.escreverArquivo(teste.getBytes(), "C:\\teste\\teste.txt"));
		Scanner arquivo = new Scanner(fileUtils.lerArquivo("C:\\teste\\teste.txt"));
		Assert.assertNotNull(arquivo);
		String conteudo = arquivo.nextLine();
		Assert.assertEquals("teste", conteudo);
		}catch(PathViolationExcepton e){
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
		}catch(FileNotFoundException e){
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
		}
	}
	@Test
	public void testarDiretorioComProblema(){
		try{
			FileUtils fileUtils = new FileUtils();
			String teste = new String();
			teste = "teste";
			fileUtils.escreverArquivo(teste.getBytes(), "C:\\teste/*teste.txt");
			}catch(PathViolationExcepton e){
				e.printStackTrace();
				ExceptionHandler.logarExcecao(e.getStackTrace().toString());
				Assert.assertNotNull(e.getStackTrace().toString());
			}
	}

}
