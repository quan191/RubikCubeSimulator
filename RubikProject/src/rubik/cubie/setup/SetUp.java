package rubik.cubie.setup;

import java.util.List;
import java.util.Map;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import rubik.cubie.Cubie;
import rubik.cubie.CubieView;

public abstract class SetUp {

	protected List<int[]> patternFaceF; 

	protected List<Point3D> pointsFaceF;

	public List<int[]> getPatternFaceF() {
		return patternFaceF;
	}

	public List<Point3D> getPointsFaceF() {
		return pointsFaceF;
	}
	public Group makeRubik(Map<Integer, CubieView> mapMeshes) {
		PhongMaterial mat = new PhongMaterial();
		
		Image temp = new Image(getClass().getResourceAsStream("2.png"));
		mat.setDiffuseMap(temp);
		Group meshGroup = new Group();
		for (int i = 0; i < this.getPatternFaceF().size(); i++) {
			CubieView meshP = new CubieView(this.getPointsFaceF().get(i),
					new Cubie(this.getPatternFaceF().get(i)), mat);
			mapMeshes.put(i + 1, meshP);
			meshGroup.getChildren().add(meshP);
		}
		return meshGroup;
	}
}
