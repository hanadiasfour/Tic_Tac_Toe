package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private MyPane myPane = new MyPane();
	private int gameMode = 0;

	@Override
	public void start(Stage primaryStage) {

		// creating game play scene
		Scene gameScene = new Scene(new Pane(), 945, 700);
		gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// fist scene when opening game
		Scene openingScene = new Scene(myPane.getOpening(), 650, 500);
		openingScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// starting game , change to pick # players
		myPane.getPlay().setOnAction(e -> {
			Scene playerModeScene = new Scene(myPane.getNumberOfPlayers(), 650, 600);
			playerModeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(playerModeScene);

		});

		// one human player only, change to pick game mode
		myPane.getOne().setOnAction(e -> {

			Scene playerDifficultyScene = new Scene(myPane.getGameDifficulty(), 650, 600);
			playerDifficultyScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(playerDifficultyScene);

		});

		// two human players, change to pick game settings
		myPane.getTwo().setOnAction(e -> {

			gameMode = 2;
			myPane.setSolo(false);

			Scene twoPlayersScene = new Scene(myPane.getSettings(), 980, 680);
			twoPlayersScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(twoPlayersScene);

		});

		// change to pick game settings for random computer game play
		myPane.getNormal().setOnAction(e -> {

			gameMode = 1;
			myPane.setSolo(true);

			Scene normalSoloScene = new Scene(myPane.getSettings(), 980, 680);
			normalSoloScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(normalSoloScene);

		});

		// change to pick game settings for minmax computer game play
		myPane.getImpossible().setOnAction(e -> {

			gameMode = 3;
			myPane.setSolo(true);

			Scene impossibleSoloScene = new Scene(myPane.getSettings(), 980, 680);
			impossibleSoloScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(impossibleSoloScene);

		});

		// setting actions for the back buttons to return to previous pages
		myPane.getBack1().setOnAction(e -> {
			primaryStage.setScene(openingScene);

		});

		myPane.getBack2().setOnAction(e -> {

			Scene playerModeScene = new Scene(myPane.getNumberOfPlayers(), 650, 600);
			playerModeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(playerModeScene);

		});

		myPane.getBack3().setOnAction(e -> {

			if (myPane.isSolo()) {// go back to pick difficulty
				Scene playerDifficultyScene = new Scene(myPane.getGameDifficulty(), 650, 600);
				playerDifficultyScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(playerDifficultyScene);

			} else {// go back to pick number of players

				Scene playerModeScene = new Scene(myPane.getNumberOfPlayers(), 650, 600);
				playerModeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(playerModeScene);

			}

		});

		// pause game
		myPane.getPause().setOnAction(e -> {

			Scene pauseScene = new Scene(myPane.getPauseMenu(), 500, 500);
			pauseScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(pauseScene);

		});

		// continue game
		myPane.getContinueGame().setOnAction(e -> {
			primaryStage.setScene(gameScene);

		});

		// restart game with same settings
		myPane.getRestart().setOnAction(e -> {
			myPane.getBegin().fire();

		});

		// back to opening page
		myPane.getQuit().setOnAction(e -> {

			primaryStage.setScene(openingScene);

		});

		// begin the game with the setting chosen previously
		myPane.getBegin().setOnAction(e -> {

			// setting names and restarting scores
			String name1 = myPane.getName1txf().getText();
			String name2 = myPane.getName2txf().getText();
			String rounds = myPane.getRoundtxf().getText();
			String ok = isValidInput(name1, name2, rounds);// checks if inputs are full and valid

			if (ok == "fine") {// everything is ok to start game

				myPane.getWarning().setText("");
				Player p1 = new Player(name1, myPane.getXsymbol().isSelected() ? "x" : "o", 0,
						myPane.getPlayer1RB().isSelected());
				Player p2 = new Player(name1, myPane.getOtherSymbol().getText(), 0, myPane.getPlayer2RB().isSelected());
				TicTacToe game = new TicTacToe(p1, p2, Integer.parseInt(rounds), gameMode, myPane);
				myPane.setGame(game);
				myPane.getName1lbl().setText(name1);
				myPane.getName2lbl().setText(name2);
				myPane.getScore1lbl().setText("0");
				myPane.getScore2lbl().setText("0");
				myPane.getRoundlbl().setText("1");
				myPane.getName1lbl().setGraphic(null);
				myPane.getName2lbl().setGraphic(null);
				myPane.getCrossLine().setVisible(false);
				myPane.switchLine(game.getCurrentPlayer());
				gameScene.setRoot(myPane.getplayingPage()); // Set the root node

				switch (gameMode) {
				case 1:
					game.startGameSoloEasy(myPane);
					break;
				case 2:
					game.startGameMulti(myPane);
					break;
				case 3:
					game.startGameSoloHard(myPane);

					break;

				}
				primaryStage.setScene(gameScene);

			} else
				myPane.getWarning().setText(ok);

		});

		myPane.getGameover().setOnAction(e -> {

			Scene overScene = new Scene(myPane.getResultsPage(), 500, 600);
			overScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(overScene);

		});

		myPane.getExit().setOnAction(e -> {

			primaryStage.setScene(openingScene);

		});

		Image iconimg = new Image("logo.png");

		primaryStage.setScene(openingScene);
		primaryStage.show();
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.getIcons().add(iconimg);
	}

	public static void main(String[] args) {
		launch(args);
	}

	// given the user inputs, check if all fields are
	private String isValidInput(String name1, String name2, String round) {

		if (name1 == null || name1.isBlank() || name2 == null || name2.isBlank())
			return "Enter player name to continue";

		try {
			if (round == null)
				throw new NumberFormatException();

			if (Integer.parseInt(round) <= 0)
				throw new NumberFormatException();

		} catch (NumberFormatException e) {
			return "Invalid round number";

		}

		return "fine";

	}

}
