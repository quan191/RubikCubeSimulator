package rubik.state;

import java.util.List;

public class RubikState3x3 extends RubikState {

	public RubikState3x3() {
		// create a solved cube
		super(3);
	}

	public RubikState3x3(char[] positions) {
		super(positions, 3);
	}
	
	@Override
	public List<String> solve() {
		return null;
	}

	@Override
	public void executeMoveSeq(String seq) {
		switch (seq) {
		case "F":
			this.rotateFaceBorder(frontFace, true);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(upFace, 2), this.getColumnFace(rightFace, 0),
					reverseIntArray(this.getRowFace(downFace, 0)), reverseIntArray(this.getColumnFace(leftFace, 2)) });
			break;
		case "Fi":

			this.rotateFaceBorder(frontFace, false);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getRowFace(upFace, 2), this.getColumnFace(rightFace, 0),
							reverseIntArray(this.getRowFace(downFace, 0)),
							reverseIntArray(this.getColumnFace(leftFace, 2)) });
			break;
		case "U":
			// positions = permApply(U);
			this.rotateFaceBorder(upFace, true);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(backFace, 0), this.getRowFace(rightFace, 0),
					this.getRowFace(frontFace, 0), this.getRowFace(leftFace, 0) });
			break;
		case "Ui":
			this.rotateFaceBorder(upFace, false);

			this.roateRowColunm(counterClockWise, new int[][] { this.getRowFace(backFace, 0),
					this.getRowFace(rightFace, 0), this.getRowFace(frontFace, 0), this.getRowFace(leftFace, 0) });
			break;
		case "R":
			this.rotateFaceBorder(rightFace, true);

			this.roateRowColunm(clockWise,
					new int[][] { this.getColumnFace(upFace, 2), reverseIntArray(this.getColumnFace(backFace, 0)),
							this.getColumnFace(downFace, 2), this.getColumnFace(frontFace, 2) });
			break;
		case "Ri":
			this.rotateFaceBorder(rightFace, false);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getColumnFace(upFace, 2), reverseIntArray(this.getColumnFace(backFace, 0)),
							this.getColumnFace(downFace, 2), this.getColumnFace(frontFace, 2) });
			break;
		case "B":
			this.rotateFaceBorder(backFace, true);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getRowFace(upFace, 0), this.getColumnFace(rightFace, 2),
							reverseIntArray(this.getRowFace(downFace, 2)),
							reverseIntArray(this.getColumnFace(leftFace, 0)) });
			break;
		case "Bi":
			this.rotateFaceBorder(backFace, false);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(upFace, 0), this.getColumnFace(rightFace, 2),
					reverseIntArray(this.getRowFace(downFace, 2)), reverseIntArray(this.getColumnFace(leftFace, 0)) });
			break;
		case "D":
			this.rotateFaceBorder(downFace, true);

			this.roateRowColunm(counterClockWise, new int[][] { this.getRowFace(backFace, 2),
					this.getRowFace(rightFace, 2), this.getRowFace(frontFace, 2), this.getRowFace(leftFace, 2) });
			break;
		case "Di":
			this.rotateFaceBorder(downFace, false);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(backFace, 2), this.getRowFace(rightFace, 2),
					this.getRowFace(frontFace, 2), this.getRowFace(leftFace, 2) });
			break;
		case "L":
			this.rotateFaceBorder(leftFace, true);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getColumnFace(upFace, 0), reverseIntArray(this.getColumnFace(backFace, 2)),
							this.getColumnFace(downFace, 0), this.getColumnFace(frontFace, 0) });
			break;
		case "Li":
			this.rotateFaceBorder(leftFace, false);

			this.roateRowColunm(clockWise,
					new int[][] { this.getColumnFace(upFace, 0), reverseIntArray(this.getColumnFace(backFace, 2)),
							this.getColumnFace(downFace, 0), this.getColumnFace(frontFace, 0) });
			break;
		case "X": {
			this.executeMoveSeq("R");
			this.roateRowColunm(clockWise,
					new int[][] { this.getColumnFace(upFace, 1), reverseIntArray(this.getColumnFace(backFace, 1)),
							this.getColumnFace(downFace, 1), this.getColumnFace(frontFace, 1) });
			this.executeMoveSeq("Li");
			
			break;
		}
		case "Xi": {
			this.executeMoveSeq("Ri");
			this.roateRowColunm(counterClockWise,
					new int[][] { this.getColumnFace(upFace, 1), reverseIntArray(this.getColumnFace(backFace, 1)),
							this.getColumnFace(downFace, 1), this.getColumnFace(frontFace, 1) });
			this.executeMoveSeq("L");
			break;
		}
		case "Y": {
			this.executeMoveSeq("U");
			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(backFace, 1), this.getRowFace(rightFace, 1),
				this.getRowFace(frontFace, 1), this.getRowFace(leftFace, 1) });
			this.executeMoveSeq("Di");
			break;
		}
		case "Yi": {
			this.executeMoveSeq("Ui");
			this.roateRowColunm(counterClockWise, new int[][] { this.getRowFace(backFace, 1), this.getRowFace(rightFace, 1),
				this.getRowFace(frontFace, 1), this.getRowFace(leftFace, 1) });
			this.executeMoveSeq("D");
			break;
		}
		case "Z": {
			this.executeMoveSeq("F");
			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(upFace, 1), this.getColumnFace(rightFace, 1),
				reverseIntArray(this.getRowFace(downFace, 1)), reverseIntArray(this.getColumnFace(leftFace, 1)) });
			this.executeMoveSeq("Bi");
			break;
		}
		case "Zi": {
			this.executeMoveSeq("Fi");
			this.roateRowColunm(counterClockWise, new int[][] { this.getRowFace(upFace, 1), this.getColumnFace(rightFace, 1),
				reverseIntArray(this.getRowFace(downFace, 1)), reverseIntArray(this.getColumnFace(leftFace, 1)) });
			this.executeMoveSeq("B");
			break;
		}
		default:
			return;
		}
	}
}
