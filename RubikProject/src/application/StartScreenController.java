package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rubik.scene.RubikScene;
import rubik.scene.RubikScene2x2;
import rubik.scene.RubikScene3x3;

public class StartScreenController implements Initializable {

	private RubikScreenController guiController;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private ImageView Image2x2;

	@FXML
	private ImageView Image3x3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		Image2x2.setOpacity(0.8);
		Image3x3.setOpacity(0.8);
	}

	public void Init3x3(MouseEvent event) {
		initRubik(new RubikScene3x3(new Group(), 340, 300, -15),"3x3");
	}

	public void Init2x2(MouseEvent event) {
		initRubik(new RubikScene2x2(new Group(), 340, 300, -10),"2x2");
	}

	private void initRubik(RubikScene rubikScene, String title) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("RubikScreen.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			guiController = fxmlLoader.getController();
			guiController.setRubikScene(rubikScene);
			guiController.setUpRubikScene();
			guiController.setParentStage(stage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void Enlarge(ImageView image) {
		image.setTranslateX(image.getTranslateX() - 10);
		image.setTranslateY(image.getTranslateY() - 10);
		image.setFitHeight(image.getFitHeight() + 20);
		image.setFitWidth(image.getFitWidth() + 20);
		Glow glow = new Glow();
		glow.setLevel(0.3);
		image.setOpacity(1);
		image.setEffect(glow);
	}

	private void Shrink(ImageView image) {
		image.setTranslateX(image.getTranslateX() + 10);
		image.setTranslateY(image.getTranslateY() + 10);
		image.setFitHeight(image.getFitHeight() - 20);
		image.setFitWidth(image.getFitWidth() - 20);
		Glow glow = new Glow();
		glow.setLevel(0);
		image.setOpacity(0.8);
		image.setEffect(glow);
	}

	public void Enlarge2x2(MouseEvent event) {
		Enlarge(Image2x2);
		Image3x3.setOpacity(0.2);
	}

	public void Shrink2x2(MouseEvent event) {
		Shrink(Image2x2);
		Image3x3.setOpacity(0.8);
	}

	public void Enlarge3x3(MouseEvent event) {
		Enlarge(Image3x3);
		Image2x2.setOpacity(0.2);
	}

	public void Shrink3x3(MouseEvent event) {
		Shrink(Image3x3);
		Image2x2.setOpacity(0.8);
	}

}
