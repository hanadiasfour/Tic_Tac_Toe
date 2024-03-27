package application;

public class minMaxNode {

	private boolean isTerminal = false;
	private boolean isMax;
	private String[][] board;
	private int status, move, initialMove;
	private classicSLL childNodes = new classicSLL();

	public minMaxNode(boolean isMax, String[][] board) {
		this.isMax = isMax;
		this.board = board;
	}

	public boolean isMax() {
		return isMax;
	}

	public void setMax(boolean isMax) {
		this.isMax = isMax;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public classicSLL getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(classicSLL childNodes) {
		this.childNodes = childNodes;
	}

	public boolean isTerminal() {
		return isTerminal;
	}

	public void setTerminal(boolean isTerminal) {
		this.isTerminal = isTerminal;
	}

	public int getInitialMove() {
		return initialMove;
	}

	public void setInitialMove(int initialMove) {
		this.initialMove = initialMove;
	}

}
