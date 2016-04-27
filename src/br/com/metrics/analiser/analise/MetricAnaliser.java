package br.com.metrics.analiser.analise;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class MetricAnaliser {

	public void iniciarAnalise(){
		XmlHandler xmlHandler = new XmlHandler();
		Document doc = xmlHandler.lerXml();
		NodeList listaMetric = doc.getElementsByTagName("Metric");
		
		for(int a = 0; a < listaMetric.getLength(); a++){
			Node listaNos = listaMetric.item(a);
			if(listaNos.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) listaNos;
				String metrica = element.getAttribute("id");
				NodeList listaNosValues = element.getElementsByTagName("Values");
				for(int b = 0; b < listaNosValues.getLength(); b++){
					Node noValue = listaNosValues.item(0);
					if(noValue.getNodeType() == Node.ELEMENT_NODE){
						Element elementNo = (Element) noValue;
						this.analisarMetrica(metrica, elementNo);
					}
				}
				
				
			}
		}
		
	}
	
	public abstract void analisarMetrica(String metrica, Element elementos);
}
