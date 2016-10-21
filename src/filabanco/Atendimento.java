package filabanco;

public class Atendimento {

	private static filaTeste filaCliente;

	public Atendimento(filaTeste fila) {
		filaCliente = fila;
	}

	public void efetuaAtendimento(int numCaixa) {
		if (numCaixa >= 1 && numCaixa <= 5)
			atendePrioritaria();
		else
			atendeNormal();
	}

	private void atendeNormal() {
		filaCliente.removeClienteNormal();
	}

	private void atendePrioritaria() {
		filaCliente.removeCliente();
	}

}
