package application;

public class SLLNode {

	private minMaxNode element;
	private SLLNode next;

	SLLNode(minMaxNode element) {
		this.element = element;

	}

	public minMaxNode getElement() {
		return element;
	}

	public void setElement(minMaxNode element) {
		this.element = element;
	}

	public SLLNode getNext() {
		return next;
	}

	public void setNext(SLLNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [element=" + element;
	}

}
