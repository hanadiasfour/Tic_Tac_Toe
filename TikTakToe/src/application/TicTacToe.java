package application;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToe {

	private String[][] board;
	private Player player1, player2;
	private Player currentPlayer;
	private int movesLeft;
	private int linefrom, lineto, currentRound, totRound, gameMode;
	private MyPane pane;


	public TicTacToe(Player player1, Player player2, int round, int gameMode, MyPane pane) {
		this.player1 = player1;
		this.player2 = player2;
		movesLeft = 9;// total moves possible
		board = new String[3][3];// new board
		currentRound = 1;
		this.totRound = round + 1;
		this.pane = pane;

		if (this.player1.isBeginner())
			this.currentPlayer = player1;
		else
			this.currentPlayer = player2;

		this.gameMode = gameMode;

	}

	// computer chooses random spot in board
	public void startGameSoloEasy(MyPane pane) {

		if (currentRound == totRound)
			gameOver(pane);// round is done
		else
			currentRound++;// next round

		if (player2.isBeginner()) {// computer starts
			currentPlayer = player2;
			computerRandomPlay(pane);

		} else {// human starts
			currentPlayer = player1;
			humanPlay(pane);
		}

	}

	public void startGameMulti(MyPane pane) {

		if (currentRound == totRound)
			gameOver(pane);
		else
			currentRound++;

		if (player2.isBeginner())

			currentPlayer = player2;
		else
			currentPlayer = player1;

		humanPlay(pane);

	}

	public void startGameSoloHard(MyPane pane) {

		if (currentRound == totRound)
			gameOver(pane);
		else
			currentRound++;

		if (player2.isBeginner()) {

			currentPlayer = player2;
			computerSmartPlay(pane);
		} else {
			currentPlayer = player1;
			humanPlay(pane);
		}

	}

	private void computerRandomPlay(MyPane pane) {

		if (moreMoves()) {
			int[] points = getRandomOption(board);
			selectSpot(points[0], points[1], board, currentPlayer.getSymbol());
			movesLeft--;

			pane.addsymbol(currentPlayer.getSymbol(), getBoxNumber(points[0], points[1]));

		}

		boolean result = isVictory(board, currentPlayer.getSymbol());

		if (result) {

			pane.drawLine(linefrom, lineto, currentPlayer.getColor());
			currentPlayer.setScore(currentPlayer.getScore() + 1);
			pane.getScore2lbl().setText(currentPlayer.getScore() + "");
			emptyCanvas(pane);

		} else if (!moreMoves()) {// tie

			emptyCanvas(pane);
		}

		else {// not win
			togglePlayer();
			pane.switchLine(currentPlayer);
			humanPlay(pane);
		}

		pane.getRoundlbl().setText(currentRound - 1 + "");
	}

	private void computerSmartPlay(MyPane pane) {

		// the first computer move is random
		if ((player2.isBeginner() && movesLeft == 9)) {
			computerRandomPlay(pane);

		} else {
			Stage stage;

			if (moreMoves()) {

				String[][] dummyBoard = copyBoard(board);

				minMaxNode root = new minMaxNode(true, dummyBoard);

				miniMax(root);
				String[][] dummyBoard2 = copyBoard(board);

				selectSpot(root.getMove(), board, currentPlayer.getSymbol());
				movesLeft--;

				pane.addsymbol(currentPlayer.getSymbol(), root.getMove());


			boolean result = isVictory(board, currentPlayer.getSymbol());

			 if (result) {

				pane.drawLine(linefrom, lineto, currentPlayer.getColor());
				currentPlayer.setScore(currentPlayer.getScore() + 1);
				pane.getScore2lbl().setText(currentPlayer.getScore() + "");
				emptyCanvas(pane);

			} else if (!moreMoves()) {// tie

				emptyCanvas(pane);
			}

			else {// not win
				togglePlayer();
				pane.switchLine(currentPlayer);
				humanPlay(pane);
			}

			pane.getRoundlbl().setText(currentRound - 1 + "");

		}

	}

	// minmax algorithm to get the optimal move for the computer
	private void miniMax(minMaxNode node) {

		// checking base state (no more moves or victory)
		if (isTerminal(node.getBoard())) {
			if (isVictory(node.getBoard(), player2.getSymbol()))
				node.setStatus(1);// win

			else if (isVictory(node.getBoard(), player1.getSymbol()))
				node.setStatus(-1);// lose

			else if (isTie(node.getBoard()))
				node.setStatus(0);// tie

			node.setTerminal(true);// saving that it is a terminal state
			return;

		}

		int[] validMoves = getValidMoves(node.getBoard());// getting the available moves in the node board

		for (int i = 1; i < validMoves[0]; i++) {// looping the available moves

			String[][] dummyBoard = copyBoard(node.getBoard());// copying the board

			// select the spot in the new board
			selectSpot(validMoves[i], dummyBoard, getPlayer(node.isMax()).getSymbol());

			minMaxNode child = new minMaxNode(!node.isMax(), dummyBoard);// creating node with new board

			child.setMove(validMoves[i]);// assigning what was the move that led to this board
			child.setInitialMove(node.getInitialMove());

			node.getChildNodes().addLast(child);// adding the new board child to the source node
			miniMax(child);// recursive call with new board

		}

		// if it is a max node (takes the maximum value from the children nodes)
		if (node.isMax()) {
			int maxStatus = -2;// lowest value possible
			int move = 0;// to keep track of the best move

			SLLNode curr = node.getChildNodes().getFirstNode();
			while (curr != null) {// looping through children nodes (boards)

				minMaxNode currentNode = curr.getElement();
				int stat = currentNode.getStatus();

				if (maxStatus <= stat) {// getting the max status from children
					maxStatus = stat;
					move = currentNode.getMove();
				}

				curr = curr.getNext();
			}

			node.setStatus(maxStatus);
			node.setMove(move);

		} else { // if it is a min node (takes the minimum value from the children nodes)

			int minStatus = 2;// maximum value possible

			SLLNode curr = node.getChildNodes().getFirstNode();
			while (curr != null) {// looping through children nodes (boards)

				minMaxNode currentNode = curr.getElement();
				int stat = currentNode.getStatus();
				minStatus = minStatus >= stat ? stat : minStatus;
				curr = curr.getNext();
			}
			node.setStatus(minStatus);
		}
	}

	// returns a new board with the same values as the given
	private String[][] copyBoard(String[][] source) {

		String[][] newBoard = new String[3][3];

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				newBoard[i][j] = source[i][j];

		return newBoard;

	}

	// if all spots are occupied then tie
	private boolean isTie(String[][] board) {

		boolean flag = true;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == null)
					flag = false;

		return flag;
	}

	// there is a win or there is a tie
	private boolean isTerminal(String[][] board) {

		boolean isWinP1 = isVictory(board, "o");
		boolean isWinP2 = isVictory(board, "x");

		return (isWinP1 || isWinP2) || isTie(board);

	}

	// returns which player is the max
	private Player getPlayer(boolean isMax) {

		return isMax ? player2 : player1;

	}

	// selects the given index of the board
	public String[][] selectSpot(int boxNum, String[][] board, String symbol) {

		int i = (boxNum - 1) / 3;
		int j = (boxNum - 1) % 3;

		if (board[i][j] == null)
			board[i][j] = symbol;
		else
			board[i][j] += " " + symbol;
		return board;

	}

	// selects the given number of the board
	public String[][] selectSpot(int i, int j, String[][] board, String symbol) {

		board[i][j] = symbol;
		return board;

	}

	public void togglePlayer() {

		if (isCurrentPlayer(player1))
			this.currentPlayer = player2;
		else
			this.currentPlayer = player1;

	}

	public int[] getRandomOption(String[][] board) {

		int[] valid = getValidMoves(board);// holds valid moves

		Random rand = new Random();// to generate random integer

		int value = valid[rand.nextInt(valid[0] - 1) + 1];// random index from valid

		int i = (value - 1) / 3;
		int j = (value - 1) % 3;

		int[] result = { i, j };
		return result;

	}

	private int[] getValidMoves(String[][] board) {

		int[] valid = new int[10];// first index has the number of valid moves available
		int index = 1;

		// loops to find the empty spots (valid moves) on the board
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == null)// available
					valid[index++] = getBoxNumber(i, j);// using the coordinates we can find the number of box

		valid[0] = index;
		return valid;// returning available moves

	}

	public boolean isVictory(String[][] board, String symbol) {

		// checking horizontal (00,01,02)(10,11,12)(20,21,22)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (board[i][j] == null || !board[i][j].equalsIgnoreCase(symbol))// differ in symbol
					break;

				if (j == 2) { // win horizontally |
					linefrom = (i * 3) + 1;
					lineto = (i * 3) + 3;
					return true;
				}
			}
		}

		// checking vertically (00,10,20)(01,11,21)(02,12,22)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (board[j][i] == null || !board[j][i].equalsIgnoreCase(symbol))// differ in symbol
					break;

				if (j == 2) { // win vertically -
					linefrom = i + 1;
					lineto = i + 7;
					return true;
				}
			}
		}

		// checking forward diagonal win
		for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {

			if (board[j][i] == null || !board[j][i].equalsIgnoreCase(symbol))
				break;

			if (j == 2) { // win diagonally /
				linefrom = 1;
				lineto = 9;
				return true;

			}
		}

		// checking backward diagonal win
		for (int i = 2, j = 0; i >= 0 && j < 3; i--, j++) {

			if (board[j][i] == null || !board[j][i].equalsIgnoreCase(symbol))
				break;

			if (j == 2) {// win diagonally \
				linefrom = 3;
				lineto = 7;
				return true;
			}
		}

		return false;// no win

	}

	public void emptyCanvas(MyPane pane) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2.5), e -> {
			// clear button pictures and enable them
			pane.getB1().setGraphic(null);
			pane.getB2().setGraphic(null);
			pane.getB3().setGraphic(null);
			pane.getB4().setGraphic(null);
			pane.getB5().setGraphic(null);
			pane.getB6().setGraphic(null);
			pane.getB7().setGraphic(null);
			pane.getB8().setGraphic(null);
			pane.getB9().setGraphic(null);

			pane.getB1().setDisable(false);
			pane.getB2().setDisable(false);
			pane.getB3().setDisable(false);
			pane.getB4().setDisable(false);
			pane.getB5().setDisable(false);
			pane.getB6().setDisable(false);
			pane.getB7().setDisable(false);
			pane.getB8().setDisable(false);
			pane.getB9().setDisable(false);

			movesLeft = 9;
			board = new String[3][3];
			pane.getCrossLine().setVisible(false);

			switch (gameMode) {
			case 1:
				startGameSoloEasy(pane);
				break;
			case 2:
				startGameMulti(pane);
				break;
			case 3:
				startGameSoloHard(pane);
				break;

			}

		}));
		timeline.play();

	}


	private void humanPlay(MyPane pane) {

		pane.getB1().setOnAction(e ->doIt(pane, 1));
		pane.getB2().setOnAction(e -> doIt(pane, 2));
		pane.getB3().setOnAction(e -> doIt(pane, 3));
		pane.getB4().setOnAction(e -> doIt(pane, 4));
		pane.getB5().setOnAction(e -> doIt(pane, 5));
		pane.getB6().setOnAction(e -> doIt(pane, 6));
		pane.getB7().setOnAction(e -> doIt(pane, 7));
		pane.getB8().setOnAction(e -> doIt(pane, 8));
		pane.getB9().setOnAction(e -> doIt(pane, 9));

	}

	private void doIt(MyPane pane, int i) {

		pane.addsymbol(currentPlayer.getSymbol(), i);
		selectSpot(i, board, currentPlayer.getSymbol());
		movesLeft--;

		if (isVictory(board, currentPlayer.getSymbol())) {
			pane.drawLine(linefrom, lineto, currentPlayer.getColor());

			currentPlayer.setScore(currentPlayer.getScore() + 1);

			if (gameMode == 1 || isCurrentPlayer(player1))
				pane.getScore1lbl().setText(currentPlayer.getScore() + "");
			else
				pane.getScore2lbl().setText(currentPlayer.getScore() + "");

			emptyCanvas(pane);

		} else if (!moreMoves()) {// tie

			emptyCanvas(pane);
		}

		else {

			togglePlayer();
			pane.switchLine(currentPlayer);

			switch (gameMode) {
			case 1:
				computerRandomPlay(pane);
				break;
			case 2:
//				humanPlay(pane);
				break;
			case 3:
				computerSmartPlay(pane);
				break;

			}
		}

		pane.getRoundlbl().setText(currentRound - 1 + "");

	}

	public void gameOver(MyPane pane) {

		pane.getGameover().fire();

	}

	public boolean isCurrentPlayer(Player player) {

		if (this.currentPlayer.getSymbol() == player.getSymbol())
			return true;
		return false;

	}

	public boolean moreMoves() {

		if (movesLeft >= 1)
			return true;
		return false;

	}

	public int getBoxNumber(int i, int j) {

		return (i * 3) + j + 1;

	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
