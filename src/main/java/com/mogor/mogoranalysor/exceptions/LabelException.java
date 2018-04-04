package exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class LabelException extends Exception {
    public LabelException(int l, int d) {
        super(l+" labels for "+d+" dataset's attributes");
    }
}
