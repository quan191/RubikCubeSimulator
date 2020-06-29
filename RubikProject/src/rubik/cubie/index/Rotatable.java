package rubik.cubie.index;

import java.util.List;

public interface Rotatable {
	 public List<Integer> getCube();
	 public void setCube(List<Integer> order);
	 public void save();
	 public void turn(String rotate);
	 public List<Integer> getWhatToTurn(String rotate);
}
