package com.mycomm.perform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Comprehensive {	
	String [] label={"WorkBook/Report/CellElementList/C/HighlightList/Highlight/Name",
			"WorkBook/Report/CellElementList/C/O",
			"WorkBook/Report/CellElementList/C/O/Chart/Chart/Title/O",
			"WorkBook/TableDataMap/TableData/Parameters/Parameter/O",
			"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/O",
			"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/Dictionary/CustomDictAttr/Dict",
			"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/Text",
			"ReportServerParameter/ReportWebAttr/WebWriteContent/ToolBars/ToolBarManager/ToolBar/Widget/Text",
			"ReportServerParameter/ReportWebAttr/WebPageContent/ToolBars/ToolBarManager/ToolBar/Widget/Text",
			"WorkBook/ReportParameterAttr/PWTitle",
			"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/EMSG",
			"WorkBook/Report/CellElementList/C/O/MoreNameCDDefinition/ChartSummaryColumn",
			"WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/WidgetName"};
@Test
public void Translation() throws Exception{
	
	Set<String> set=new HashSet<String>();
	BufferedReader br=new BufferedReader(new FileReader("E:/File/test.txt"));
	BufferedWriter bw=new BufferedWriter(new FileWriter("E:/File/test02.txt"));	
	Modify modify=new Modify();
	UpdateName update=new UpdateName();
	ModifyValue modifyvalue=new ModifyValue();
	ModifyText modifytext=new ModifyText();
	Configxml configxml=new Configxml();
	//ModifyKey modifyKey=new ModifyKey();
	ModfiyPWtitle modfiyPwtitle=new ModfiyPWtitle();
	ModifyEMSG modifyEMSG=new ModifyEMSG();
	ModifycustomName modifycustomName=new ModifycustomName();
	ModifyName modifyName=new ModifyName();
	for(int k=0;k<label.length;k++){
		
		if(label[k].equals("WorkBook/Report/CellElementList/C/HighlightList/Highlight/Name")){					
				try {			
					update.readFile(label[k]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		if(label[k].equals("WorkBook/Report/CellElementList/C/O")){	
			try {
				modify.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(label[k].equals("WorkBook/Report/CellElementList/C/O/Chart/Chart/Title/O")){	
			try {
				modify.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(label[k].equals("WorkBook/TableDataMap/TableData/Parameters/Parameter/O")){	
			try {
				modify.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(label[k].equals("WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/O")){			
			try {
				modify.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		if(label[k].equals("WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/Dictionary/CustomDictAttr/Dict")){					
			try {
				modifyvalue.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
		
		if(label[k].equals("WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/Text")){					
			try {
				modifytext.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}		
		if(label[k].equals("ReportServerParameter/ReportWebAttr/WebPageContent/ToolBars/ToolBarManager/ToolBar/Widget/Text")){					
			try {
				configxml.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
		if(label[k].equals("ReportServerParameter/ReportWebAttr/WebWriteContent/ToolBars/ToolBarManager/ToolBar/Widget/Text")){					
			try {
				configxml.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
		if(label[k].equals("WorkBook/ReportParameterAttr/PWTitle")){					
			try {
				modfiyPwtitle.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}				
		if(label[k].equals("WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/EMSG")){					
			try {
				modifyEMSG.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(label[k].equals("WorkBook/Report/CellElementList/C/O/MoreNameCDDefinition/ChartSummaryColumn")){					
			try {
				modifycustomName.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(label[k].equals("WorkBook/ReportParameterAttr/ParameterUI/CellElementList/C/Widget/WidgetName")){					
			try {
				modifyName.readFile(label[k]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	String str;
	
		while((str=br.readLine())!=null){
			
			set.add(str);
		}
	 							
   		for(String content:set){
   			bw.newLine();
   			bw.write(content);
   			bw.flush();
   		}
   		bw.close();
   		br.close();
  }
}
