package rubik.cubie;

import javafx.geometry.Point3D;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class CubieView extends MeshView{

	public CubieView(Point3D point, Cubie cubie, PhongMaterial mat) {
		super();
		this.setMesh(cubie);
		this.setMaterial(mat);
		this.getTransforms().addAll(new Translate(point.getX(), point.getY(), point.getZ()));
	}
	
	public void rotate(double oldAngle, double newAngle, Point3D axis) {
		Affine a = new Affine(this.getTransforms().get(0));
		a.prepend(new Rotate(newAngle - oldAngle,axis));
		System.out.println(a);
		this.getTransforms().setAll(a);
		
	}

}
