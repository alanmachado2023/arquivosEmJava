package arquivosEmJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream entrada = new FileInputStream(new File("P:\\Git-Repository2023\\arquivosEmJava\\arquivosEmJava\\src\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);  //prepara a entrada para ler o arquivo xls
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);   //SheetAt pega a primeira planilha do arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) {   //Executa enquanto tiver linha no arquivo excel
			Row linha = linhaIterator.next();  //Dados da pessoa na linha
			Iterator<Cell> celulas = linha.iterator(); //percorre as células
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) {
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:	
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(cell.getStringCellValue());
				}
				
			}  //fim das células da linha
			
			pessoas.add(pessoa);
					
		}
		
		entrada.close();  //terminou de ler o arquivo excel
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

}
