package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MyPane {

	private Button play, one, two, normal, impossible, begin, continueGame, restart, quit, exit, pause, back1, back2,
			back3, b1, b2, b3, b4, b5, b6, b7, b8, b9, gameover, nextRound;
	private RadioButton player1RB, player2RB, Xsymbol, Osymbol;
	private TextField name1txf, name2txf, roundtxf;
	private Label name1lbl, name2lbl, score1lbl, score2lbl, roundlbl, otherSymbol, warning;
	private Pane canvasPane;
	private TicTacToe game;
	private boolean isSolo;
	private Line line1, line2, crossLine;

	public MyPane() {

		// creating image for buttons
		ImageView playimg = new ImageView(new Image("play.png"));
		playimg.setFitHeight(35);
		playimg.setFitWidth(35);
		ImageView soloimg = new ImageView(new Image("laptop.png"));
		soloimg.setFitHeight(35);
		soloimg.setFitWidth(35);
		ImageView multiimg = new ImageView(new Image("people.png"));
		multiimg.setFitHeight(35);
		multiimg.setFitWidth(35);
		ImageView arrowimg = new ImageView(new Image("neonArrow.png"));
		arrowimg.setFitHeight(55);
		arrowimg.setFitWidth(55);
		ImageView normalimg = new ImageView(new Image("smile.png"));
		normalimg.setFitHeight(35);
		normalimg.setFitWidth(35);
		ImageView impossibleimg = new ImageView(new Image("skull.png"));
		impossibleimg.setFitHeight(35);
		impossibleimg.setFitWidth(35);
		ImageView arrowimg1 = new ImageView(new Image("neonArrow.png"));
		arrowimg1.setFitHeight(55);
		arrowimg1.setFitWidth(55);
		ImageView playimg1 = new ImageView(new Image("play.png"));
		playimg1.setFitHeight(35);
		playimg1.setFitWidth(35);
		ImageView contimg = new ImageView(new Image("play.png"));
		contimg.setFitHeight(35);
		contimg.setFitWidth(35);
		ImageView restartimg = new ImageView(new Image("restart.png"));
		restartimg.setFitHeight(35);
		restartimg.setFitWidth(35);
		ImageView quitimg = new ImageView(new Image("quit.png"));
		quitimg.setFitHeight(35);
		quitimg.setFitWidth(35);
		ImageView quitimg1 = new ImageView(new Image("quit.png"));
		quitimg1.setFitHeight(35);
		quitimg1.setFitWidth(35);
		ImageView arrowimg2 = new ImageView(new Image("neonArrow.png"));
		arrowimg2.setFitHeight(55);
		arrowimg2.setFitWidth(55);
		ImageView pauseimg = new ImageView(new Image("pause.png"));
		pauseimg.setFitHeight(65);
		pauseimg.setFitWidth(65);
		ImageView nextimg = new ImageView(new Image("next.png"));
		nextimg.setFitHeight(35);
		nextimg.setFitWidth(35);

		// initializing button
		play = new Button("PLAY", playimg);
		back1 = new Button("", arrowimg);
		one = new Button("Solo", soloimg);
		two = new Button("Multiplayer", multiimg);
		back2 = new Button("", arrowimg1);
		normal = new Button("Normal", normalimg);
		impossible = new Button("Impossible", impossibleimg);
		begin = new Button("Begin Game", playimg1);
		back3 = new Button("", arrowimg2);
		continueGame = new Button("Continue", contimg);
		restart = new Button("Restart", restartimg);
		quit = new Button("Quit", quitimg);
		exit = new Button("Exit", quitimg1);
		pause = new Button("", pauseimg);
		gameover = new Button();
		nextRound = new Button("", nextimg);

		// initializing buttons to insert symbols
		b1 = new Button();
		b2 = new Button();
		b3 = new Button();
		b4 = new Button();
		b5 = new Button();
		b6 = new Button();
		b7 = new Button();
		b8 = new Button();
		b9 = new Button();

		// setting properties
		b1.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b2.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b3.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b4.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b5.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b6.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b7.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b8.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");
		b9.setStyle("-fx-background-color:transparent;-fx-text-fill: turquoise;");

		// setting ids
		b1.setId("1");
		b2.setId("2");
		b3.setId("3");
		b4.setId("4");
		b5.setId("5");
		b6.setId("6");
		b7.setId("7");
		b8.setId("8");
		b9.setId("9");

		play.getStyleClass().add("my-button");
		one.getStyleClass().add("my-button");
		two.getStyleClass().add("my-button");
		normal.getStyleClass().add("my-button");
		impossible.getStyleClass().add("my-button");
		begin.getStyleClass().add("my-button");
		continueGame.getStyleClass().add("my-button");
		restart.getStyleClass().add("my-button");
		quit.getStyleClass().add("my-button");
		exit.getStyleClass().add("my-button");

		// setting button sizes
		play.setPrefSize(200, 40);
		one.setPrefSize(250, 40);
		two.setPrefSize(250, 40);
		normal.setPrefSize(250, 40);
		impossible.setPrefSize(250, 40);
		begin.setPrefSize(190, 40);
		continueGame.setPrefSize(250, 40);
		restart.setPrefSize(250, 40);
		quit.setPrefSize(250, 40);
		exit.setPrefSize(150, 40);
		b1.setPrefSize(190, 190);
		b2.setPrefSize(190, 190);
		b3.setPrefSize(190, 190);
		b4.setPrefSize(190, 190);
		b5.setPrefSize(190, 190);
		b6.setPrefSize(190, 190);
		b7.setPrefSize(190, 190);
		b8.setPrefSize(190, 190);
		b9.setPrefSize(190, 190);

		nextRound.setStyle("-fx-background-color:transparent;");
		back1.setStyle("-fx-background-color:transparent;");
		back2.setStyle("-fx-background-color:transparent;");
		back3.setStyle("-fx-background-color:transparent;");
		pause.setStyle("-fx-background-color:transparent;");

		line1 = new Line(0, 0, 60, 0);
		line1.setStroke(Color.WHITE);
		line1.setEffect(new Glow(50));
		line1.setStrokeWidth(3);

		line2 = new Line(0, 0, 60, 0);
		line2.setStroke(Color.WHITE);
		line2.setEffect(new Glow(50));
		line2.setStrokeWidth(3);
		crossLine = new Line();

		name1txf = new TextField();
		name2txf = new TextField();
		roundtxf = new TextField();
		player1RB = new RadioButton("Player 1");
		player2RB = new RadioButton("Player 2");
		Xsymbol = new RadioButton("X");
		Osymbol = new RadioButton("O");

		otherSymbol = new Label("O");
		name1lbl = new Label();
		score1lbl = new Label("0");
		name2lbl = new Label();
		score2lbl = new Label("0");
		roundlbl = new Label("1");// the counting round
		warning = new Label();

	}

	public BorderPane getOpening() {

		// creating three labels for the heading, each with a different color and
		// rotation
		Label label = new Label("TIC");
		label.setStyle("-fx-font-size: 60px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		label.setEffect(new Glow(60));
		label.setRotate(-15);
		label.setPadding(new Insets(30, 0, 0, 0));

		Label label1 = new Label("TAC");
		label1.setStyle("-fx-font-size: 60px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		label1.setEffect(new Glow(60));

		Label label2 = new Label("TOE");
		label2.setRotate(15);
		label2.setPadding(new Insets(30, 0, 0, 0));
		label2.setStyle("-fx-font-size: 60px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		label2.setEffect(new Glow(60));

		// box to hold the three labels to create the main title
		HBox box = new HBox(10);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(label, label1, label2);
		box.setPadding(new Insets(10, 10, 20, 10));

		// main pane which collects all of the page components together
		BorderPane root = new BorderPane();
		root.setCenter(box);
		root.setBottom(play);
		root.setAlignment(box, Pos.CENTER);
		root.setAlignment(play, Pos.CENTER);
		root.setPadding(new Insets(60, 20, 100, 20));
		root.setStyle("-fx-background-color:black;" + "-fx-border-color: turquoise; " + "-fx-border-width: 3px; "
				+ "-fx-border-radius: 5px; " + "-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getNumberOfPlayers() {

		// creating the page title
		Label heading = new Label("Player Mode");
		heading.setStyle("-fx-font-size: 60px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		heading.setEffect(new Glow(60));
		heading.setPadding(new Insets(30, 0, 0, 0));

		// box to hold the buttons
		VBox box = new VBox(30);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(one, two);
		box.setPadding(new Insets(60, 10, 20, 10));

		// main pane which holds all of the components
		BorderPane root = new BorderPane();
		root.setBottom(box);
		root.setCenter(heading);
		root.setTop(back1);
		root.setAlignment(box, Pos.CENTER);
		root.setAlignment(heading, Pos.TOP_CENTER);
		root.setPadding(new Insets(20, 20, 100, 20));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getGameDifficulty() {

		// creating the page title
		Label heading = new Label("Select Difficulty");
		heading.setStyle("-fx-font-size: 50px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		heading.setEffect(new Glow(60));
		heading.setPadding(new Insets(30, 0, 0, 0));

		// box to hold the buttons
		VBox box = new VBox(30);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(normal, impossible);
		box.setPadding(new Insets(60, 10, 20, 10));

		// main pane which holds all of the components
		BorderPane root = new BorderPane();
		root.setBottom(box);
		root.setCenter(heading);
		root.setTop(back2);
		root.setAlignment(box, Pos.CENTER);
		root.setAlignment(heading, Pos.TOP_CENTER);
		root.setPadding(new Insets(20, 20, 100, 20));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getSettings() {

		// initializing components and controls
		ToggleGroup symbolToggle = new ToggleGroup();
		ToggleGroup turnToggle = new ToggleGroup();

		player1RB.setToggleGroup(turnToggle);
		player2RB.setToggleGroup(turnToggle);
		Xsymbol.setToggleGroup(symbolToggle);
		Osymbol.setToggleGroup(symbolToggle);

		// setting name to computer if the player is going against the computer
		// algorithm in solo player mode
		if (isSolo) {
			name2txf.setEditable(false);
			name2txf.setText("Computer");
		} else {
			name2txf.setEditable(true);
			name2txf.setText("");

		}

		// setting properties

		name1txf.setPromptText("Name 1");
		name2txf.setPromptText("Name 2");
		roundtxf.setPromptText("Rounds");
		name1txf.setPrefSize(250, 40);
		name2txf.setPrefSize(250, 40);
		roundtxf.setPrefSize(150, 40);

		// initializing labels to hold information
		Label playerOnelbl = new Label("Player One:");
		Label playerTwolbl = new Label("Player Two:");
		Label Symbollbl = new Label("Symbol:");
		Label startlbl = new Label("First Player:");
		Label roundslbl = new Label("Number Of Rounds:");

		// setting label properties (font, color, glow)
		warning.setStyle("-fx-font-size: 20px; -fx-text-fill: white;-fx-font-weight: bold;");
		playerOnelbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		playerOnelbl.setEffect(new Glow(50));
		playerTwolbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		playerTwolbl.setEffect(new Glow(50));
		Symbollbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		Symbollbl.setEffect(new Glow(50));
		Symbollbl.setPadding(new Insets(50, 0, 0, 0));
		startlbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		startlbl.setEffect(new Glow(50));
		roundslbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		roundslbl.setEffect(new Glow(50));

		// the opposite symbol from the first player
		otherSymbol = new Label("O");
		otherSymbol.setStyle("-fx-font-size: 20; -fx-text-fill: white;-fx-font-weight: bold;");
		otherSymbol.setPadding(new Insets(50, 0, 0, 100));

		// setting IDs
		player1RB.setId("first");
		player2RB.setId("second");
		Xsymbol.setId("X");
		Osymbol.setId("O");

		// assigning initial selections
		player1RB.setSelected(true);
		Xsymbol.setSelected(true);

		// setting actions for opposite symbol selections
		Xsymbol.setOnAction(e -> otherSymbol.setText("O"));
		Osymbol.setOnAction(e -> otherSymbol.setText("X"));

		// customizing appearance
		Xsymbol.setStyle("-fx-font-size: 20px; -fx-text-fill: white;-fx-font-weight: bold; -fx-mark-color: black;");
		Osymbol.setStyle("-fx-font-size: 20px; -fx-text-fill: white;-fx-font-weight: bold; -fx-mark-color: black;");
		player1RB.setStyle("-fx-font-size: 20px;-fx-text-fill: white;-fx-font-weight: bold;  -fx-mark-color: black;");
		player2RB.setStyle("-fx-font-size: 20px; -fx-text-fill: white;-fx-font-weight: bold;  -fx-mark-color: black;");

		// holds the symbols to choose from
		HBox radioButtons = new HBox(50);
		radioButtons.setAlignment(Pos.CENTER_LEFT);
		radioButtons.getChildren().addAll(Xsymbol, Osymbol);
		radioButtons.setPadding(new Insets(50, 0, 0, 0));

		// the grid contains the game settings
		GridPane content = new GridPane();
		content.add(playerOnelbl, 1, 0);
		content.add(playerTwolbl, 2, 0);
		content.add(name1txf, 1, 1);
		content.add(name2txf, 2, 1);
		content.add(Symbollbl, 0, 2);
		content.add(radioButtons, 1, 2);
		content.add(otherSymbol, 2, 2);
		content.add(startlbl, 0, 3);
		content.add(player1RB, 1, 3);
		content.add(player2RB, 2, 3);
		content.add(roundslbl, 0, 4);
		content.add(roundtxf, 1, 4);
		content.add(begin, 2, 5);

		content.setHgap(50);
		content.setVgap(30);
		content.setAlignment(Pos.CENTER_LEFT);
		content.setMargin(begin, new Insets(80, 0, 10, 100));

		// pane that holds all components
		BorderPane root = new BorderPane();
		root.setBottom(warning);
		root.setCenter(content);
		root.setTop(back3);
		root.setAlignment(content, Pos.CENTER);
		root.setPadding(new Insets(20, 20, 10, 50));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getPauseMenu() {

		// box to hold buttons
		VBox content = new VBox(30);
		content.setAlignment(Pos.CENTER);
		content.getChildren().addAll(continueGame, restart, quit);

		// pane that holds all components
		BorderPane root = new BorderPane();
		root.setCenter(content);
		root.setAlignment(content, Pos.CENTER);
		root.setPadding(new Insets(20, 20, 20, 20));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getResultsPage() {

		// obtaining final scores
		int score1 = Integer.parseInt(score1lbl.getText());
		int score2 = Integer.parseInt(score2lbl.getText());

		// initializing images
		ImageView winimg = new ImageView(new Image("celebrate.png"));
		winimg.setFitHeight(85);
		winimg.setFitWidth(85);

		ImageView trophy = new ImageView(new Image("trophy.png"));
		trophy.setFitHeight(45);
		trophy.setFitWidth(45);

		// creating titles for the final status
		Label winner = new Label();
		Label title = new Label();
		Label round = new Label("Rounds:");
		Label playerName = new Label("Player:");
		Label playerScore = new Label("Score:");

		// setting label properties(font, color, glow)
		winner.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		winner.setEffect(new Glow(50));
		title.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		title.setEffect(new Glow(50));
		round.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		round.setEffect(new Glow(50));
		playerName.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		playerName.setEffect(new Glow(50));
		playerScore.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		playerScore.setEffect(new Glow(50));

		// combining status with an HBox
		HBox heading = new HBox(10);
		heading.getChildren().addAll(winner, title);
		heading.setAlignment(Pos.CENTER);

		// depending on the final scores the status will change
		if (score1 == score2) {// when there is a tie score
			ImageView tieimg = new ImageView(new Image("tie.png"));
			tieimg.setFitHeight(85);
			tieimg.setFitWidth(85);
			title.setGraphic(tieimg);
			title.setText("TIE");

		} else if (score1 > score2) {// player one is the winner
			winner.setGraphic(winimg);
			winner.setText(name1lbl.getText());
			title.setText("WINS!");
			name1lbl.setGraphic(trophy);
			name1lbl.setContentDisplay(ContentDisplay.RIGHT);

		} else {// player two is the winner
			winner.setGraphic(winimg);
			winner.setText(name2lbl.getText());
			title.setText("WINS!");
			name2lbl.setGraphic(trophy);
			name2lbl.setContentDisplay(ContentDisplay.RIGHT);
		}

		// grid pane to hold the final scores
		GridPane scores = new GridPane();
		scores.add(playerName, 0, 0);
		scores.add(playerScore, 1, 0);
		scores.add(name1lbl, 0, 1);
		scores.add(score1lbl, 1, 1);
		scores.add(name2lbl, 0, 2);
		scores.add(score2lbl, 1, 2);
		scores.add(round, 0, 3);
		scores.add(roundlbl, 1, 3);

		// setting properties
		scores.setHgap(100);
		scores.setVgap(30);
		scores.setAlignment(Pos.CENTER);
		scores.setMargin(roundlbl, new Insets(0, 0, 0, 40));
		scores.setMargin(score1lbl, new Insets(0, 0, 0, 40));
		scores.setMargin(score2lbl, new Insets(0, 0, 0, 40));

		// setting new properties for the name and score labels from the game
		score1lbl.setStyle("-fx-font-size: 20px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		score1lbl.setEffect(new Glow(50));
		score2lbl.setStyle("-fx-font-size: 20px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		score2lbl.setEffect(new Glow(50));
		name1lbl.setStyle("-fx-font-size: 20px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		name1lbl.setEffect(new Glow(50));
		name2lbl.setStyle("-fx-font-size: 20px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
		name2lbl.setEffect(new Glow(50));
		roundlbl.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		roundlbl.setEffect(new Glow(50));

		// creating and customizing main border pane which holds all components
		BorderPane root = new BorderPane();
		root.setCenter(scores);
		root.setTop(heading);
		root.setBottom(exit);
		root.setAlignment(scores, Pos.CENTER);
		root.setAlignment(exit, Pos.CENTER);
		root.setAlignment(heading, Pos.CENTER);
		root.setPadding(new Insets(40, 20, 20, 20));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	public BorderPane getplayingPage() {

		nextRound.setVisible(false);

		// initializing label
		Label round = new Label("/ " + roundtxf.getText());// the total reference round

		// setting glow properties
		round.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		roundlbl.setStyle("-fx-font-size: 30px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
		roundlbl.setEffect(new Glow(50));
		score1lbl.setEffect(new Glow(50));
		name1lbl.setEffect(new Glow(50));
		name2lbl.setEffect(new Glow(50));
		score2lbl.setEffect(new Glow(50));
		round.setEffect(new Glow(50));

		// initializing x/o images
		ImageView xsymbolimg = new ImageView(new Image("X.png"));
		xsymbolimg.setFitHeight(85);
		xsymbolimg.setFitWidth(85);

		ImageView osymbolimg = new ImageView(new Image("O.png"));
		osymbolimg.setFitHeight(85);
		osymbolimg.setFitWidth(85);

		// boxes to hold players information
		VBox left = new VBox(15);
		VBox right = new VBox(15);
		left.setAlignment(Pos.CENTER);
		right.setAlignment(Pos.CENTER);
		right.setPadding(new Insets(0, 0, 0, 50));
		left.setPadding(new Insets(0, 50, 0, 0));

		// depending on the symbol choice, the score and name colors will differ
		if (otherSymbol.getText().equals("O")) {// first player is X and second player is O
			score1lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
			name1lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
			score2lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
			name2lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
			left.getChildren().add(xsymbolimg);
			right.getChildren().add(osymbolimg);

		} else {// first player is O and second player is X
			score1lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
			name1lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: #FF61D5;-fx-font-weight: bold;");
			score2lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
			name2lbl.setStyle("-fx-font-size: 25px; -fx-text-fill: turquoise;-fx-font-weight: bold;");
			left.getChildren().add(osymbolimg);
			right.getChildren().add(xsymbolimg);
		}

		left.getChildren().addAll(name1lbl, line1, score1lbl);
		right.getChildren().addAll(name2lbl, line2, score2lbl);

		HBox roundBox = new HBox(10);
		roundBox.getChildren().addAll(nextRound, roundlbl, round);
		roundBox.setAlignment(Pos.CENTER_RIGHT);

		Pane p = getCanvas();
		p.setStyle("-fx-background-color:white;");

		// creating and customizing main border pane which holds all components
		BorderPane root = new BorderPane();
		root.setCenter(p);
		root.setTop(pause);
		root.setBottom(roundBox);
		root.setLeft(left);
		root.setRight(right);
		root.setAlignment(pause, Pos.CENTER_RIGHT);
		root.setAlignment(roundBox, Pos.CENTER_RIGHT);
		root.setAlignment(left, Pos.CENTER);
		root.setAlignment(right, Pos.CENTER);
		root.setPadding(new Insets(10, 50, 20, 50));
		root.setStyle(
				"-fx-background-color:black;-fx-border-color: turquoise;-fx-border-width: 3px;-fx-border-radius: 5px;-fx-effect: dropshadow(gaussian, turquoise, 10, 0, 0, 0);");

		return root;

	}

	private Pane getCanvas() {

		// clear button pictures and enable them
		b1.setGraphic(null);
		b2.setGraphic(null);
		b3.setGraphic(null);
		b4.setGraphic(null);
		b5.setGraphic(null);
		b6.setGraphic(null);
		b7.setGraphic(null);
		b8.setGraphic(null);
		b9.setGraphic(null);

		b1.setDisable(false);
		b2.setDisable(false);
		b3.setDisable(false);
		b4.setDisable(false);
		b5.setDisable(false);
		b6.setDisable(false);
		b7.setDisable(false);
		b8.setDisable(false);
		b9.setDisable(false);

		// this pane holds the x/o buttons
		GridPane canvas = new GridPane();
		canvas.setStyle("-fx-background-color:black;");
		canvas.add(b1, 0, 0);
		canvas.add(b2, 1, 0);
		canvas.add(b3, 2, 0);
		canvas.add(b4, 0, 1);
		canvas.add(b5, 1, 1);
		canvas.add(b6, 2, 1);
		canvas.add(b7, 0, 2);
		canvas.add(b8, 1, 2);
		canvas.add(b9, 2, 2);

		// creating canvas lines
		Line v1 = new Line(190, 10, 190, 550);
		v1.setStroke(Color.WHITE);
		v1.setEffect(new Glow(50));
		v1.setStrokeWidth(5);

		Line v2 = new Line(380, 10, 380, 550);
		v2.setStroke(Color.WHITE);
		v2.setEffect(new Glow(50));
		v2.setStrokeWidth(5);

		Line h1 = new Line(10, 190, 560, 190);
		h1.setStroke(Color.WHITE);
		h1.setEffect(new Glow(50));
		h1.setStrokeWidth(5);

		Line h2 = new Line(10, 380, 560, 380);
		h2.setStroke(Color.WHITE);
		h2.setEffect(new Glow(50));
		h2.setStrokeWidth(5);

		canvasPane = new Pane();
		canvasPane.getChildren().addAll(canvas, v1, v2, h1, h2, crossLine);
		canvasPane.setStyle("-fx-background-color:black;");

		return canvasPane;

	}

	public void drawLine(int from, int to, String color) {

		// creating line that indicates the winner
		crossLine.setVisible(true);
		crossLine.setStyle("-fx-stroke: " + color + ";");
		crossLine.setEffect(new Glow(50));
		crossLine.setStrokeWidth(5);

		int A = 0, B = 0, C = 0, D = 0;

		// depending on the from and to boxes, the coordinates are given
		switch (from) {
		case 1:
			A = 85;
			B = 85;
			break;
		case 2:
			A = 285;
			B = 75;
			break;
		case 3:
			A = 485;
			B = 85;
			break;
		case 4:
			A = 75;
			B = 285;
			break;
		case 6:
			A = 495;
			B = 285;
			break;
		case 7:
			A = 85;
			B = 485;
			break;
		case 8:
			A = 285;
			B = 495;
			break;
		case 9:
			A = 485;
			B = 485;
			break;

		}

		switch (to) {
		case 1:
			C = 85;
			D = 85;
			break;
		case 2:
			C = 285;
			D = 75;
			break;
		case 3:
			C = 485;
			D = 85;
			break;
		case 4:
			C = 75;
			D = 285;
			break;
		case 6:
			C = 495;
			D = 285;
			break;
		case 7:
			C = 85;
			D = 485;
			break;
		case 8:
			C = 285;
			D = 495;
			break;
		case 9:
			C = 485;
			D = 485;
			break;

		}

		// setting the start and end coordinates
		crossLine.setStartX(A);
		crossLine.setStartY(B);
		crossLine.setEndX(C);
		crossLine.setEndY(D);

	}

	public void addsymbol(String symbol, int location) {

		// image that holds the x/o depending on the given symbol
		ImageView symbolImg = new ImageView();
		symbolImg.setFitHeight(100);
		symbolImg.setFitWidth(100);

		if (symbol.equalsIgnoreCase("X"))// when x
			symbolImg.setImage(new Image("X.png"));

		else// when o
			symbolImg.setImage(new Image("O.png"));

		switch (location) {
		case 1:
			b1.setGraphic(symbolImg);
			b1.setDisable(true);
			break;
		case 2:
			b2.setGraphic(symbolImg);
			b2.setDisable(true);
			break;
		case 3:
			b3.setGraphic(symbolImg);
			b3.setDisable(true);
			break;
		case 4:
			b4.setGraphic(symbolImg);
			b4.setDisable(true);
			break;
		case 5:
			b5.setGraphic(symbolImg);
			b5.setDisable(true);
			break;
		case 6:
			b6.setGraphic(symbolImg);
			b6.setDisable(true);
			break;
		case 7:
			b7.setGraphic(symbolImg);
			b7.setDisable(true);
			break;
		case 8:
			b8.setGraphic(symbolImg);
			b8.setDisable(true);
			break;
		case 9:
			b9.setGraphic(symbolImg);
			b9.setDisable(true);
			break;

		}

	}

	public void switchLine(Player currentPlayer) {

		if (currentPlayer.getSymbol().equalsIgnoreCase(game.getPlayer1().getSymbol())) {
			line1.setVisible(true);
			line2.setVisible(false);

		} else {
			line1.setVisible(false);
			line2.setVisible(true);
		}

	}

	public void disableButton(int i) {

		switch (i) {
		case 1:
			b1.setDisable(true);
			break;
		case 2:
			b2.setDisable(true);
			break;
		case 3:
			b3.setDisable(true);
			break;
		case 4:
			b4.setDisable(true);
			break;
		case 5:
			b5.setDisable(true);
			break;
		case 6:
			b6.setDisable(true);
			break;
		case 7:
			b7.setDisable(true);
			break;
		case 8:
			b8.setDisable(true);
			break;
		case 9:
			b9.setDisable(true);
			break;

		}

	}
	

	private int getBoxNumber(int i, int j) {

		return (i * 3) + j + 1;

	}

	private String getWordRepresentation(int i) {

		switch (i) {
		case 1:
			return "Win";
		case 0:
			return "Tie";
		case -1:
			return "Lose";

		}

		return null;

	}

	// getters
	public Button getPlay() {
		return play;
	}

	public Button getOne() {
		return one;
	}

	public Button getTwo() {
		return two;
	}

	public Button getNormal() {
		return normal;
	}

	public Button getImpossible() {
		return impossible;
	}

	public Button getBegin() {
		return begin;
	}

	public Button getContinueGame() {
		return continueGame;
	}

	public Button getRestart() {
		return restart;
	}

	public Button getQuit() {
		return quit;
	}

	public Button getExit() {
		return exit;
	}

	public Button getPause() {
		return pause;
	}

	public Button getBack1() {
		return back1;
	}

	public Button getBack2() {
		return back2;
	}

	public Button getBack3() {
		return back3;
	}

	public Button getB1() {
		return b1;
	}

	public Button getB2() {
		return b2;
	}

	public Button getB3() {
		return b3;
	}

	public Button getB4() {
		return b4;
	}

	public Button getB5() {
		return b5;
	}

	public Button getB6() {
		return b6;
	}

	public Button getB7() {
		return b7;
	}

	public Button getB8() {
		return b8;
	}

	public Button getB9() {
		return b9;
	}

	public RadioButton getPlayer1RB() {
		return player1RB;
	}

	public RadioButton getPlayer2RB() {
		return player2RB;
	}

	public RadioButton getXsymbol() {
		return Xsymbol;
	}

	public RadioButton getOsymbol() {
		return Osymbol;
	}

	public TextField getName1txf() {
		return name1txf;
	}

	public TextField getName2txf() {
		return name2txf;
	}

	public TextField getRoundtxf() {
		return roundtxf;
	}

	public Label getName1lbl() {
		return name1lbl;
	}

	public Label getName2lbl() {
		return name2lbl;
	}

	public Label getScore1lbl() {
		return score1lbl;
	}

	public Label getScore2lbl() {
		return score2lbl;
	}

	public Label getRoundlbl() {
		return roundlbl;
	}

	public Label getOtherSymbol() {
		return otherSymbol;
	}

	public Pane getCanvasPane() {
		return canvasPane;
	}

	public TicTacToe getGame() {
		return game;
	}

	public void setGame(TicTacToe game) {
		this.game = game;
	}

	public boolean isSolo() {
		return isSolo;
	}

	public void setSolo(boolean isSolo) {
		this.isSolo = isSolo;
	}

	public Label getWarning() {
		return warning;
	}

	public Button getGameover() {
		return gameover;
	}

	public Line getLine1() {
		return line1;
	}

	public Line getLine2() {
		return line2;
	}

	public Line getCrossLine() {
		return crossLine;
	}

	public Button getNextRound() {
		return nextRound;
	}

}
