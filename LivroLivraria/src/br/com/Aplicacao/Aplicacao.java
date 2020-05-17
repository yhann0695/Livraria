package br.com.Aplicacao;

import java.util.Scanner;

import br.com.Utils.Utils;
import br.com.livraria.Acervo;
import br.com.livraria.Livro;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Scanner entradaString =  new Scanner(System.in);
		
		int menu = 0;
		double vInicial, vFinal;
		
		Livro objLivro;
		
		String titulo,autor,genero;
		double preco;
		int isbn;
		
		do {
			
			Utils.exibirMenu();
			menu = entrada.nextInt();
			
			if(menu == 1) {
				System.out.println(" ===== > Cadastrar Livro");
				System.out.println("Digite o titulo");
				titulo = entradaString.nextLine();
				System.out.println("Digite o autor");
				autor = entradaString.nextLine();
				System.out.println("Digite o genero");
				genero = entradaString.nextLine();
				System.out.println("Digite o preço");
				preco = entrada.nextDouble();
				System.out.println("Digite o isbn");
				isbn = entrada.nextInt();
				
				objLivro = new Livro(titulo, autor, isbn, genero, preco);
				
				Acervo.adicionarLivro(objLivro);		
			}
			
			if(menu == 2) {
				System.out.println("Listagem de livros");
				System.out.println(Acervo.listar());
			}
			
			if(menu == 3) {
				System.out.println("Excluir o livro");
				System.out.println("Digite o Titulo do livro");
				titulo = entradaString.next();
				
				if(!(Acervo.getListaLivros().isEmpty())) {
					if(Acervo.remover(titulo)) {
						System.out.println("Livro removido com sucesso");
					
					} else {
						System.out.println("Titulo não encotrado");
					}
					
				} else {
					System.out.println("Não existe esse livro no acervo");
				}
			}
			
			if(menu == 4) {
				System.out.println("Pesquisa pelo genero");
				System.out.println("Digite o genero");
				genero = entradaString.next();
				System.out.println("Existem " + Acervo.pesquisa(genero) + " livro(s) do genero " + genero);
			}
			
			if(menu == 5) {
				System.out.println("Pesquisa por faixa de preço");
				System.out.println("Digite a faixa inicial e a final dos valores que deseja pesquisar");
				vInicial = entrada.nextDouble();
				vFinal = entrada.nextDouble();
				
				System.out.println("Existem " + Acervo.pesquisa(vInicial, vFinal) + " livro(s) com preço entre " + String.format("R$ %.2f e R$ %.2f \n", vInicial, vFinal));
			}
			
			if(menu == 6) {
				System.out.println("Total em R$ de livros no Acervo");
				System.out.println("O total é: " + String.format(" R$ %.2f \n", Acervo.calcularTotalAcervo()));
			}
			
			if(menu == 7) {
				System.out.println("Saindo...");
			}
			
			
			
		} while (menu != 7);

	}

}
