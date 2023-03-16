package arquivosEmJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {
	
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("P:\\Git-Repository\\arquivosEmJava\\arquivosEmJava\\src\\arquivosEmJava\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);  //prepara a entrada do arquivo xls do excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {
			
		}
		
	}

}
