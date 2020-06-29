package rubik.cubie.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class CubieIndexes implements Rotatable {
	
	protected int[][][] cube;
	protected int[][][] tempCube;
	
	protected int n;

	public CubieIndexes(int n) {
		// TODO Auto-generated constructor stub
		int l = 1;
		this.n = n;
		cube = new int[n][n][n];
		tempCube = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					cube[i][j][k] = l;
					l+=1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.arraycopy(cube[i][j], 0, tempCube[i][j], 0, n);
			}
		}
	}

	public List<Integer> getCube() {
		List<Integer> newArray = new ArrayList<>();
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				for (int k = 0; k < this.n; k++) {
					newArray.add(cube[i][j][k]);
				}
			}
		}
		return newArray;
	}

	public void setCube(List<Integer> order) {
		int index = 0;
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				for (int k = 0; k < this.n; k++) {
					cube[i][j][k] = order.get(index++);
					tempCube[i][j][k] = cube[i][j][k];
				}
			}
		}
	}

	public void save() {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				System.arraycopy(tempCube[i][j], 0, cube[i][j], 0, this.n);
			}
		}
	}

	public List<Integer> getWhatToTurn(String rotate){
		List<Integer> order;
		List<Integer> reorder;
		List<Integer> layer;
		order = this.getCube();
		// rotate cube indexes		
		this.turn(rotate);
		reorder = this.getCube();
		// select cubies to rotate: those in reorder different from order.
		AtomicInteger index = new AtomicInteger();
		layer = order.stream().filter(o -> !Objects.equals(o, reorder.get(index.getAndIncrement())))
				.collect(Collectors.toList());
		return layer;
	}

}
