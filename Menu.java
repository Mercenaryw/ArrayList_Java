import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Menu{
	
	static ArrayList<String> ln = new ArrayList<>();
	static Scanner tecla=new Scanner(System.in);
	static String nome;
	static int i=0;
//______________________________________________________________
public static void Cadastrar(){
		while(true)
		{
			if(!ln.isEmpty()){
			   Collections.sort(ln);//crescente
			   Collections.reverse(ln);//decrescente
			   Mostrar();
		}
		nome="";
		System.out.print("\nDigite um Nome ou ENTER para finalizar:\n");
		nome=tecla.nextLine();
		if(nome.equals(""))break;
		ln.add(nome);
		}//while
	}
//___________________________________________________________
public static void Alterar(){
	System.out.print("\n Alterar nomes da lista");
	while(true){
		if(!ln.isEmpty()){
		Collections.sort(ln);//crescente
		Collections.reverse(ln);//decrescente
		Mostrar();
			}
	nome="";
	while(true){
    System.out.print("\n Digite qual numero para alterar(0=fim)?");
		i=tecla.nextInt();
		if(i>=0 && i<=ln.size())break;
			}//while
		if(i==0)break;
		nome=""; tecla.nextLine();//limpa buffer teclado
		System.out.print("\n Digite novo Nome:");
		nome=tecla.nextLine();
		ln.set(i-1,nome);
		}//while
	}
//___________________________________________________________

public static void Excluir(){
	Mostrar();
	System.out.println("Digite qual numero deseja excluir: \n");
	i=tecla.nextInt();
	ln.remove(i-1);
	Mostrar();
	}

//___________________________________________________________

public static void Mostrar(){
		if(ln.isEmpty()){
				System.out.println("Lista Vazia!");
		}else{
				System.out.print("\nLista de nomes:\n");
			    for(i=0;i<ln.size();i++){
			    System.out.println((i+1)+"-"+ln.get(i));
				}//for
				/*for(String nome:ln){
			    System.out.println((ln.size()+"-")+nome);
				}//foreach*/
				System.out.println("");
				//System.out.println(ln);
		}
	}
//___________________________________________________________

	
public static void main(String[] args)
{
	Scanner menu = new Scanner (System.in);
	while(true){
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
            
            if (opcao == 5) {
                System.out.print("\nAté logo!\n");
                System.exit(0);
            }

	switch (opcao){
            case 1:
                System.out.print("\nOpcao Cadastrar\n");
                Cadastrar();
                break;
            case 2:
                System.out.print("\nOpcao Alterar\n");
                Alterar();
                break;
            case 3:
                System.out.print("\nOpcao Excluir\n");
                Excluir();
                break;
            case 4:
                System.out.print("\nOpcao Mostrar\n");
                Mostrar();
                break;
            }//switch
		}//while
	}//main
}//class
