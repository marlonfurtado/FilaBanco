package filabanco;

public class filaTeste {

	private LinkedListOfCliente filaNormal;
	private LinkedListOfCliente filaPrioritaria;

	public filaTeste() {
		this.filaNormal = new LinkedListOfCliente();
		this.filaPrioritaria = new LinkedListOfCliente();
	}

	// ENQUEUE
	public void addCliente(Cliente c) {

		if (c.getIdade() > 0 && c.getIdade() < 65)
			filaNormal.add(c);
		else
			filaPrioritaria.add(c);
	}

	// DEQUEUE
	public void removeCliente() {
		if (tamanhoFilaNormal() == 0 && tamanhoFilaPrioritaria() == 0)
			throw new IndexOutOfBoundsException();

		else {
			if (tamanhoFilaPrioritaria() == 0)
				removeClienteNormal();
			else
				filaPrioritaria.removeByIndex(0);
		}
	}

	// DEQUEUE ClienteNormal
	public void removeClienteNormal() {
		if (tamanhoFilaNormal() == 0)
			throw new IndexOutOfBoundsException("ERRO: FILA VAZIA");
		else
			filaNormal.removeByIndex(0);
	}

	// SIZE
	public int tamanhoFilaNormal() {
		return filaNormal.size();
	}

	public int tamanhoFilaPrioritaria() {
		return filaPrioritaria.size();
	}

	public Cliente headFilaNormal() {
		return filaNormal.get(0);
	}

	public Cliente headFilaPrioritaria() {
		return filaPrioritaria.get(0);
	}

	public boolean isEmptyFilaNormal() {
		if (tamanhoFilaNormal() == 0)
			return true;
		else
			return false;
	}

	public boolean isEmptyFilaPrioritaria() {
		if (tamanhoFilaPrioritaria() == 0)
			return true;
		else
			return false;
	}

	public void clearFilaNormal() {
		filaNormal.clear();
	}

	public void clearFilaPrioritaria() {
		filaPrioritaria.clear();
	}

}
