import java.util.List;

public interface myArrayListIterator {

	public static boolean hasPrevious(List<Fraction> list, int index) {
		if(list.get(index - 1) != null) {
			return true;
		} else {
			return false;
		}
			
	}
	
	public static Fraction next(List<Fraction> list, int index) {
		return list.get(index + 1);
	}
	
	public static void setFraction(Fraction frc) {
		
	}
	
}
