package filabanco;

import java.util.LinkedList;

public class Fila {

	private LinkedList<Cliente> filaNormal;
	private LinkedList<Cliente> filaPrioritaria;

	public Fila() {
		this.filaNormal = new LinkedList<>();
		this.filaPrioritaria = new LinkedList<>();
	}

	public void addCliente(Cliente c) {

		if (c.getIdade() > 0 && c.getIdade() < 65)
			filaNormal.add(c);
		else
			filaPrioritaria.add(c);
	}

	
	public void removeCliente() {
		if (tamanhoFilaNormal() == 0 && tamanhoFilaPrioritaria() == 0)
			throw new IndexOutOfBoundsException();

		else {
			if (tamanhoFilaPrioritaria() == 0)
				removeClienteNormal();
			else
				filaPrioritaria.removeFirst();
		}
	}

	public void removeClienteNormal() {
		if (tamanhoFilaNormal() == 0)
			throw new IndexOutOfBoundsException();
		else
			filaNormal.removeFirst();
	}

	public int tamanhoFilaNormal() {
		return filaNormal.size();
	}

	public int tamanhoFilaPrioritaria() {
		return filaPrioritaria.size();
	}

	public Cliente headFilaNormal() {
		return filaNormal.getFirst();
	}

	public Cliente headFilaPrioritaria() {
		return filaPrioritaria.getFirst();
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
	
	public void clearFilaNormal(){
		filaNormal.clear();
	}
	public void clearFilaPrioritaria(){
		filaPrioritaria.clear();
	}
}
