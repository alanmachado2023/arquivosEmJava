package arquivosEmJava;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("03156120352");
		usuario1.setLogin("pedro01");
		usuario1.setSenha("123456");
		usuario1.setNome("Pedro Pedrosa");

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("01235465485");
		usuario2.setLogin("Roberta01");
		usuario2.setSenha("654321");
		usuario2.setNome("Roberta Robertina");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //formata o código json
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("P:\\Git-Repository2023\\arquivosEmJava\\arquivosEmJava\\src\\filejson.json");
		
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		
		/*--------------------------------------LENDO O ARQUIVO JSON--------------------------------------*/
		
		
		FileReader fileReader = new FileReader ("P:\\Git-Repository2023\\arquivosEmJava\\arquivosEmJava\\src\\filejson.json");  //lê o arquivo JSON
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);   //cria o array de JSON. Coloca os dados em posições
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();   //cria a lista de array do usuario
		
		for (JsonElement jsonElement : jsonArray) {    //faz um for para adicionar cada elemento do array na variável 
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);  //convertendo o array de JSON para um objeto do tipo Usuario
			listUsuarios.add(usuario);    //adiciona à lista
		}
		
		System.out.println("Leitura do arquivo JSON: " + listUsuarios);
	}

}
