import exceptions.*;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

class attr {
    public Object label;
    public List lst;
    
    public attr(Object label, List val) {
        this.label = label;
        this.lst = val;
    }
}

public class Dataframe {
    private HashMap<Integer, Object> indexs;
    private HashMap<Integer, attr> labels;

    //Constructeur avec tableaux
    public Dataframe(List indexs, List labels, List... data) throws LabelException, IdxException {
        /*** Checking DataSet ***/
        if (labels.size() != data.length) {
            throw new LabelException(labels.size(),data.length);
        }
        for(int i=0;i<data.length;i++) {
            if(indexs.size() != data[i].size()) {
                throw new IdxException(indexs.size(),labels.get(i).toString(),data[i].size());
            }
        }
        
        //Construction des indexs
        this.indexs = new HashMap<>();
        int index = 0;
        for (int i = 0; i < indexs.size(); i++) {
            this.indexs.put(index, indexs.get(i));
            index++;
        }
        //Construction des labels
        this.labels = new HashMap<>();
        index = 0;
        for (int i=0; i < labels.size(); i++) {
            this.labels.put(index, new attr(labels.get(index),data[i]));
            index ++;
        }
    }
    
    public void fullDisplay() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        // Gestion des labels
        String ret = "Index\t";
        for(Integer el : labels.keySet()) {
            ret += labels.get(el).label.toString() + "\t";
        }
        ret += "\n";
        // Gestion des données
        for(Integer el : indexs.keySet()) {
            ret += indexs.get(el).toString() + "\t";
            for(Integer el2 : labels.keySet()) {
                ret += labels.get(el2).lst.get(el) + "\t";
            }
            ret += "\n";
        }
        // Retour
        return ret;
    }
}

