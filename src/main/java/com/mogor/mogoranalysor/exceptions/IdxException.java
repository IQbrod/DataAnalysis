package exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class IdxException extends Exception{
    public IdxException(int i,String name, int d) {
        super(i+" index for "+d+" "+name+"'s values");
    }
}
