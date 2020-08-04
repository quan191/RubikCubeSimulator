package rubik.cubie.rotate;

public class CubieIndexes2x2 extends CubieIndexes {

	public CubieIndexes2x2() {
		super(2);
	}
	
	@Override
	public void turn(String rotate) {
		
		int t = 0;
		for (int y = 1; y >= 0; --y) {
			for (int x = 0; x < 2; x++) {
				switch (rotate) {
				case "L":
					tempCube[x][t][0] = cube[y][x][0];
					break;
				case "Li":
					tempCube[t][x][0] = cube[x][y][0];
					break;
				case "R":
					tempCube[t][x][1] = cube[x][y][1];
					break;
				case "Ri":
					tempCube[x][t][1] = cube[y][x][1];
					break;
				case "U":
					tempCube[t][0][x] = cube[x][0][y];
					break;
				case "Ui":
					tempCube[x][0][t] = cube[y][0][x];
					break;
				case "D":
					tempCube[x][1][t] = cube[y][1][x];
					break;
				case "Di":
					tempCube[t][1][x] = cube[x][1][y];
					break;
				case "F":
					tempCube[0][x][t] = cube[0][y][x];
					break;
				case "Fi":
					tempCube[0][t][x] = cube[0][x][y];
					break;
				case "B":
					tempCube[1][t][x] = cube[1][x][y];
					break;
				case "Bi":
					tempCube[1][x][t] = cube[1][y][x];
					break;
				case "X":{
					tempCube[t][x][1] = cube[x][y][1];
					tempCube[t][x][0] = cube[x][y][0];
					break;
				}
				case "Xi":{
					tempCube[x][t][1] = cube[y][x][1];
					tempCube[x][t][0] = cube[y][x][0];
					break;
				}
				case "Y":{
					tempCube[t][0][x] = cube[x][0][y];
					tempCube[t][1][x] = cube[x][1][y];
					break;
				}
				case "Yi":{
					tempCube[x][0][t] = cube[y][0][x];
					tempCube[x][1][t] = cube[y][1][x];
					break;
				}
				case "Z":{
					tempCube[0][x][t] = cube[0][y][x];
					tempCube[1][x][t] = cube[1][y][x];
					break;
				}
				case "Zi":{
					tempCube[0][t][x] = cube[0][x][y];
					tempCube[1][t][x] = cube[1][x][y];
					break;
				}
				}
			}
			t++;
		}
		
		save();
	}

}
