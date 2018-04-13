package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class TypeException extends Exception {
    public TypeException(Class<?> expected, Class<?> given) {
        super("Expected Type : "+expected.toString()+": . "+given.toString());
    }
}
