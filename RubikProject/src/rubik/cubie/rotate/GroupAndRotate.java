package rubik.cubie.rotate;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Point3D;
import javafx.util.Duration;
import rubik.cubie.CubieView;

public class GroupAndRotate {
	
	private List<CubieView> cubieView = new ArrayList<CubieView>();
	
	public void addCubieView(CubieView cubieView) {
		if(!this.cubieView.contains(cubieView))
			this.cubieView.add(cubieView);
	}
	
	public void clearCubieView() {
		this.cubieView.clear();
	}

	public GroupAndRotate() {
		// TODO Auto-generated constructor stub
	}
	
	public void rotateAnimation(Point3D axis, double angle, double animationTime, BooleanProperty onRotation) {
		ChangeListener<Number> rotMap;
		rotMap = (ov, angOld, angNew) -> {
			for(int i = 0;i<this.cubieView.size();i++) {
				this.cubieView.get(i).matrixTransform(angOld.doubleValue(), angNew.doubleValue(), axis);
			}
		};
		
		DoubleProperty rotation = new SimpleDoubleProperty(0d);
		rotation.addListener(rotMap);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(animationTime), e -> {
			// remove listener
			rotation.removeListener(rotMap);
			onRotation.set(false);
		}, new KeyValue(rotation, angle)));
		timeline.playFromStart();
	}

}
