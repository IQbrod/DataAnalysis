package main.java.com.mogor.mogoranalysor;

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
        System.out.println("░░░░░░░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░▄████████████████▄░░░░░░░░░░");
        System.out.println("░░░░░░░░░░▄██▀░░░░░░░▀▀████████▄░░░░░░░░");
        System.out.println("░░░░░░░░░▄█▀░░░░░░░░░░░░░▀▀██████▄░░░░░░");
        System.out.println("░░░░░░░░░███▄░░░░░░░░░░░░░░░▀██████░░░░░");
        System.out.println("░░░░░░░░▄░░▀▀█░░░░░░░░░░░░░░░░██████░░░░");
        System.out.println("░░░░░░░█▄██▀▄░░░░░▄███▄▄░░░░░░███████░░░");
        System.out.println("░░░░░░▄▀▀▀██▀░░░░░▄▄▄░░▀█░░░░█████████░░");
        System.out.println("░░░░░▄▀░░░░▄▀░▄░░█▄██▀▄░░░░░██████████░░");
        System.out.println("░░░░░█░░░░▀░░░█░░░▀▀▀▀▀░░░░░██████████▄░");
        System.out.println("░░░░░░░▄█▄░░░░░▄░░░░░░░░░░░░██████████▀░");
        System.out.println("░░░░░░█▀░░░░▀▀░░░░░░░░░░░░░███▀███████░░");
        System.out.println("░░░▄▄░▀░▄░░░░░░░░░░░░░░░░░░▀░░░██████░░░");
        System.out.println("██████░░█▄█▀░▄░░██░░░░░░░░░░░█▄█████▀░░░");
        System.out.println("██████░░░▀████▀░▀░░░░░░░░░░░▄▀█████████▄");
        System.out.println("██████░░░░░░░░░░░░░░░░░░░░▀▄████████████");
        System.out.println("██████░░▄░░░░░░░░░░░░░▄░░░██████████████");
        System.out.println("██████░░░░░░░░░░░░░▄█▀░░▄███████████████");
        System.out.println("███████▄▄░░░░░░░░░▀░░░▄▀▄███████████████");

        List idx = Arrays.asList("Paul","Pierre","Jack");
        List lbl = Arrays.asList("Age","Sex");
        List age = Arrays.asList(24,37,29);
        List sex = Arrays.asList('H','F','H');
        
        Dataframe d;
        try {
            d = new Dataframe(idx,lbl,age,sex);
            d.fullDisplay();
            DataframeStatistics dfs;
            dfs = new DataframeStatistics(d);
            System.out.println(dfs.getMinCol("Sex").toString());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String fName = "people.csv";
            d = new Dataframe("src/main/java/com/mogor/mogoranalysor/csvfiles/"+fName);
            d.fullDisplay();
            DataframeStatistics dfs = new DataframeStatistics(d);
            System.out.println(dfs.getMinCol("sex").toString());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
