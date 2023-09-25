import java.util.NoSuchElementException;

//Author - James Libby
public class addAndHasNext {

    //adds a fraction to an array list of fractions
    public void add(Fraction frc) {
        return elements.add(element);
    }   

    //returns true if an arrayList has a next value and false if it doesn't have a next value
    public boolean hasNext() {
        try {
            Fraction next = this.next();
            return true;
        } catch (NoSuchElementException x) {
            return false;
        }        
    }
}
