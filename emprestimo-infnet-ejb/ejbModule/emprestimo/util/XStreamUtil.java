package emprestimo.util;


import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {
	
	private static XStreamUtil instance = null;
	private XStream xs;
	
	private XStreamUtil(){
		xs = new XStream(new DomDriver());		
	}
	
	
	public static XStreamUtil getIntance() {
		if(instance == null){
			instance = new XStreamUtil();
		}
		return instance;
	}
	
	public String toXml(Object obj){
		if(obj == null) return null;
		StringWriter sw = new StringWriter();
		xs.marshal(obj,  new CompactWriter(sw));
		return sw.toString();
	}

}
