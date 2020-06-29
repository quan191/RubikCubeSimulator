package rubik.cubie.index;

import java.util.List;

public class CubieIndexes3x3 extends CubieIndexes {
	public CubieIndexes3x3() {
		super(3);
	}
	@Override
	public void turn(String rotate) {
		int t = 0;
		for (int y = 2; y >= 0; --y) {
			for (int x = 0; x < 3; x++) {
				switch (rotate) {
				case "L":
					tempCube[x][t][0] = cube[y][x][0];
					break;
				case "Li":
					tempCube[t][x][0] = cube[x][y][0];
					break;
				case "M":
					tempCube[x][t][1] = cube[y][x][1];
					break;
				case "Mi":
					tempCube[t][x][1] = cube[x][y][1];
					break;
				case "R":
					tempCube[t][x][2] = cube[x][y][2];
					break;
				case "Ri":
					tempCube[x][t][2] = cube[y][x][2];
					break;
				case "U":
					tempCube[t][0][x] = cube[x][0][y];
					break;
				case "Ui":
					tempCube[x][0][t] = cube[y][0][x];
					break;
				case "E":
					tempCube[x][1][t] = cube[y][1][x];
					break;
				case "Ei":
					tempCube[t][1][x] = cube[x][1][y];
					break;
				case "D":
					tempCube[x][2][t] = cube[y][2][x];
					break;
				case "Di":
					tempCube[t][2][x] = cube[x][2][y];
					break;
				case "F":
					tempCube[0][x][t] = cube[0][y][x];
					break;
				case "Fi":
					tempCube[0][t][x] = cube[0][x][y];
					break;
				case "S":
					tempCube[1][x][t] = cube[1][y][x];
					break;
				case "Si":
					tempCube[1][t][x] = cube[1][x][y];
					break;
				case "B":
					tempCube[2][t][x] = cube[2][x][y];
					break;
				case "Bi":
					tempCube[2][x][t] = cube[2][y][x];
					break;
				case "X":
					tempCube[t][x][2] = cube[x][y][2];
					tempCube[t][x][1] = cube[x][y][1];
					tempCube[t][x][0] = cube[x][y][0];
					break;
				case "Xi":
					tempCube[x][t][2] = cube[y][x][2];
					tempCube[x][t][1] = cube[y][x][1];
					tempCube[x][t][0] = cube[y][x][0];
					break;
				case "Y":
					tempCube[t][0][x] = cube[x][0][y];
					tempCube[t][1][x] = cube[x][1][y];
					tempCube[t][2][x] = cube[x][2][y];
					break;
				case "Yi":
					tempCube[x][0][t] = cube[y][0][x];
					tempCube[x][1][t] = cube[y][1][x];
					tempCube[x][2][t] = cube[y][2][x];
					break;
				}
			}
			t++;
		}

		save();
	}
	
	@Override
	public List<Integer> getWhatToTurn(String rotate) {
		List<Integer> layer = super.getWhatToTurn(rotate);
		
		if (getCenter(rotate) >= 0) {
			layer.add(this.getCube().get(getCenter(rotate) - 1));
		}
		if (rotate.contains("X")) {
			layer.add(this.getCube().get(getCenter("L")-1));
			layer.add(this.getCube().get(getCenter("R")-1));
		}
		if (rotate.contains("Y")) {
			layer.add(this.getCube().get(getCenter("U")-1));
			layer.add(this.getCube().get(getCenter("D")-1));
		}
		if(rotate.contains("Z")) {
			layer.add(this.getCube().get(getCenter("F")-1));
			layer.add(this.getCube().get(getCenter("B")-1));
		}
		return layer;
	}

	private static Integer getCenter(String face) {
		Integer p = -1;
		switch (face.substring(0, 1)) {
		case "L":
			p = 13;
			break;
		case "R":
			p = 15;
			break;
		case "U":
			p = 11;
			break;
		case "D":
			p = 17;
			break;
		case "F":
			p = 5;
			break;
		case "B":
			p = 23;
			break;
		}
		return p;
	}

}
