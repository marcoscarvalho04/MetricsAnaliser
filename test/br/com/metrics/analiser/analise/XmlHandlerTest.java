package br.com.metrics.analiser.analise;

import org.junit.*;

public class XmlHandlerTest {

	@Test
	public void printarTags(){
		XmlHandler xmlHandler = new XmlHandler();
		Assert.assertNotNull(xmlHandler.lerXml());
	}
}
