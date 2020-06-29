package rubik.state;

import java.util.Arrays;
import java.util.List;

abstract public class RubikState implements Solvable {
	protected static final int[] clockWise = { 3, 0, 1, 2 };

	protected static final int[] counterClockWise = { 1, 2, 3, 0 };

	protected static final char[] colors = { 'y', 'o', 'b', 'r', 'w', 'g' };

	protected static final int upFace = 0;
	protected static final int leftFace = 1;
	protected static final int frontFace = 2;
	protected static final int rightFace = 3;
	protected static final int downFace = 4;
	protected static final int backFace = 5;

	protected final int[] stateIndex;
	protected char[] positions;

	public char[] getPositions() {
		return positions;
	}

	protected int n;

	protected int[] getFaceIndex(int face) {
		return Arrays.copyOfRange(stateIndex, face * n * n, face * n * n + n * n);
	}

	protected int[] getRowFace(int face, int rowNum) {
		int[] temp = new int[this.n];
		for (int i = 0; i < n; i++) {
			temp[i] = this.stateIndex[face * n * n + rowNum * n + i];
		}
		return temp;
	}

	protected int[] getColumnFace(int face, int columnNum) {

		int[] temp = new int[this.n];
		for (int i = 0; i < n; i++) {
			temp[i] = this.stateIndex[face * n * n + i * n + columnNum];
		}
		return temp;
	}

	protected void rotateFaceBorder(int face, boolean isClockWise) {
		if (isClockWise) {
			this.roateRowColunm(clockWise, new int[][] { reverseIntArray(this.getColumnFace(face, 0)),
					this.getRowFace(face, 0), this.getColumnFace(face, this.n-1), reverseIntArray(this.getRowFace(face, this.n-1)) });
		} else
			this.roateRowColunm(counterClockWise, new int[][] { reverseIntArray(this.getColumnFace(face, 0)),
					this.getRowFace(face, 0), this.getColumnFace(face, this.n-1), reverseIntArray(this.getRowFace(face, this.n-1)) });
	}

	protected static int[] reverseIntArray(int[] n) {
		int k = n.length;
		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = n[k - 1 - i];
		}
		return temp;
	}

	protected void roateRowColunm(int[] direction, int[][] rowColumn) {
		char[] temp = Arrays.copyOfRange(this.positions, 0, n * n * 6);
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < this.n; i++) {
				temp[rowColumn[j][i]] = this.positions[rowColumn[direction[j]][i]];
			}
		}
		this.positions = temp;
	}

	public void printPosition() {
		for (int i = 0; i < n * n * 6; i++) {
			System.out.printf("%c, ", this.positions[i]);
		}
		System.out.println();
	}

	public RubikState(int n) {
		this.n = n;
		stateIndex = new int[n * n * 6];
		for (int i = 0; i < n * n * 6; i++) {
			this.stateIndex[i] = i;
		}
		this.positions = new char[n * n * 6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < n * n; j++) {
				this.positions[i * n * n + j] = colors[i];
			}
		}
	}

	public RubikState(char[] positions, int n) {
		this.n = n;
		this.positions = positions;
		stateIndex = new int[n * n * 6];
		for (int i = 0; i < n * n * 6; i++) {
			this.stateIndex[i] = i;
		}
	}

	public char[] permApply(int[] perm) {
		char[] newPositions = new char[perm.length];
		for (int i = 0; i < perm.length; i++) {
			newPositions[i] = positions[perm[i]];
		}
		return newPositions;
	}

	@Override
	public int hashCode() {
		return Arrays.toString(this.positions).hashCode();
	}

	public boolean isSolved() {
		char temp;
		for (int i = 0; i < 6; i++) {
			temp = this.positions[i * n * n];
			for (int j = 1; j < n * n; j++) {
				if (this.positions[i * n * n + j] != temp)
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RubikState))
			return false;
		RubikState state = (RubikState) obj;
		if (state.n != this.n)
			return false;
		for (int i = 0; i < this.n * n * 6; i++) {
			if (this.positions[i] != state.positions[i])
				return false;
		}
		return true;
	}

	public void executeMoveSeq(String seq) {
		System.out.println(seq);
	}
	
	abstract public List<String> solve();

}
