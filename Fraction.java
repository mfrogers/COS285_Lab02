/**
 * Fraction Class - class that generates object fraction from two ints.  Implements INumber inteface.
 * Uses methods to add, subtract, divide, and multiply fraction objects.
 * 
 * @author Max Rogers
 * @version 12 September 2023
 */

public class Fraction implements INumber<Fraction>, Comparable<Fraction>{
	private int num;
	private int denom;
	
	
	public Fraction(int num, int denom) {
		this.num = num;
		this.denom = denom;
	}
	
	/**
	 * Method used to add one fraction object to another
	 * @param input the Fraction to be added 
	 * @return added fractions
	 * @author maxrogers
	 */
	public Fraction plus(Fraction input) {
		int commonDenom = this.getDenom()*input.getDenom();
		int firstFracNum = this.getNum()*input.getDenom();
		int secondFracNum = input.getNum()*this.getDenom();
		return new Fraction(firstFracNum+secondFracNum, commonDenom);
	}
		
	/**
	 * Method used to subtract one fraction object from another
	 * @param input the Fraction to be subtracted 
	 * @return subtracted fractions
	 * @author maxrogers
	 */
	public Fraction minus(Fraction input) {
		int commonDenom = this.getDenom()*input.getDenom();
		int firstFracNum = this.getNum()*input.getDenom();
		int secondFracNum = input.getNum()*this.getDenom();
		return new Fraction(firstFracNum-secondFracNum, commonDenom);
	}

	
	/**
	 * Method used to divide one fraction object from another.  Uses the flipFraction method
	 * and the multiply method to cross multiply the fractions
	 * @param input the Fraction to be divided
	 * @return divided fraction
	 * @author maxrogers
	 */
	@Override
	public Fraction divide(Fraction input) {
		Fraction firstFraction = new Fraction(this.getNum(), this.getDenom());
		Fraction recip = input.flipFraction(input);
		return firstFraction.multiply(recip);
	}
	
	/**
	 * method to flip the numerator and denominator of a fraction to be used for cross multiplication
	 * @param input Fraction to be reversed
	 * @return reciprocal fraction
	 * @author maxrogers
	 */
	public Fraction flipFraction(Fraction input) {
		int temp = input.getDenom();
		input.setDenom(input.getNum());
		input.setNum(temp);
		return input;
	}
	
	/**
	 * method that multiplies fraction objects
	 * @param input Fraction to be multiplied to current fraction
	 * @return multiplied fraction
	 * @author maxrogers
	 */
	@Override
	public Fraction multiply(Fraction input) {
		return new Fraction((input.getNum()*this.getNum()), input.getDenom()*this.getDenom());
	}
	
	/**
	 * simple print method, prints the numerator and denominator of the current fraction object
	 * @author maxrogers
	 */
	@Override
	public void print() {
		System.out.println(getNum()+" / "+getDenom());		
	}
	
	
	//Standard Setters and Getters	
	public int getNum() {
		return num;
	}

	private void setNum(int num) {
		this.num = num;
	}

	public int getDenom() {
		return denom;
	}

	private void setDenom(int denom) {
		this.denom = denom;
	}

	
	/**
	 * 
	 * @param input1
	 * @return
	 * @author madalynamero
	 */
	public static Fraction simplify(Fraction input1) {
		int newNum = input1.getNum()/GDC(input1);
		int newDenom = input1.getDenom()/GDC(input1);
		return new Fraction(newNum, newDenom);
	}
	
	
	/**
	 * 
	 * @param input1
	 * @return
	 * @author madalynamero
	 */
	public static int GDC(Fraction input1) {
		int gdc = 1;
		for (int i = 1; i < Math.min(input1.getNum(), input1.getDenom()); i++) {
			if ((input1.getNum()%i==0)&&(input1.getDenom()%i==0)) {
				gdc = i;
			}
		}
		return gdc;
	}
	
	
	/**
	 * 
	 * @param input
	 * @author maxrogers
	 */
	public static void sort(Fraction[] input) {
		for (int i = 1; i < input.length; i++) {
			insert(input, i);
		}
	}
	
	
	/**
	 * 
	 * @param input
	 * @param i
	 * @author maxrogers
	 */
	public static void insert(Fraction[] input, int i) {
		Fraction nextValue = input[i];
		while (i > 0 && nextValue.compareTo(input[i-1])<0) {
			input[i]=input[i-1];
			i--;
		}
		input[i] = nextValue;
	}
	
	public boolean equals(Fraction f) {
        if (this.getNum() == f.getNum() && this.getDenom() == f.getDenom()) 
            return true; 
        return false;
    }
	
	
	/**
	 * 
	 * @param input1
	 * @return
	 * @author madalynamero
	 */
	public static double percent(Fraction input1) {
		double num = input1.getNum();
		double denom = input1.getDenom();
		double percentage = (num/denom)*100;		
		return percentage;
	}
		
	/**
	 * 
	 * @param f
	 * @return
	 * @author maxrogers
	 */
	public boolean hasSameValue(Fraction f) {
		int thisNumerator = this.num * f.denom;
        int otherNumerator = f.num * this.denom;
        return thisNumerator == otherNumerator;
	}
	

	/**
	 * @author maxrogers 
	 */
	@Override
	public int compareTo(Fraction f) {
        int numerator1 = this.num * f.denom;
        int numerator2 = f.num * this.denom;
        return Integer.compare(numerator1, numerator2);
    }

}	
