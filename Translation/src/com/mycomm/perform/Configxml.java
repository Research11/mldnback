package com.mycomm.perform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Configxml {
		
		public void readFile(String site) throws Exception{
			
			
		Set<String> set=new HashSet<String>();
		File configFile=new File("src/language.properties");
		FileReader fr=new FileReader(configFile);
		Properties prop=new Properties();
		prop.load(fr);          		
		File configFile1=new File("src/reports_Chinese.Properties");
		FileReader fr1=new FileReader(configFile1);
		Properties prop1=new Properties();
	 	prop1.load(fr1);
	 	
	 	File configFile2=new File("src/report_English.Properties");
		FileReader fr2=new FileReader(configFile2);
		Properties prop2=new Properties();
		prop2.load(fr2);        	 	
		String language=prop.getProperty("language");
		if(language.equals("en")){        			
			set=prop1.stringPropertyNames();       			
		}else{        			       			
			set=prop2.stringPropertyNames();       			
		}
		SAXReader reader=new SAXReader();
		try {
			Document doc=reader.read("WebRoot/WEB-INF/resources/config.xml"); //WebPageContent
			List<?> textlist=doc.selectNodes(site);//"ReportServerParameter/ReportWebAttr/WebWriteContent/ToolBars/ToolBarManager/ToolBar/Widget/Text"
			for(Object obj:textlist){
				Element textelement=(Element)obj;
				String text=textelement.getTextTrim();				
				for(String str:set){//1.是中文  2.是英文
					if(prop1.getProperty(str).equals(text)&&language.equals("en")){
						Element Telement=textelement.getParent().addElement("Text");
						Telement.addCDATA(prop2.getProperty(str));
						textelement.getParent().remove(textelement);
					}
					if(prop2.getProperty(str).equals(text)&&language.equals("zh")){
						Element Telement=textelement.getParent().addElement("Text");
						Telement.addCDATA(prop1.getProperty(str));
						textelement.getParent().remove(textelement);
					}		
			}
			}
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("UTF-8");  	          
	        XMLWriter writer;       			
				writer = new XMLWriter(new FileOutputStream("WebRoot/WEB-INF/resources/config.xml"),format);
				 writer.write(doc);  
			        writer.close(); 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


