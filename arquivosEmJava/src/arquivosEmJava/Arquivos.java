package arquivosEmJava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	
	public static void main(String[] args) throws IOException {
		
		
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
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
				
		
		File arquivo = new File("P:\\Git-Repository\\arquivosEmJava\\arquivosEmJava\\src\\Arquivo.txt");  //atribui um local para o arquivo ser gerado | basta mudar o formato do arquivo
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);    //objeto de escrever no arquivo
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome()+ ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
			
		escrever_no_arquivo.flush();   //força os dados serem escritos e disponibilizados
		escrever_no_arquivo.close();   //fecha o arquivo
		
		
	}

}
