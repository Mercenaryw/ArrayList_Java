import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

import java.io.IOException;

public class Menu
{
	static ArrayList<String> ln = new ArrayList<>();
	static Scanner tecla=new Scanner(System.in);
	static String nome;
	static int i=0;
	
	//______________________________________________________________

	public static void Cadastrar()
	{	
		while(true)
		{
			if(!ln.isEmpty())
			{
			Collections.sort(ln);//crescente
			Collections.reverse(ln);//decrescente
			Mostrar();
			}
			nome="";
			System.out.print("\nDigite um Nome ou ENTER para finalizar:\n");
			nome=tecla.nextLine();
			if(nome.equals(""))break;
			ln.add(nome);
			GravarArquivo();
		}//while
	}

	//___________________________________________________________

	public static void Alterar()
	{
		System.out.print("\nAlterar nomes da lista\n");
		while(true)
		{
			if(!ln.isEmpty())
			{
				Collections.sort(ln);//crescente
				Collections.reverse(ln);//decrescente
				Mostrar();
			}
			nome="";
			while(true)
			{
				System.out.print("\n Digite qual numero para alterar(0=fim)?");
				i=tecla.nextInt();
				if(i>=0 && i<=ln.size())break;
			}
			if(i==0)break;
			nome=""; tecla.nextLine();//limpa buffer teclado
			System.out.print("\n Digite novo Nome:");
			nome=tecla.nextLine();
			ln.set(i-1,nome);
			GravarArquivo();
		}
	}

	//___________________________________________________________

	public static void Excluir()
	{
		Mostrar();
		System.out.println("Digite qual numero deseja excluir: \n");
		i=tecla.nextInt();
		ln.remove(i-1);
		GravarArquivo();
		Mostrar();
	}

	//___________________________________________________________

	public static void Mostrar()
	{
		if(ln.isEmpty())
		{
			System.out.println("Lista Vazia!");
		}
		else
		{
			System.out.print("\nLista de nomes:\n\n");
			for(i=0;i<ln.size();i++)
			{
				System.out.println((i+1)+"-"+ln.get(i)+"\n");
			}
		}
	}

//___________________________________________________________
public static void BarraCarregamento()
{
	String anim= "|/-\\";
    for (int x =0 ; x <= 100 ; x++) 
    {
		String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
		//System.out.print("\u2588");
		System.out.print(data+"%");
		//try { Thread.sleep (30); } 
		//catch (InterruptedException ex) {}
		Delay(30);
	}
		System.out.println("");
		Delay(1000);
		LimparConsole();
}
//___________________________________________________________
public static void Delay(int time)
{
	try { Thread.sleep(time); } 
	catch (InterruptedException ex) {}	
}
//___________________________________________________________
public static void LimparConsole() 
{
	try
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	catch(Exception ex)
	{
		System.out.println("OMG");
	}
}	
//___________________________________________________________
	public static void GravarArquivo()
	{
		try
		{
			Formatter arquivo = new Formatter("lista.txt");
			for(int i=0; i<ln.size();i++)
			{
				arquivo.format("%s,\n",ln.get(i));
			}
			arquivo.close();
		} 
		catch(FileNotFoundException e) 
		{
			System.out.println("Erro gravacao="+e);
		}
	}

	//___________________________________________________________	

	public static void LerArquivo()
	{
		Scanner tecla = new Scanner(System.in);
		try 
		{
			File arquivo = new File("lista.txt");
			if(!arquivo.exists())
			{
				System.out.println("Arquivo nao existe!!!!!");
				return;
			}
			Scanner sc = new Scanner(arquivo);
			sc.useDelimiter("\\s*,\\s*");
			while(sc.hasNext())
			{
				nome=sc.next();
				//System.out.println("lendo="+nome);
				ln.add(nome);
			}///while
			BarraCarregamento();
			System.out.println("Arquivos Carregados!\n\n");
			sc.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Erro leitura="+e);
		}
	}
	//___________________________________________________________	

	public static void main(String[] args)
	{
		Scanner menu = new Scanner (System.in);
		LerArquivo();
		while(true)
		{
			System.out.print("##--Menu--##\n\n");
			System.out.print("|-----------------------------\n");
			System.out.print("| Opcao 1 - Cadastrar         \n");
			System.out.print("| Opcao 2 - Alterar           \n");
			System.out.print("| Opcao 3 - Excluir           \n");
			System.out.print("| Opcao 4 - Mostrar           \n");
			System.out.print("| Opcao 5 - Sair              \n");
			System.out.print("|-----------------------------\n");

			System.out.print("Digite uma opcao: ");

			int opcao= menu.nextInt();

			if (opcao == 5) 
			{
				LimparConsole();
				System.out.print("\nAte logo!\n");
				System.exit(0);
			}

			switch (opcao)
			{
				case 1:
					LimparConsole();
					System.out.print("\nOpcao Cadastrar\n");
					Cadastrar();
					break;
				case 2:
					LimparConsole();
					System.out.print("\nOpcao Alterar\n");
					Alterar();
					break;
				case 3:
					LimparConsole();
					System.out.print("\nOpcao Excluir\n");
					Excluir();
					break;
				case 4:
					LimparConsole();
					System.out.print("\nOpcao Mostrar\n");
					Mostrar();
					break;
			}//switch
		}//while
	}//main
}//class
