package br.com.metrics.analiser.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import br.com.metrics.analiser.exception.PathViolationExcepton;
import br.com.metrics.analiser.exception.ExceptionHandler;


public class FileUtils {
	/*Classe: FileUtils.
	 * 
	 * Função: Utilitária. Serve para fazer algumas coisas
	 * em comum nas classes sempre relacionada a escrita
	 * e leitura de arquivos.
	 * 
	 * */
	
	// Sem muitos comentários. Lê e retorna o arquivo usando a classe File. 
	public File lerArquivo(String path) throws FileNotFoundException{
		File arquivo = new File(path);
		if(!arquivo.exists()) {
			throw new FileNotFoundException();
		}
		return arquivo;
	}
	
	public boolean escreverArquivo(byte[] arquivo,String path) throws PathViolationExcepton{
		try {
			File file = new File(path);
			if (!file.exists()) {
				String diretorio = file.getAbsolutePath();
				String diretorioFormatado = diretorio.substring(0, diretorio.lastIndexOf('\\'));
				if (diretorioFormatado == null) {
					diretorioFormatado = diretorio.substring(0, diretorio.lastIndexOf('/'));
					if (diretorioFormatado == null) {
						throw new PathViolationExcepton(
								"Impossível fazer o diretório.\n Revise os parâmetros e tente novamente.");
					}
				}
				File fileDiretorio = new File(diretorioFormatado);
				if (!fileDiretorio.exists())
					if (!fileDiretorio.mkdirs()) {
						throw new PathViolationExcepton(
								"Não foi possível fazer o diretório. \n Revise as permissões no mesmo e tente novamente");

					}

			}
			BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream(file));
			for (int a = 0; a < arquivo.length; a++) {
				fw.write(arquivo[a]);
			}
			fw.close();
			return true;
		} catch (IOException e) {
			System.err.println("Saída de erro no console: ");
			ExceptionHandler.logarExcecao((e.getStackTrace().toString()));
			return false;
		}

	}

	}
	
	

	


