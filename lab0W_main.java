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
	public boolean contains(Fraction input) {
		for (int i = 0; i < myArrayList.size(); i++) {
			if (myArrayList.get(i).equals(input)) {
				return true;
			}
		}
		return false;
	}

	 //James Libby
    //findFrequent is a method that when given an array of type double it will 
    //find whatever number occurs the most in that array
    private static void findFrequent(double[] array) {
        //"l" is the length of the array, "freq" is the number "occurring" the most, "number" keeps track
        //of the amount of times a number occurred, and c is used to tell when a number has occurred more
        //than the current highest occurring number
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
	
	public void remove(Fraction input) {
	myArrayList.remove(input); 
    }

}
