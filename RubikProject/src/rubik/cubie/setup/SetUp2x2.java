package rubik.cubie.setup;

import java.util.Arrays;

import javafx.geometry.Point3D;

public class SetUp2x2 extends SetUp {

	private static final int[] FLD = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.ORANGE, ColorsSetUp.WHITE };

	private static final int[] FRD = new int[] { ColorsSetUp.BLUE, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };

	private static final int[] FLU = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.ORANGE, ColorsSetUp.GRAY };

	private static final int[] FRU = new int[] { ColorsSetUp.BLUE, ColorsSetUp.RED, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY };

	private static final Point3D pFLD = new Point3D(-0.53, 0.53, -0.53);

	private static final Point3D pFRD = new Point3D(0.53, 0.53, -0.53);

	private static final Point3D pFLU = new Point3D(-0.53, -0.53, -0.53);

	private static final Point3D pFRU = new Point3D(0.53, -0.53, -0.53);

	private static final int[] BLD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GREEN, ColorsSetUp.ORANGE, ColorsSetUp.WHITE };

	private static final int[] BRD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };

	private static final int[] BLU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GREEN, ColorsSetUp.ORANGE, ColorsSetUp.GRAY };;
	private static final int[] BRU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.YELLOW,
			ColorsSetUp.GREEN, ColorsSetUp.GRAY, ColorsSetUp.GRAY };

	private static final Point3D pBLD = new Point3D(-0.53, 0.53, 0.53);

	private static final Point3D pBRD = new Point3D(0.53, 0.53, 0.53);

	private static final Point3D pBLU = new Point3D(-0.53, -0.53, 0.53);

	private static final Point3D pBRU = new Point3D(0.53, -0.53, 0.53);

	public SetUp2x2() {
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
