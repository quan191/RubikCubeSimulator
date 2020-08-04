package rubik.cubie.setup;

import java.util.Arrays;

import javafx.geometry.Point3D;

public class SetUp3x3 extends SetUp {

	private static final int[] FLD = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.ORANGE, ColorsSetUp.WHITE };
	private static final int[] FD = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] FRD = new int[] { ColorsSetUp.BLUE, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] FL = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] F = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] FR = new int[] { ColorsSetUp.BLUE, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] FLU = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] FU = new int[] { ColorsSetUp.BLUE, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] FRU = new int[] { ColorsSetUp.BLUE, ColorsSetUp.RED, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY };

	private static final Point3D pFLD = new Point3D(-1.12, 1.12, -1.12);
	private static final Point3D pFD = new Point3D(0, 1.12, -1.12);
	private static final Point3D pFRD = new Point3D(1.12, 1.12, -1.12);
	private static final Point3D pFL = new Point3D(-1.12, 0, -1.12);
	private static final Point3D pF = new Point3D(0, 0, -1.12);
	private static final Point3D pFR = new Point3D(1.12, 0, -1.12);
	private static final Point3D pFLU = new Point3D(-1.12, -1.12, -1.12);
	private static final Point3D pFU = new Point3D(0, -1.12, -1.12);
	private static final Point3D pFRU = new Point3D(1.12, -1.12, -1.12);

	// F R U B L D
	private static final int[] CLD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.ORANGE, ColorsSetUp.WHITE };
	private static final int[] CD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] CRD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] CL = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] C = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] CR = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] CLU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] CU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] CRU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.YELLOW,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY };

	private static final Point3D pCLD = new Point3D(-1.12, 1.12, 0);
	private static final Point3D pCD = new Point3D(0, 1.12, 0);
	private static final Point3D pCRD = new Point3D(1.12, 1.12, 0);
	private static final Point3D pCL = new Point3D(-1.12, 0, 0);
	private static final Point3D pC = new Point3D(0, 0, 0);
	private static final Point3D pCR = new Point3D(1.12, 0, 0);
	private static final Point3D pCLU = new Point3D(-1.12, -1.12, 0);
	private static final Point3D pCU = new Point3D(0, -1.12, 0);
	private static final Point3D pCRU = new Point3D(1.12, -1.12, 0);

	// F R U B L D
	private static final int[] BLD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY,
			ColorsSetUp.GREEN, ColorsSetUp.ORANGE, ColorsSetUp.WHITE };
	private static final int[] BD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] BRD = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.GRAY, ColorsSetUp.WHITE };
	private static final int[] BL = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] B = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] BR = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.GRAY, ColorsSetUp.GREEN,
			ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] BLU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GREEN, ColorsSetUp.ORANGE, ColorsSetUp.GRAY };
	private static final int[] BU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.GRAY, ColorsSetUp.YELLOW,
			ColorsSetUp.GREEN, ColorsSetUp.GRAY, ColorsSetUp.GRAY };
	private static final int[] BRU = new int[] { ColorsSetUp.GRAY, ColorsSetUp.RED, ColorsSetUp.YELLOW,
			ColorsSetUp.GREEN, ColorsSetUp.GRAY, ColorsSetUp.GRAY };

	private static final Point3D pBLD = new Point3D(-1.12, 1.12, 1.12);
	private static final Point3D pBD = new Point3D(0, 1.12, 1.12);
	private static final Point3D pBRD = new Point3D(1.12, 1.12, 1.12);
	private static final Point3D pBL = new Point3D(-1.12, 0, 1.12);
	private static final Point3D pB = new Point3D(0, 0, 1.12);
	private static final Point3D pBR = new Point3D(1.12, 0, 1.12);

	private static final Point3D pBLU = new Point3D(-1.12, -1.12, 1.12);
	private static final Point3D pBU = new Point3D(0, -1.12, 1.12);
	private static final Point3D pBRU = new Point3D(1.12, -1.12, 1.12);

	public SetUp3x3() {
		super();
		initpatternFaceF();
		initpointsFaceF();
	}

	private void initpatternFaceF() {
		patternFaceF = Arrays.asList(FLU,FU, FRU,FL,F,FR, FLD,FD, FRD,CLU,CU,CRU,CL,C,CR,CLD,CD,CRD, BLU,BU, BRU,BL,B,BR, BLD,BD, BRD);
	}

	private void initpointsFaceF() {
		pointsFaceF = Arrays.asList(pFLU,pFU, pFRU,pFL,pF,pFR, pFLD,pFD, pFRD,pCLU,pCU,pCRU,pCL,pC,pCR,pCLD,pCD,pCRD, pBLU,pBU, pBRU,pBL,pB,pBR, pBLD,pBD, pBRD);
	}

}
