package rubik.cubie.properties;

import java.util.List;

import javafx.geometry.Point3D;

public abstract class CubieProperties {

	protected List<int[]> patternFaceF; 

	protected List<Point3D> pointsFaceF;

	public List<int[]> getPatternFaceF() {
		return patternFaceF;
	}

	public List<Point3D> getPointsFaceF() {
		return pointsFaceF;
	}
}
