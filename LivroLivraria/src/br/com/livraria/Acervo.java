package br.com.livraria;

import java.util.ArrayList;
import java.util.List;

public class Acervo {

	private static List<Livro> listaLivros = new ArrayList<>();
	
	public static List<Livro> getListaLivros() {
		return listaLivros;
	}
	
	public static void adicionarLivro(Livro livro) {
		listaLivros.add(livro);
	}
	
	public static String listar() {
		String saida = "";
		int i = 1;
		for (Livro livro : listaLivros) {
			saida += "\n============ LIVRO N° " + (i++) + " ===========\n";
			saida += livro.toString() + "\n";
		}
		
		return saida;
	}
	
	public static int pesquisa(String genero) {
		int qtd = 0;
		
		for (Livro livro : listaLivros) {
			if(livro.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public static int pesquisa(double vInicial, double vFinal) {
		int qtd = 0;
		
		for (Livro livro : listaLivros) {
			if(livro.getPreco() > vInicial && livro.getPreco() <= vFinal) {
				qtd++;
			}
		}		
		return qtd;
	}
	
	public static boolean remover(String titulo) {
		for (Livro livro : listaLivros) {
			if(livro.getTitulo().equalsIgnoreCase(titulo)) {
				listaLivros.remove(livro);
				return true;
			}
		}
		return false;
	}
	
	public static double calcularTotalAcervo() {
		double total = 0;
		
		for (Livro livro : listaLivros) {
			total += livro.getPreco();
		}
		
		return total;
	}
	
}
