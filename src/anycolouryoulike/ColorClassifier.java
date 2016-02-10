package anycolouryoulike;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ColorClassifier {
    
    /**
     * Ensemble de couleurs de départ
     */
    protected ColorLabel[] knownColors = new ColorLabel[]{
        new ColorLabel(0, 0, 0, "noir"),
        new ColorLabel(255, 255, 255, "blanc"),
        new ColorLabel(255, 0, 0, "rouge"),
        new ColorLabel(0, 255, 0, "vert"),
        new ColorLabel(0, 0, 255, "bleu"),
    };

    public abstract void add(int r, int g, int b, String name);
    
    // Présenté en classe
    /**
     * Helper pour trouver l'élément retrouvé le plus souvent dans un tableau de strings
     * @param arr
     * @return 
     */
    public static String majority(ArrayList<String> arr) {
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
    
    /**
     * Trouve le nom d'une couleur donnée
     * @param r Valeur rouge
     * @param g Valeur vert
     * @param b Valeur bleu
     * @return Le nom de la couleur passée
     */
    public abstract String colorName(int r, int g, int b);
}
