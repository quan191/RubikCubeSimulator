package rubik.scene;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;
import rubik.cubie.Cubie;
import rubik.cubie.CubieView;
import rubik.cubie.rotate.CubieIndexes;
import rubik.cubie.rotate.GroupAndRotate;
import rubik.cubie.setup.SetUp;
import rubik.state.RubikState;

public abstract class RubikScene extends SubScene {

	protected final Map<Integer, CubieView> mapMeshes = new HashMap<>();

	protected RubikState rubikState;

	protected GroupAndRotate rubikLayer = new GroupAndRotate();

	public RubikState getRubikState() {
		return rubikState;
	}

	protected CubieIndexes cubieIndexes;

	protected final BooleanProperty onRotation = new SimpleBooleanProperty(false);
	protected final BooleanProperty onScramble = new SimpleBooleanProperty(false);

	public BooleanProperty getOnRotation() {
		return onRotation;
	}

	public BooleanProperty getOnScramble() {
		return onScramble;
	}

	protected SetUp guiRubik;

	public RubikScene(Group subSceneRoot, double height, double width) {
		super(subSceneRoot, height, width, true, SceneAntialiasing.BALANCED);
	}

	protected void setUpRubik(Group subSceneRoot, float z) {
		this.setFill(Color.BLACK);
		//this.setPickOnBounds(true);
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setNearClip(0.1);
		camera.setFarClip(10000.0);
		camera.setTranslateZ(z);

		this.setCamera(camera);

		Group meshGroup=guiRubik.makeRubik(mapMeshes);

		/*for (int i = 0; i < guiRubik.getPatternFaceF().size(); i++) {
			CubieView meshP = new CubieView(guiRubik.getPointsFaceF().get(i),
					new Cubie(guiRubik.getPatternFaceF().get(i)), mat);
			mapMeshes.put(i + 1, meshP);
			meshGroup.getChildren().add(meshP);
		}*/

		Rotate rotateX = new Rotate(30, 0, 0, 0, Rotate.X_AXIS);
		Rotate rotateY = new Rotate(20, 0, 0, 0, Rotate.Y_AXIS);
		subSceneRoot.getTransforms().addAll(rotateX, rotateY);
		subSceneRoot.getChildren().addAll(meshGroup, new AmbientLight(Color.WHITE));
	}

	public void rubikSolver(List<String> solution, double animationTime) {
		if (solution == null)
			return;
		if (solution.size() == 0) {
			return;
		}
		this.onScramble.set(true);
		IntegerProperty index = new SimpleIntegerProperty(1);
		index.set(1);
		ChangeListener<Boolean> lis = (ov, b, b1) -> {
			if (!b1) {
				if (index.get() < solution.size()) {
					rubikSolver(solution.get(index.get()), animationTime);
				}
				index.set(index.get() + 1);
			}
		};

		index.addListener((ov, v, v1) -> {
			if (v1.intValue() == solution.size() + 1) {
				onRotation.removeListener(lis);
				this.onScramble.set(false);

			}
		});
		onRotation.addListener(lis);
		rubikSolver(solution.get(0), animationTime);

	}

	public void rubikSolver(String solution, double animationTime) {
		if (solution == null)
			return;
		rotateFace(solution, animationTime);

	}

	public void rotateFace(String btRot, double animationTime) {
		if (onRotation.get()) {
			return;
		}

		rubikState.executeMoveSeq(btRot);

		onRotation.set(true);
		
		double angEnd = 90d * (btRot.endsWith("i") ? 1d : -1d);

		setUpLayer(btRot);
		
		rubikLayer.rotateAnimation(getAxis(btRot), angEnd, animationTime, onRotation);
	}

	protected void setUpLayer(String btRot) {
		rubikLayer.clearCubieView();

		List<Integer> layer = cubieIndexes.getWhatToTurn(btRot);
		mapMeshes.forEach((k, v) -> {
			layer.stream().filter(l -> k == l).findFirst().ifPresent(l -> {
				rubikLayer.addCubieView(v);
			});
		});
	}

	protected static Point3D getAxis(String face) {
		Point3D p = new Point3D(0, 0, 0);
		switch (face.substring(0, 1)) {
		case "L":
			p = new Point3D(-1, 0, 0);
			break;
		case "R":
			p = new Point3D(1, 0, 0);
			break;
		case "U":
			p = new Point3D(0, -1, 0);
			break;
		case "D":
			p = new Point3D(0, 1, 0);
			break;
		case "F":
			p = new Point3D(0, 0, -1);
			break;
		case "B":
			p = new Point3D(0, 0, 1);
			break;
		case "X":
			p = new Point3D(1, 0, 0);
			break;
		case "Y":
			p = new Point3D(0, -1, 0);
			break;
		case "Z":
			p = new Point3D(0, 0, 1);
			break;
		}
		return p;
	}
}