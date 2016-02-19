package anycolouryoulike;

import java.util.ArrayList;

public class SimpleColorClassifier extends ColorClassifier {

    /**
     * "Cube" de ArrayList de Strings
     */
    private ArrayList<String>[][][] cube;
    
    /**
     * Hyperparamètre : en combien de sections est divisée chaque dimension du cube
     */
    private int sections;

    /**
     * 
     * @param colors
     * @param sections 
     */
    public SimpleColorClassifier(ColorLabel[] colors, int sections) {
        
        this.sections = sections;
        this.cube = new ArrayList[sections][sections][sections];
        
        for(int i = 0; i < sections; i++) {
            for(int j = 0; j < sections; j++) {
                for(int k = 0; k < sections; k++) {
                    this.cube[i][j][k] = new ArrayList<>();
                }
            }
        }
        
        // Classification des couleurs connues
        for(ColorLabel color : colors) {
            this.add(color.r, color.g, color.b, color.name);
        }
    }
    
    // Code à faire en classe :
    
    @Override
    public void add(int r, int g, int b, String name) {
        this.cube[classify(r)][classify(g)][classify(b)].add(name);
    }
    
    public int classify(int value) {
        return value * sections / 256;
    }
    
    /**
     * Trouve le nom d'une couleur donnée
     * @param r Valeur rouge
     * @param g Valeur vert
     * @param b Valeur bleu
     * @return Le nom de la couleur passée
     */
    public String colorName(int r, int g, int b) {
        
        return ColorClassifier.majorityVote(this.cube[classify(r)][classify(g)][classify(b)]);
    }
    
}
