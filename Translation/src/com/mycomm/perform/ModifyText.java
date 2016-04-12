package com.mycomm.perform;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;
	import java.util.Set;

	import org.dom4j.Document;
	import org.dom4j.DocumentException;
	import org.dom4j.Element;
	import org.dom4j.io.OutputFormat;
	import org.dom4j.io.SAXReader;
	import org.dom4j.io.XMLWriter;
	public class ModifyText {

		/*public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			String filePath = "WebRoot/WEB-INF/reportlets/C8_1_mysql/";
		       getFiles(filePath,"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/Text"); 
		}*/
				

	private static ArrayList<String> filelist = new ArrayList<String>(); 

	   public void readFile(String site) throws Exception{
		   String filePath = "WebRoot/WEB-INF/reportlets/C8_1_mysql/";
	       getFiles(filePath,site); 
	   }    
	     //通过递归得到某一路径下所有的目录及其文件    
	    public static void getFiles(String filePath,String site) throws IOException{   	
	        File root = new File(filePath);
	        File[] files = root.listFiles();
	        System.out.println(files.length);
	        for ( File file : files ){        	
	            if ( file.isDirectory() ){                
	                 //递归调用                 
	                getFiles( file.getAbsolutePath(),site);
	                filelist.add( file.getAbsolutePath() );             
	            }else{
	            	String str1=file.getAbsolutePath().substring(24);                	
	            	System.out.println(str1);              
	            	Set<String> set=null;
	        		Properties prop1=null;        		
	        		SAXReader reader = new SAXReader();  
	    	        Document doc=null;    	        
	        		File configFile=new File("src/language.properties");
	        		FileReader fr=new FileReader(configFile);
	        		Properties prop=new Properties();
	        		prop.load(fr);          		
	        		File configFile1=new File("src/reports_Chinese.Properties");
	        		FileReader fr1=new FileReader(configFile1);
	        		prop1=new Properties();
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
	        		try {        			       			
	        			doc = reader.read(str1);        			 
	        			List list = doc.selectNodes(site);//"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/O"
	        			for(int i=0; i<list.size();i++){        				    
	        				Element el = (Element)list.get(i);
	        				String str=el.getText().trim();
	        				/*BufferedWriter bw=new BufferedWriter(new FileWriter("E:/File/test.txt",true));
	        				if(str!=null){
	        					bw.newLine();
	        					bw.write(str);       					
	        					bw.flush();
	        					bw.close();
	        				}*/ 
	        				for(String st:set){       						
	        					if(prop1.getProperty(st).equals(str)&&language.equals("en")&&prop1.getProperty(st)!=null){	//1.是中文   2.是英文        						        						
	        						Element book=el.getParent().addElement("Text");	               
	        		        		book.addCDATA(prop2.getProperty(st));
	        		        		el.getParent().remove(el);
	        						break;
	        					}
	        					if(prop2.getProperty(st).equals(str)&&language.equals("zh")&&prop2.getProperty(st)!=null){       						      						
	        						Element book=el.getParent().addElement("Text");	               
	        		        		book.addCDATA(prop1.getProperty(st));
	        		        		el.getParent().remove(el);
	        						break;
	        					}
	        					
	        				}        				
	        			}
	        			//保存文件
	        			OutputFormat format = OutputFormat.createPrettyPrint();  
	        	        format.setEncoding("UTF-8");  	          
	        	        XMLWriter writer;       			
	        				writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(str1),"UTF-8"));
	        				 writer.write(doc);  
	        			        writer.close();        			
	        		} catch (IOException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	            }
	        }       
	    }
	}

