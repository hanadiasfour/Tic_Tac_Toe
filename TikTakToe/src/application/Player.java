package application;

public class Player {

	private String name, symbol;
	private int score;
	private boolean isBeginner, isWinner;
	private String color;

	public Player(String name, String symbol, int score, boolean isBeginner) {
		this.name = name;
		this.symbol = symbol;
		this.score = score;
		this.isBeginner = isBeginner;

		if (this.symbol.equalsIgnoreCase("x"))
			this.color = "turquoise";
		else
			this.color = "#FF61D5";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isBeginner() {
		return isBeginner;
	}

	public void setBeginner(boolean isBeginner) {
		this.isBeginner = isBeginner;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
