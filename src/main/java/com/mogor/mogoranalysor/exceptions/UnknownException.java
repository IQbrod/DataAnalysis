package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class UnknownException extends Exception{
    public UnknownException(String t, String s) {
        super(t+" "+s+" does not exists");
    }
}
