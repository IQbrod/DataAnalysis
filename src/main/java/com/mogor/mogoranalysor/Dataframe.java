package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //Constructeur par CSV
    public Dataframe(String filePath) throws Exception {
        /** Check if file is CSV **/
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
                String expected = "csv";
                String ext = filePath.substring(i+1).toLowerCase();
                if (! ext.equals(expected)) {
                    throw new ExtensionException(expected.toUpperCase(),ext);
                }
        } else {
            throw new ExtensionException();
        }
        /*** Open and parse CSV file ***/
        String line = "";
        String splitter = ",";
        /** DataFrame attributes **/
        String[] lab = null;
        List<String[]> args = new ArrayList<String[]>();
        /** Parse file **/
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if ((line = br.readLine()) != null) { //First Line
                lab = line.split(splitter);
            }
            while ((line = br.readLine()) != null) {
                args.add(line.split(splitter));
            }
        } catch (Exception ex) {
            throw ex;
        }
        /** Checking data **/
        if (lab == null) {
            throw new EmptyCsvException();
        }
        if (args.isEmpty()) {
            throw new EmptyCsvException("");
        }
        for (String[] arg : args) {
            if (arg.length-1 != lab.length) {
                throw new TupleSizeException(arg[0],arg.length-1,lab.length);
            }
        }
        /** Transform data **/
        
    }
    
    public void fullDisplay() {
        System.out.println(this.toString());
    }
    
    public void firstLinesDisplay(int i) {
        System.out.println(partial(0,i-1));
    }
    
    public void lastLinesDisplay(int i) {
        int s = indexs.keySet().size()-1;
        System.out.println(partial(s-i+1,s));
    }
    
    @Override
    public String toString() {
        return partial(0,indexs.keySet().size()-1);
    }
    
    private String partial(int beg, int end) {
        // Gestion des labels
        String ret = "Index\t";
        for(Integer el : labels.keySet()) {
            ret += labels.get(el).label.toString() + "\t";
        }
        ret += "\n";
        // Gestion des données
        int it = 0;
        for(Integer el : indexs.keySet()) {
            if (it >= beg && it <= end) {
                ret += indexs.get(el).toString() + "\t";
                for(Integer el2 : labels.keySet()) {
                    ret += labels.get(el2).lst.get(el) + "\t";
                }
                ret += "\n";
            }
            it++;
        }
        // Retour
        return ret;
    }
}

