package rubik.state;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RubikState2x2 extends RubikState {

	public RubikState2x2() {
		super(2);
	}

	public RubikState2x2(char[] positions) {
		super(positions, 2);
	}

	public HashMap<String, RubikState2x2> neighbours() {
		HashMap<String, RubikState2x2> reacheableStates = new HashMap<>();
		addBasicMove("Fi", reacheableStates);
		addBasicMove("F", reacheableStates);
		addBasicMove("Ui", reacheableStates);
		addBasicMove("U", reacheableStates);
		addBasicMove("Ri", reacheableStates);
		addBasicMove("R", reacheableStates);
		addBasicMove("Bi", reacheableStates);
		addBasicMove("B", reacheableStates);
		addBasicMove("Di", reacheableStates);
		addBasicMove("D", reacheableStates);
		addBasicMove("Li", reacheableStates);
		addBasicMove("L", reacheableStates);
		return reacheableStates;
	}

	private void addBasicMove(String name, HashMap<String, RubikState2x2> moves) {
		RubikState2x2 state = new RubikState2x2(this.getPositions());
		state.executeMoveSeq(name);
		moves.put(name, state);
	}

	@Override
	public void executeMoveSeq(String seq) {
		switch (seq) {
		case "F":
			this.rotateFaceBorder(frontFace, true);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(upFace, 1), this.getColumnFace(rightFace, 0),
					reverseIntArray(this.getRowFace(downFace, 0)), reverseIntArray(this.getColumnFace(leftFace, 1)) });
			break;
		case "Fi":

			this.rotateFaceBorder(frontFace, false);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getRowFace(upFace, 1), this.getColumnFace(rightFace, 0),
							reverseIntArray(this.getRowFace(downFace, 0)),
							reverseIntArray(this.getColumnFace(leftFace, 1)) });
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
					new int[][] { this.getColumnFace(upFace, 1), reverseIntArray(this.getColumnFace(backFace, 0)),
							this.getColumnFace(downFace, 1), this.getColumnFace(frontFace, 1) });
			break;
		case "Ri":
			this.rotateFaceBorder(rightFace, false);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getColumnFace(upFace, 1), reverseIntArray(this.getColumnFace(backFace, 0)),
							this.getColumnFace(downFace, 1), this.getColumnFace(frontFace, 1) });
			break;
		case "B":
			this.rotateFaceBorder(backFace, true);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getRowFace(upFace, 0), this.getColumnFace(rightFace, 1),
							reverseIntArray(this.getRowFace(downFace, 1)),
							reverseIntArray(this.getColumnFace(leftFace, 0)) });
			break;
		case "Bi":
			this.rotateFaceBorder(backFace, false);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(upFace, 0), this.getColumnFace(rightFace, 1),
					reverseIntArray(this.getRowFace(downFace, 1)), reverseIntArray(this.getColumnFace(leftFace, 0)) });
			break;
		case "D":
			this.rotateFaceBorder(downFace, true);

			this.roateRowColunm(counterClockWise, new int[][] { this.getRowFace(backFace, 1),
					this.getRowFace(rightFace, 1), this.getRowFace(frontFace, 1), this.getRowFace(leftFace, 1) });
			break;
		case "Di":
			this.rotateFaceBorder(downFace, false);

			this.roateRowColunm(clockWise, new int[][] { this.getRowFace(backFace, 1), this.getRowFace(rightFace, 1),
					this.getRowFace(frontFace, 1), this.getRowFace(leftFace, 1) });
			break;
		case "L":
			this.rotateFaceBorder(leftFace, true);

			this.roateRowColunm(counterClockWise,
					new int[][] { this.getColumnFace(upFace, 0), reverseIntArray(this.getColumnFace(backFace, 1)),
							this.getColumnFace(downFace, 0), this.getColumnFace(frontFace, 0) });
			break;
		case "Li":
			this.rotateFaceBorder(leftFace, false);

			this.roateRowColunm(clockWise,
					new int[][] { this.getColumnFace(upFace, 0), reverseIntArray(this.getColumnFace(backFace, 1)),
							this.getColumnFace(downFace, 0), this.getColumnFace(frontFace, 0) });
			break;
		case "X": {
			this.executeMoveSeq("R");
			this.executeMoveSeq("Li");
			break;
		}
		case "Xi": {
			this.executeMoveSeq("Ri");
			this.executeMoveSeq("L");
			break;
		}
		case "Y": {
			this.executeMoveSeq("U");
			this.executeMoveSeq("Di");
			break;
		}
		case "Yi": {
			this.executeMoveSeq("Ui");
			this.executeMoveSeq("D");
			break;
		}
		case "Z": {
			this.executeMoveSeq("F");
			this.executeMoveSeq("Bi");
			break;
		}
		case "Zi": {
			this.executeMoveSeq("Fi");
			this.executeMoveSeq("B");
			break;
		}
		default:
			return;
		}
	}

	private String reverseMove(String move) {
		String temp = "";
		if (move == null)
			return temp;
		if (move.length() == 2) {
			temp += move.substring(0, 1);
		} else
			temp += move + "i";
		return temp;
	}

	private List<String> reverseMoves(List<String> moves) {
		List<String> newMoves = new ArrayList<String>();
		for (int i = 0; i < moves.size(); i++) {
			newMoves.add(reverseMove(moves.get(i)));
		}
		Collections.reverse(newMoves);
		return newMoves;
	}

	private List<String> solution(RubikState2x2 state, HashMap<RubikState2x2, String> parents) {
		String temp = parents.get(state);
		List<String> solution = new ArrayList<String>();
		if (temp != null) {
			solution.add(temp);
			RubikState2x2 next = new RubikState2x2(state.getPositions());
			next.executeMoveSeq(reverseMove(temp));
			while (parents.get(next) != null) {
				temp = parents.get(next);
				solution.add(temp);
				next.executeMoveSeq(reverseMove(temp));
			}
		}
		Collections.reverse(solution);
		return solution;
	}
	
	
	@Override
	public List<String> solve() {

		RubikState2x2 state = this;
		if (state.isSolved()) {
			return null;
		}

		List<String> result;
		List<String> result2;

		HashMap<RubikState2x2, String> bParents = new HashMap<RubikState2x2, String>();
		HashMap<RubikState2x2, String> fParents = new HashMap<RubikState2x2, String>();
		ArrayDeque<RubikState2x2> bQueue = new ArrayDeque<RubikState2x2>();
		ArrayDeque<RubikState2x2> fQueue = new ArrayDeque<RubikState2x2>();

		RubikState2x2 src = state;
		RubikState2x2 end = new RubikState2x2();
		fParents.put(end, null);
		fQueue.add(end);

		bParents.put(src, null);
		bQueue.add(src);
		while (true) {
			src = bQueue.remove();
			for (Entry<String, RubikState2x2> move : src.neighbours().entrySet()) {
				if (!bParents.containsKey(move.getValue())) {
					bParents.put(move.getValue(), move.getKey());
					bQueue.add(move.getValue());
				}
				if (move.getValue().isSolved()) {
					result = solution(move.getValue(), bParents);
					return result;
				}

			}
			end = fQueue.remove();
			for (Entry<String, RubikState2x2> move : end.neighbours().entrySet()) {
				if (!fParents.containsKey(move.getValue())) {
					fParents.put(move.getValue(), move.getKey());
					fQueue.add(move.getValue());
				}
				// same state discovered in both ends of search
				if (bParents.containsKey(move.getValue())) {
					result = solution(move.getValue(), bParents);
					result2 = solution(move.getValue(), fParents);
					result2 = reverseMoves(result2);
					result.addAll(result2);
					return result;
				}
			}

		}
	}
}
