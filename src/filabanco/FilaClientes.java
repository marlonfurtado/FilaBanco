package filabanco;

public class FilaClientes {

	private LinkedListCliente filaNormal;
	private LinkedListCliente filaPrioritaria;

	public FilaClientes() {
		this.filaNormal = new LinkedListCliente();
		this.filaPrioritaria = new LinkedListCliente();
	}

	// Adiciona clientes conforme idade
	public void enqueue(Cliente c) {
		if (c.getIdade() > 0 && c.getIdade() < 65)
			filaNormal.add(c);
		else
			filaPrioritaria.add(c);
	}

	// Se houver, remove cliente prioritário
	public void dequeueClientePrioritario() {
		if (sizeFilaNormal() == 0 && sizeFilaPrioritaria() == 0)
			throw new RuntimeException("FILA VAZIA");

		else {
			if (sizeFilaPrioritaria() == 0)
				dequeueClienteNormal();
			else
				filaPrioritaria.removeByIndex(0);
		}
	}

	// Se houver, remove cliente sem prioridade
	public void dequeueClienteNormal() {
		if (sizeFilaNormal() == 0)
			dequeueClientePrioritario();

		else
			filaNormal.removeByIndex(0);
	}

	// Primeiro da fila
	public Cliente headFilaNormal() {
		try {
			return filaNormal.get(0);
		} catch (Exception e) {
			return filaPrioritaria.get(0);
		}

	}

	// Primeiro da fila
	public Cliente headFilaPrioritaria() {
		try {
			return filaPrioritaria.get(0);
		} catch (Exception e) {
			return filaNormal.get(0);
		}
	}

	public int sizeFilaNormal() {
		return filaNormal.size();
	}

	public int sizeFilaPrioritaria() {
		return filaPrioritaria.size();
	}

	public boolean isEmptyFilaNormal() {
		if (sizeFilaNormal() == 0)
			return true;
		else
			return false;
	}

	public boolean isEmptyFilaPrioritaria() {
		if (sizeFilaPrioritaria() == 0)
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