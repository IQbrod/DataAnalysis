import exceptions.*;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

public class Dataframe {
    private HashMap<Object, Integer> indexs;
    private HashMap<Object, List> labels;

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
        for (Object o : indexs) {
            this.indexs.put(o, index);
            index++;
        }
        //Construction des labels
        this.labels = new HashMap<>();
        for (int i=0; i < labels.size(); i++) {
            this.labels.put(labels.get(i), data[i]);
        }
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

