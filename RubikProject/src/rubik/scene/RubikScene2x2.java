package rubik.scene;

import javafx.scene.Group;
import rubik.cubie.index.CubieIndexes2x2;
import rubik.cubie.properties.CubieProperties2x2;
import rubik.state.RubikState2x2;

public class RubikScene2x2 extends RubikScene {

	public RubikScene2x2(Group subSceneRoot, double height, double width, float zView) {
		super(subSceneRoot, height, width);
		this.guiRubik = new CubieProperties2x2();
		this.rubikState = new RubikState2x2();
		this.rot = new CubieIndexes2x2();
		this.setUpRubik(subSceneRoot,zView);
	}
	
}