package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class ExtensionException extends Exception{
    public ExtensionException() {
        super("No Extension Specified");
    }
    
    public ExtensionException(String expected, String given) {
        super("Expected Extension "+expected+": ."+given);
    }
}
