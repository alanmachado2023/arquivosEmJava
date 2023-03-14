package arquivosEmJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileInputStream entradaDeDados = new FileInputStream(new File("P:\\Workspace\\Eclipese_Java\\arquivosEmJava\\src\\Arquivo.csv")); //basta mudar o nome ou formato do arquivo para ler outros arquivos
		
		
		Scanner lerArquivo = new Scanner(entradaDeDados, "UTF-8");  //Usa o Scanner 'File Source, Charset' para colcoar tbm a codificação UTF. 
	
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			if (linha != null && !linha.isEmpty()) {  //isEmpty == se vazia
				String[] dados = linha.split("\\;");  //divide a String em várias subStrings com base da divisão por ';' e cria um array com elas. Pode ser qualquer delimitador
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(dados[2]);
				
				pessoas.add(pessoa);
				
							
			}
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
			
		
		}
	
	}

}
