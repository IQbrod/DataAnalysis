package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class UnknownLabelException extends Exception{
    public UnknownLabelException(String s) {
        super("Label "+s+" does not exists");
    }
}
