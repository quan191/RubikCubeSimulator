package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import rubik.scene.RubikScene;

public class RubikScreenController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private TextField timeTextField;

	@FXML
	private TextField stepTextField;

	private Timeline timeline = new Timeline();

	private StringProperty timePlay = new SimpleStringProperty("00:00:00");

	private long timeLong = 0;

	protected final BooleanProperty onPlay = new SimpleBooleanProperty(false);

	private RubikScene rubikScene;

	private Stage parentStage;

	private ChangeListener<Boolean> lis;
	
	private double mousePosX;
	private double mousePosY;
	private double mouseOldX;
	private double mouseOldY;

	public RubikScene getRubikScene() {
		return rubikScene;
	}

	public void setRubikScene(RubikScene rubikScene) {
		this.rubikScene = rubikScene;
	}

	public void setParentStage(Stage stage) {
		this.parentStage = stage;
	}

	public void setUpRubikScene() {
		anchorPane.getChildren().add(rubikScene);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeTextField.textProperty().bind(timePlay);
		stepTextField.setText("0");
		anchorPane.setOnMousePressed(me -> {
			if (rubikScene.getOnRotation().get()) {
				return;
			}
			mouseOldX = me.getSceneX();
			mouseOldY = me.getSceneY();

		});
		anchorPane.setOnMouseDragged(me -> {
			if (rubikScene.getOnRotation().get()) {
				return;
			}
			mousePosX = me.getSceneX();
			mousePosY = me.getSceneY();
			if (Math.abs(mousePosX - mouseOldX) >= Math.abs(mousePosY - mouseOldY)) {
				if (mousePosX - mouseOldX > 0) {
					rubikScene.rubikSolver("Yi", 400);
				} else {
					rubikScene.rubikSolver("Y", 400);
				}

			} else {
				if (mousePosY - mouseOldY > 0) {
					rubikScene.rubikSolver("Xi", 400);
				} else {
					rubikScene.rubikSolver("X", 400);
				}
			}
			mouseOldX = mousePosX;
			mouseOldY = mousePosY;
		});

	}

	public void backAction(ActionEvent e) {
		this.parentStage.hide();
	}

	public void rotateAction(ActionEvent e) {
		if (rubikScene.getOnRotation().get() || rubikScene.getOnScramble().get()) {
			return;
		}
		Button tempBtn;
		tempBtn = (Button) (e.getSource());
		rubikScene.rubikSolver(tempBtn.getText(), 550);
		updateStep();
	}

	public void scrambleAction(ActionEvent e) {
		if (rubikScene.getOnRotation().get() || rubikScene.getOnScramble().get()) {
			return;
		}

		List<String> scramble = new ArrayList<String>();
		String[] moves = { "F", "Fi", "B", "Bi", "U", "Ui", "D", "Di", "R", "Ri", "L", "Li" };
		int moveNum;
		int j;
		int k;
		moveNum = 18 + (int) (Math.random() * 6);
		j = (int) (Math.random() * 3);
		for (int i = 0; i < moveNum; i++) {
			do {
				k = (int) (Math.random() * 3);
			} while (k == j);
			j = k;
			scramble.add(moves[j * 4 + (int) (Math.random() * 4)]);
		}
		rubikScene.rubikSolver(scramble, 40);

	}

	public void solverAction(ActionEvent e) {
		if (rubikScene.getOnRotation().get() || rubikScene.getOnScramble().get()) {
			return;
		}
		if (this.onPlay.get()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Giving up already???");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to quit???");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rubikScene.getOnRotation().removeListener(lis);
				onPlay.set(false);
				stopTime();
				resetStep();
			} else {
				return;
			}
		}
		rubikScene.rubikSolver(rubikScene.getRubikState().solve(), 500);
	}

	public void playAction(ActionEvent e) {
		if (this.getRubikScene().getRubikState().isSolved()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Fail to start!!!");
			alert.setHeaderText(null);
			alert.setContentText("Rubik is already Solved!!!");
			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Let's go!!!");
		alert.setHeaderText(null);
		alert.setContentText("Press OK to start challenge");
		alert.showAndWait();
		this.onPlay.set(true);
		startTime();

		lis = (ov, previous, now) -> {
			if (!now) {
				if (rubikScene.getRubikState().isSolved()) {
					Alert tempAlert = new Alert(AlertType.INFORMATION);
					tempAlert.setTitle("Solved!!!");
					tempAlert.setHeaderText(null);
					tempAlert.setContentText(
							"You have solved Rubik in " + stopTime() + " and " + stepTextField.getText() + " step");
					tempAlert.setOnHidden(evt -> {
						tempAlert.close();
					});
					tempAlert.show();
					rubikScene.getOnRotation().removeListener(lis);
					resetStep();
					this.onPlay.set(false);
				}
			}
		};

		rubikScene.getOnRotation().addListener(lis);
	}

	public void startTime() {

		timeline.getKeyFrames().addAll(new KeyFrame(Duration.millis(1), event -> {

			timeLong = timeLong + 1;
			long second = (timeLong / 1000) % 60;
			long minute = (timeLong / (1000 * 60)) % 60;
			long hour = (timeLong / (1000 * 60 * 60)) % 24;

			timePlay.set(String.format("%02d:%02d:%02d", hour, minute, second));

		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.playFromStart();
	}

	public String stopTime() {
		String result = timePlay.get();
		timeline.stop();
		timeLong = 0;
		timePlay.set("00:00:00");
		return result;

	}

	public void updateStep() {
		if (onPlay.get()) {
			stepTextField.setText(String.format("%d", Integer.parseInt(stepTextField.getText()) + 1));
		}
	}

	public void resetStep() {
		stepTextField.setText("0");
	}

	public void keyAction(KeyEvent e) {
		if (this.rubikScene.getOnRotation().get() || this.rubikScene.getOnScramble().get()) {
			return;
		}

		switch (e.getCode()) {
		case UP:
			this.rubikScene.rubikSolver("X", 450);
			break;
		case DOWN:
			this.rubikScene.rubikSolver("Xi", 450);
			break;
		case LEFT:
			this.rubikScene.rubikSolver("Y", 450);
			break;
		case RIGHT:
			this.rubikScene.rubikSolver("Yi", 450);
			break;
		default:
			return;
		}
	}
}
