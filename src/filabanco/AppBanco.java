package filabanco;

import java.util.Random;

public class AppBanco {

	public static void main(String[] args) {

		String nome;
		int idade;
		int numCaixa;
		int maxPessoasFila = 20;

		Random random = new Random();

		filaTeste filaClientes = new filaTeste();
		Atendimento atendimento = new Atendimento(filaClientes);


		Cliente[] cliente = new Cliente[maxPessoasFila];

		
		// ADICIONAR PESSOAS NA FILA
		for (int i = 0; i < maxPessoasFila; i++) {
			nome = Cliente.gerarCliente();
			idade = random.nextInt(100);
			Cliente c = new Cliente(nome, idade);

			cliente[i] = c;

			filaClientes.addCliente(cliente[i]);
		}

		
		
		
		
		for (int i = 1; i <= 10; i++) {
			numCaixa = random.nextInt(10)+1;
			System.out.println("Caixa: "+numCaixa+" livre\n");
			atendimento.efetuaAtendimento(numCaixa);
			System.out.println("Quantidade de pessoas na fila: "+(filaClientes.tamanhoFilaPrioritaria()+filaClientes.tamanhoFilaNormal()));
			System.out.println("Atendimento prioritário: "+filaClientes.tamanhoFilaPrioritaria());
			System.out.println("Atendimento normal: "+filaClientes.tamanhoFilaNormal());
			System.out.println("\nPrimeiro NORMAL "+filaClientes.headFilaNormal());
			System.out.println("\nPrimeiro PRIORITARIO"+filaClientes.headFilaPrioritaria());
			System.out.println("----------------------------\n");
		}

		
		
	}

}