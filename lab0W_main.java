import java.util.ArrayList;

public class lab0W_main {

	public static void main(String[] args) {
		Fraction[] fractionArray = new Fraction[100];
		for(int i=0; i<fractionArray.length; i++)
		fractionArray[i] = new Fraction(i, i+1);
	}
	
	/**
	 * Method that adds a new fraction to the end of an existing arrayList
	 * @param aL arrayList to be added to
	 * @param f fraction to be added to the arrayList
	 * @return boolean true if Fraction was successfully added, and false if it was not
	 */
	public boolean booleanAddMethod(ArrayList<Fraction> aL, Fraction f){
		if(aL.add(new Fraction(f.getNum(), f.getDenom())))
			return true;
		return false;
	}
	
    private static void findFrequent(double[] array) {
        int l = array.length;
        double freq = 0;
        int number = 0;
        for(int i = 0; i < l; i++) {
            int c = 0;
            for(int j = 0; j < l; j++) {
                if(Double.compare(array[i],array[j]) == 0) {
                    c++;
                }
            }
            if(c > number) {
                number = c;
                freq = array[i];
            }
        }
    }
}
