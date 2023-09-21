import java.util.ArrayList;

public class Lab_Main {

	public static void main(String[] args) {
//		Fraction[] fractionArray = new Fraction[100];
//		for(int i=0; i<fractionArray.length; i++)
//			fractionArray[i] = new Fraction(i, i+1);
		
//    	FindFrequent fF = new FindFrequent();
    	
//		Fraction fFTest = findFrequent(fractionArray, fF);
//		fFTest.print();	
		
//		printArrayInReverse(fractionArray, fractionArray.length-1);
    	
    	
    	myArrayList<Fraction> fractionList = new myArrayList<>();
    	for(int i=0; i<50; i++)
    		if(fractionList.add(new Fraction(i, i+1)));
    		else
    			System.out.println("Issue");
    	
    	System.out.println("Size of fractionList: " + fractionList.getSize());
        System.out.print("Element at index 0: "); fractionList.get(0).print();
        System.out.print("Element at index 1: "); fractionList.get(1).print();

        Fraction searchFraction = new Fraction(10, 1);
        boolean containsFraction = fractionList.contains(searchFraction);
        System.out.print("Contains "); searchFraction.print(); System.out.println(":"+containsFraction);
        
        searchFraction = new Fraction(0, 1);
        containsFraction = fractionList.contains(searchFraction);
        System.out.print("Contains "); searchFraction.print(); System.out.println(":"+containsFraction);

	}
	
	
	
	
/*-------------------------------------      
    	    LAB0 CODE
-------------------------------------*/ 
		
	/**
	 * 
	 * @param array
	 * @param i
	 * @author maxrogers
	 */
    public static void printArrayInReverse(Fraction[] array, int i) {
        if (i < 0 || i >= array.length) 
            return;
       array[i].print();
       printArrayInReverse(array, i - 1);
    }
	
	
	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param fF
	 * @author maxrogers
	 */
	public static <T>void insertionSort(Fraction[] array, FindFrequent fF) {
		for (int i = 1; i < array.length; i++)
			for (int j = i; j > 0 && fF.compare(array[j-1], array[j]) > 0; j--)
				swap(array, j, j-1);		
	}
	
	
	/**
	 * 
	 * @param array
	 * @param j
	 * @param jm1
	 * @author maxrogers
	 */
	private static void swap(Fraction[] array, int j, int jm1) {
		Fraction temp = array[j];
		array[j] = array[jm1];
		array[jm1] = temp;		
	}	
	
	
	/**
	 * 
	 * @param array
	 * @return
	 * @author maxrogers
	 */
    public static Fraction findFrequent(Fraction[] array, FindFrequent fF) {
    	insertionSort(array, fF);
    	int maxCount = 1;
        int currentCount = 1;
        Fraction mostFrequent = array[0];       
    	for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) 
                currentCount++;
            else
                currentCount = 1;
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequent = array[i];
            }
        }
        return mostFrequent;
    }
    
    
    
/*-------------------------------------      
    	    LAB01 CODE
-------------------------------------*/  
       
	/**
	 * Method that adds a new fraction to the end of an existing arrayList
	 * @param aL arrayList to be added to
	 * @param f fraction to be added to the arrayList
	 * @return boolean true if Fraction was successfully added, and false if it was not
	 * @author maxrogers
	 */
	public boolean booleanAddMethod(ArrayList<Fraction> aL, Fraction f){
		if(aL.add(new Fraction(f.getNum(), f.getDenom())))
			return true;
		return false;
	}
    
    
}
