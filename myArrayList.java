import java.util.ArrayList;
import java.util.List;

public class myArrayList extends Fraction {
	
	
	public myArrayList(int num, int denom) {
		super(num, denom);
		// TODO Auto-generated constructor stub
	}
	
	public int setGrowth(List<Fraction> list, double percentage) {
		double currentsize = list.size();
		int newsize = (int) (currentsize + (currentsize * percentage));
		return newsize;
		
				
	}
	
}