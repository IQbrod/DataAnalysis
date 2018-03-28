/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michauad
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dataframe {
    private HashMap<Object, Integer> indexs;
    private HashMap<Object, ArrayList<Object>> labels;

    //Constructeur avec tableaux
    public Dataframe(List<Object> indexs, List<Object> labels, List<Object>... data) {
        //Construction des indexs
        this.indexs = new HashMap<>();
        int index = 0;
        for (Object o : indexs) {
            this.indexs.put(o, index);
            index++;
        }
        //Construction des labels
        
    }
    
    public void fullDisplay() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        // Gestion des labels
        String ret = "Index\t";
        for(Object el : labels.keySet()) {
            ret += el.toString() + "\t";
        }
        ret += "\n";
        // Gestion des données
        for(Object el : indexs.keySet()) {
            ret += el.toString() + "\t";
            for(Object el2 : labels.keySet()) {
                ret += labels.get(el2).get(indexs.get(el)) + "\t";
            }
            ret += "\n";
        }
        // Retour
        return ret;
    }
}

