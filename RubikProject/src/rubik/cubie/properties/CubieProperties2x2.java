package rubik.cubie.properties;

import java.util.Arrays;

import javafx.geometry.Point3D;
import rubik.RubikColors;

public class CubieProperties2x2 extends CubieProperties {

	private static final int[] FLD = new int[] { RubikColors.BLUE, RubikColors.GRAY, RubikColors.GRAY, RubikColors.GRAY,
			RubikColors.ORANGE, RubikColors.WHITE };

	private static final int[] FRD = new int[] { RubikColors.BLUE, RubikColors.RED, RubikColors.GRAY, RubikColors.GRAY,
			RubikColors.GRAY, RubikColors.WHITE };

	private static final int[] FLU = new int[] { RubikColors.BLUE, RubikColors.GRAY, RubikColors.YELLOW,
			RubikColors.GRAY, RubikColors.ORANGE, RubikColors.GRAY };

	private static final int[] FRU = new int[] { RubikColors.BLUE, RubikColors.RED, RubikColors.YELLOW,
			RubikColors.GRAY, RubikColors.GRAY, RubikColors.GRAY };

	private static final Point3D pFLD = new Point3D(-0.53, 0.53, -0.53);

	private static final Point3D pFRD = new Point3D(0.53, 0.53, -0.53);

	private static final Point3D pFLU = new Point3D(-0.53, -0.53, -0.53);

	private static final Point3D pFRU = new Point3D(0.53, -0.53, -0.53);

	private static final int[] BLD = new int[] { RubikColors.GRAY, RubikColors.GRAY, RubikColors.GRAY,
			RubikColors.GREEN, RubikColors.ORANGE, RubikColors.WHITE };

	private static final int[] BRD = new int[] { RubikColors.GRAY, RubikColors.RED, RubikColors.GRAY, RubikColors.GREEN,
			RubikColors.GRAY, RubikColors.WHITE };

	private static final int[] BLU = new int[] { RubikColors.GRAY, RubikColors.GRAY, RubikColors.YELLOW,
			RubikColors.GREEN, RubikColors.ORANGE, RubikColors.GRAY };;
	private static final int[] BRU = new int[] { RubikColors.GRAY, RubikColors.RED, RubikColors.YELLOW,
			RubikColors.GREEN, RubikColors.GRAY, RubikColors.GRAY };

	private static final Point3D pBLD = new Point3D(-0.53, 0.53, 0.53);

	private static final Point3D pBRD = new Point3D(0.53, 0.53, 0.53);

	private static final Point3D pBLU = new Point3D(-0.53, -0.53, 0.53);

	private static final Point3D pBRU = new Point3D(0.53, -0.53, 0.53);

	public CubieProperties2x2() {
		super();
		initpatternFaceF();
		initpointsFaceF();
	}

	private void initpatternFaceF() {
		patternFaceF = Arrays.asList(FLU, FRU, FLD, FRD, BLU, BRU, BLD, BRD);
	}

	private void initpointsFaceF() {
		pointsFaceF = Arrays.asList(pFLU, pFRU, pFLD, pFRD, pBLU, pBRU, pBLD, pBRD);
	}

}
