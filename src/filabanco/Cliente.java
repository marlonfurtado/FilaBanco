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

	
	//Gerar clientes aleatórios
	public static String gerarCliente() {
		String cliente = "AEIOUABCDEFGHIJKLMNOPQRSTUVYWXZAAEEIIOOUU";
		Random r = new Random();

		char aux1 = cliente.charAt(r.nextInt(36));
		char aux2 = cliente.charAt(r.nextInt(36));
		//char aux3 = cliente.charAt(r.nextInt(36));

		cliente = Character.toString(aux1) + Character.toString(aux2);

		return cliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + "]";
	}

}
