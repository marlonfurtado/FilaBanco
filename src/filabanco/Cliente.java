package filabanco;

import java.util.Random;

public class Cliente {
	private String nome;
	private int idade;

	public Cliente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	
	//Gerar clientes com 'nomes' aleatórios
	public static String gerarCliente() {
		String cliente = "AEIOUABCDEFGHIJKLMNOPQRSTUVYWXZAAEEIIOOUU";
		Random r = new Random();

		//Nome somente com as duas letras iniciais
		char letra_um = cliente.charAt(r.nextInt(36));
		char letra_dois = cliente.charAt(r.nextInt(36));

		cliente = Character.toString(letra_um) + Character.toString(letra_dois);

		return cliente;
	}
	
	//Retorna idade no intervalo 16..100
	public static int gerarIdade() {
		Random r = new Random();
		int idade_min = 16;
		int idade_max = 100;
		
		return r.nextInt((idade_max - idade_min) + 1) + idade_min;
	}
	

	@Override
	public String toString() {
		return "Cliente [nome:" + nome + ", idade:" + idade + "]";
	}

}