package anycolouryoulike;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ColorClassifier {
    
    public abstract void add(int r, int g, int b, String name);
    
    // Présenté en classe
    /**
     * Helper pour trouver l'élément retrouvé le plus souvent dans un tableau de strings
     * @param arr
     * @return 
     */
    public static String majorityVote(ArrayList<String> arr) {
        HashMap<String, Integer> occurences = new HashMap<>();
        
        for(String name : arr) {
            int count = occurences.getOrDefault(name, 0);
            occurences.put(name, count + 1);
        }
        
        String name = "?";
        int max = -1;
        
        for(String key : occurences.keySet()) {
            if(occurences.get(key) > max) {
                max = occurences.get(key);
                name = key;
            }
        }
        
        return name;
    }
    
    
    public static String weightedMajorityVote(String[] arr, Float[] w) {
        HashMap<String, Float> occurences = new HashMap<>();
                
        int i = 0;
        for(String name : arr) {
            float weight = occurences.getOrDefault(name, 0f);
            occurences.put(name, w.length/w[i] + weight);
            i++;
        }
        
        String name = "?";
        float max = 0;
         
        for(String key : occurences.keySet()) {
            if(occurences.get(key) > max) {
                max = occurences.get(key);
                name = key;
            }
            System.out.println(key + " : " + occurences.get(key).toString());
        }
        
        return name;
    }
    
    /**
     * Trouve le nom d'une couleur donnée
     * @param r Valeur rouge
     * @param g Valeur vert
     * @param b Valeur bleu
     * @return Le nom de la couleur passée
     */
    public abstract String colorName(int r, int g, int b);
}
