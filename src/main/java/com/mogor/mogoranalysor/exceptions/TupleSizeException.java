package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class TupleSizeException extends Exception{
    public TupleSizeException(String name, int d, int l) {
        super(name+" contains "+d+" data(s) for "+l+" label(s)");
    }
}
