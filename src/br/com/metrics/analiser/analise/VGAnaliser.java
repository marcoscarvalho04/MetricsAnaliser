package br.com.metrics.analiser.analise;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.metrics.analiser.common.FileUtils;
import br.com.metrics.analiser.exception.PathViolationExcepton;


public class VGAnaliser extends MetricAnaliser {

	@Override
	public void analisarMetrica(String metrica, Element elementos) {
		StringBuilder arquivo = new StringBuilder();
		if(metrica.equalsIgnoreCase("VG")){
			NodeList lista = elementos.getElementsByTagName("Value");
			for(int a = 0; a < lista.getLength(); a++){ 
				Node noValue = lista.item(a);
				if(noValue.getNodeType() == Node.ELEMENT_NODE){
					Element elementoValue = (Element) noValue;
					arquivo.append("Classe: "+elementoValue.getAttribute("source")+"\n");
					arquivo.append("Método: "+elementoValue.getAttribute("name")+"\n");
					
					
					
				}
			}
			try {
			String arquivoFinal = arquivo.toString();
			FileUtils fileUtils = new FileUtils();
			fileUtils.escreverArquivo(arquivoFinal.getBytes(), "C:\\metricas\\vg.txt");
			}catch(PathViolationExcepton e){
				e.printStackTrace();
			}
		}
		
	}



}
