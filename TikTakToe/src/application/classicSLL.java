package application;

public class classicSLL {

	private SLLNode first;

	public SLLNode getFirstNode() {

		return first;
	}

	public SLLNode setFirstNode(SLLNode n) {

		return first = n;
	}

	public void addFirst(minMaxNode element) {// O(1)

		SLLNode temp = new SLLNode(element);

		// empty list
		if (first == null)
			first = temp;
		else {// adding as first
			temp.setNext(first);
			first = temp;
		}

	}

	public void addLast(minMaxNode element) {// O(n)

		SLLNode temp = new SLLNode(element);

		// empty list
		if (first == null)
			first = temp;
		else {
			SLLNode curr = first;
			// looping until last element
			while (curr.getNext() != null)
				curr = curr.getNext();

			curr.setNext(temp);// adding to last

		}

	}

	public boolean deleteFirst() {// O(1)

		if (first == null)// empty list
			return false;

		else {
			SLLNode temp = first;
			first = first.getNext();
			temp.setNext(null);
		}
		return true;

	}

	public boolean deleteLast() {// O(n)

		if (first == null)// empty list
			return false;

		else {
			SLLNode current = first;
			// stops at one before last node
			while (current.getNext().getNext() != null)
				current = current.getNext();

			current.setNext(null);
		}
		return true;

	}

	public minMaxNode getFirst() {// O(1)

		if (first == null)
			return null;
		return first.getElement();

	}

	public minMaxNode getLast() {// O(n)

		if (first == null)
			return null;

		SLLNode curr = first;
		// looping until last element
		while (curr.getNext() != null)
			curr = curr.getNext();

		return curr.getElement();

	}

	public void printList() {// O(n)
		SLLNode current = first;
		if (first == null)
			return;
		while (current != null) {
			System.out.println(current.toString());
			current = current.getNext();
		}

	}

	public boolean isEmpty() {

		return first == null;

	}

	@Override
	public String toString() {

		String k = "";

		SLLNode current = first;

		while (current != null) {
			k += current.getElement().getMove() + " -> ";
			current = current.getNext();
		}

		return k.substring(0, k.length() - 4);

	}

}
