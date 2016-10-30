package filabanco;

public class LinkedListCliente {

	private class Node {
		Cliente cliente;
		Node next;

		Node(Cliente cliente) {
			this.cliente = cliente;
			next = null;
		}
	}

	Node head;
	Node tail;
	int count;

	public LinkedListCliente() {
		head = null;
		tail = null;
		count = 0;
	}

	// Adiciona cliente
	public void add(Cliente cliente) {
		Node n = new Node(cliente);

		if (count == 0) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
		}

		tail = n;
		count++;
	}

	// Retorna cliente na posição passada no parametro
	public Cliente get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}

		Node aux = head;
		if (index == count - 1) {
			return tail.cliente;
		}

		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux.cliente;
	}

	// Troca e retorna o cliente na posição
	public Cliente set(int index, Cliente cliente) {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException();
		}

		Node aux = head;

		if (index == count - 1) {
			Cliente n = tail.cliente;
			tail.cliente = cliente;
			return n;

		} else {
			for (int i = 0; i < index; i++) {
				aux = aux.next;

			}
			Cliente e = aux.cliente;
			aux.cliente = cliente;
			return e;
		}
	}

	// Retorna a posição do cliente
	public int indexOf(Cliente cliente) {
		Node aux = head;

		for (int i = 0; i < count; i++) {
			if (cliente == aux.cliente) {
				return i;
			}
			aux = aux.next;
		}
		return -1;
	}

	// Remove cliente da posição passada
	public Cliente removeByIndex(int index) {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();

		if (index == 0) {
			Cliente aux = head.cliente;
			head = head.next;
			if (count == 1)
				tail = null;

			count--;
			return aux;
		}

		Node ant = head;
		Node n = head.next;

		for (int i = 0; i < index; i++) {
			ant = ant.next;
			n = n.next;
		}
		ant.next = n.next;

		if (n == tail)
			tail = ant;

		count--;
		return n.cliente;
	}

	// Remove cliente
	public boolean remove(Cliente cliente) {
		if (count == 0)
			throw new IndexOutOfBoundsException();

		if (cliente == head.cliente) {
			head = head.next;

			if (count == 1)
				tail = null;

			count--;
			return true;
		} else {
			Node aux = head;
			Node n = head.next;

			for (int i = 1; i < count; i++) {
				if (n.cliente == cliente) {
					aux.next = n.next;
					count--;
					if (n == tail)
						tail = aux;
					return true;
				} else {
					aux = aux.next;
					n = n.next;
				}
			}
			return false;
		}
	}

	public int size() {
		return count;
	}

	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

}