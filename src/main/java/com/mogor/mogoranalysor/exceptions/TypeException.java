package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class TypeException extends Exception {
    public TypeException(String expected, String given) {
        super("Expected Type : "+expected+": . "+given);
    }
    
    public TypeException(Class<?> expected, Class<?> given) {
        super("Expected Type : "+expected.toString()+": . "+given.toString());
    }
}
