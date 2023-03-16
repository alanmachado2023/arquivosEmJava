package arquivosEmJava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	
	public static void main(String[] args) throws Exception {
		
		
		File file = new File("P:\\Git-Repository\\arquivosEmJava\\arquivosEmJava\\src\\arquivosEmJava\\arquivo_excel.xls");
		
		if (file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade("50");
		pessoa1.setNome("Alan Machado");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade("25");
		pessoa2.setNome("Marcos Tadeu");
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade("40");
		pessoa3.setNome("Maria Jesus");
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setIdade("40");
		pessoa4.setNome("Paulo Pedro");
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();   //usado para escrever a planilha. Hss do apache.poi
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev"); //cria a planilha
		
		
		int numeroLinnha = 0;
		
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinnha++);  //criando linha na planilha. Row cria linha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);  //cria a celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);  // cria a celula 2
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);  //cria a celula 3
			celIdade.setCellValue(p.getIdade());			
		
		}//terminou de montar a planilha
		
		FileOutputStream saida = new FileOutputStream(file); // atribui os novos dados de saída da variável file para a variável saida
		hssfWorkbook.write(saida);  // escreve os dados de saída na planilha em arquivo
		saida.flush();  //força os dados a serem gravados
		saida.close(); //fecha o arquivo
		
		System.out.println("Planilha foi criada");
		
		
	}

}
