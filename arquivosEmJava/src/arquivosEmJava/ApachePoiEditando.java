package arquivosEmJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {
	
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("P:\\Git-Repository2023\\arquivosEmJava\\arquivosEmJava\\src\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);  //prepara a entrada do arquivo xls do excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {  //Enquanto tiver linha executa
			Row linha = linhaIterator.next();  // Dados da pessoa na linha
			
			/*
			int numeroCelulas = linha.getPhysicalNumberOfCells(); //quantidade de células
			
			
			Cell cell = linha.createCell(numeroCelulas); // cria nova célula na linha
			cell.setCellValue("5.487,20");
		    */
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue(valorCelula + " * valor gravado na aula");
			
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha Atualizada");
	}

}
