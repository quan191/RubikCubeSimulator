package rubik.scene;

import javafx.scene.Group;
import rubik.cubie.index.CubieIndexes3x3;
import rubik.cubie.properties.CubieProperties3x3;
import rubik.state.RubikState3x3;

public class RubikScene3x3 extends RubikScene {

	public RubikScene3x3(Group subSceneRoot, double height, double width, float zView) {
		super(subSceneRoot, height, width);
		this.guiRubik = new CubieProperties3x3();
		this.rubikState = new RubikState3x3();
		this.rot = new CubieIndexes3x3();
		this.setUpRubik(subSceneRoot, zView);
	}

	

}