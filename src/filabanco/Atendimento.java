package filabanco;

public class Atendimento {

	private FilaClientes filaCliente;

	public Atendimento(FilaClientes fila) {
		filaCliente = fila;
	}

	public void efetuaAtendimento(int numCaixa) {
		if (numCaixa >= 1 && numCaixa <= 5)
			filaCliente.dequeueClientePrioritario();
		else
			filaCliente.dequeueClienteNormal();
	}

}