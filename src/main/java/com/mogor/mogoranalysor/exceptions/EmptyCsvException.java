package com.mogor.mogoranalysor.exceptions;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class EmptyCsvException extends Exception{
    public EmptyCsvException() {
        super("CSV File is empty");
    }
    public EmptyCsvException(String s) {
        super("CSV File contains no dataset");
    }
}
