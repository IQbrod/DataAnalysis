package com.mogor.mogoranalysor;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class Main {
    static public void main(String argv[]) {
        List idx = Arrays.asList("Paul","Linda","Jack");
        List lbl = Arrays.asList("Age","Sex");
        List age = Arrays.asList(24,37,29);
        List sex = Arrays.asList('H','F','H');
        
        Dataframe d;
        try {
            d = new Dataframe(idx,lbl,age,sex);
            d.fullDisplay();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}