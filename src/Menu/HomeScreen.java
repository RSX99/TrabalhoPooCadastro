package Menu;

import Users.UserData;
import Data.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
// INCOMPLETO 
public class HomeScreen implements Data { //MENU E TELA INICIAL
	
	ArrayList<String> register = new ArrayList<String>(); // ARRAY DE PRODUTOS
	UserData user = new UserData();
	DecimalFormat df = new DecimalFormat();
	String a = "";// ONDE SERA ARMAZENADOS AS LISTAS
	float pt = 0; // PRECO TOTAL
	int cp = 0;// CONTATOD DO CODIGO DO PRODUTO
	
	public void Home(){ //CRIANDO O MENU
				
		
					
		byte OPTION = 0;
				
		Scanner op = new Scanner(System.in);
		
            while(OPTION!=6){
            	
			System.out.println();
			System.out.println();
			System.out.println("*********************************");
			System.out.println("*     	  Programa Cadastro     *");
			System.out.println("*         de Produtos           *");
			System.out.println("*********************************");
			System.out.println();
			System.out.println("[1]..................Cadastrar Produtos");
			System.out.println("[2]..................Lista de Produtos");
			System.out.println("[3]..................Salvar em Arquivo");
			System.out.println("[4]..................Carregar arquivo Salvo");
			System.out.println("[5]..................Deletar Lista");
			System.out.println("[6]..........................Sair     ");
	
			System.out.println();
			System.out.println("Escolha uma opcao: ");
			OPTION = op.nextByte();
			
			if(OPTION!=6){
				
				switch(OPTION){
				
				case 1: Register();	break; // CADASTRAR
				case 2: ListUser(); break; // LISTAR ITENS
				case 3: Save();     break; // SALVAR ARQUIVO
				case 4: Load();     break; // CARREGAR O ARQUIVO
				case 5: DeleteList(); break; // PESQUISAR PRODUTO POR NOME
				}
				
			}
		
             }
	
		
	}
	
	public void Register(){ // REGISTRAR PRODUTOS
		
		
	
		Scanner s = new Scanner(System.in);
		
		System.out.println("\nDigite o nome do Produto: ");
		user.setProduct(s.nextLine().toUpperCase());
		System.out.println("\nDigite o preco: R$ ");
		user.setValue(s.nextLine());
		System.out.println("\nDigite o Peso: ");
		user.setWeight(s.nextLine());
		System.out.println("\nDigite o Codigo: ");
		user.setCode(s.nextLine());
		 a = " \nProduto: " + user.getProduct() + " : \nPreco: " + user.getValue() + " : \nPeso: " + user.getWeight() + " : \nCodigo: " + user.getCode() + "\n============================\n"; 
		register.add(a);
		
		pt += Float.valueOf(user.getValue()).floatValue();
		
		
		pause();
		Clear();
			
	}
	
	public void Save(){ // SALVAR EM ARQUIVO TEXTO
		String na = ""; // nome do arquivo digitado pelo usuario
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do arquivo: ");
		na = s.nextLine();
		
		File folder = new File ("/");
		File file = new File ( na + ".txt" );
		
		folder.mkdir();
		
		try{
		file.createNewFile();
		
		FileWriter salvar = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(salvar);
		
		for (int v = 0 ; v < register.size(); v++){
			
			bw.write(register.get(v).toString());
			bw.newLine();
		}
		
		
		 bw.close(); // FECHA O ARQUIVO
		 
		 salvar.close();
		 System.out.println("Arquivo salvo com sucesso! \n\n");
		 
		 pause();
		 Clear();
		
	}catch(IOException e){
		
		System.out.println("Erro ao Gravar o arquivo: " + e);
	}
	}
	
	public void Load(){
		String na = "";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do arquivo: ");
		na = s.nextLine();
		
		
		File folder = new File ("/");
		File file = new File ( na + ".txt" );
		
		try{
			
		FileReader ler = new FileReader(file);
		BufferedReader br = new BufferedReader(ler);
		String linha = br.readLine();
		 while(linha!=null){
		    	
		    	System.out.println(linha);
		    	linha = br.readLine();
		    	
			    
		    	
		 }
		
		}catch(IOException e){
			
			System.out.println("\n\n Erro na leitura do arquivo! " + e);
		}
		
		pause();
		Clear();
	}
	
	
	
	
	public static void pause(){ //METODO PAUSAR A TELA
		byte ENTER;
		 System.out.println();
		 System.out.println("Tecle <ENTER> para retornar ao menu: ");
		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 ENTER = Byte.parseByte(br.readLine());
		 
		 }
		 catch(Exception e){
			 ENTER = 0;
			 
		 }
	}
	public void Clear(){ // METODO PARA LIMPAR A TELA
		
		for (int c = 0 ; c<999 ; c++){
			
			System.out.println("                                                                                        ");
			
			
		}
		
		
	}
	
	public void ListUser(){ // LISTANDO PRODUTOS
		
		if (register.contains(a)){// VERIFICA SE EXISTE REGISTRO
			
			for(String current : register){
			 
				System.out.println(current);
	
		
			}
			df.applyPattern("0.00");
			System.out.println( register.size()+ " Produtos cadastrados.");
			System.out.println("\nValor total de produtos:R$ " + df.format(pt));
		}else
		{
			System.out.println("Nenhum produto registrado!");
		}
		
		pause();
		Clear();
		
		

		
	}
	
	public void DeleteList(){ // TEMPORARIO
		
		register.remove(a);
		
		
		System.out.println("Lista deletata com sucesso!");
		pause();
		Clear();
	    	}
	    	
	    	
	    	
	    	

		
		
	}
	
	
	
	
	
	
	
    

