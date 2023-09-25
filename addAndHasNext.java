import java.util.NoSuchElementException;

public class addAndHasNext {
    
    public void add(Fraction frc) {
        return elements.add(element);
    }   
    public boolean hasNext() {
        try {
            Fraction next = this.next();
            return true;
        } catch (NoSuchElementException x) {
            return false;
        }        
    }
}