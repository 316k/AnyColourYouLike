package anycolouryoulike;

import java.util.ArrayList;
import java.util.Arrays;

public class KNNColorClassifier extends ColorClassifier {

    /**
     * Hyperparamètre : combien de voisins considérer
     */
    private final int k = 10;
    
    private ArrayList<ColorLabel> colors; 
    
    public KNNColorClassifier() {
        
        colors = new ArrayList<>();
        
        // Classification des couleurs connues
        for(ColorLabel color : this.knownColors) {
            this.add(color.r, color.g, color.b, color.name);
        }
    }
    
    // Code à faire en classe :
    
    @Override
    public void add(int r, int g, int b, String name) {
        this.colors.add(new ColorLabel(r, g, b, name));
    }
    
    /**
     * Trouve le nom d'une couleur donnée
     * @param r Valeur rouge
     * @param g Valeur vert
     * @param b Valeur bleu
     * @return Le nom de la couleur passée
     */
    public String colorName(int r, int g, int b) {
        
        ColorLabel unknown = new ColorLabel(r, g, b, "");
        
        ColorLabel[] closest = new ColorLabel[k];
        
        int number_added = 0;
        
        for(ColorLabel color : this.colors) {
            if(number_added < k) {
                /* Si on a pas encore accumulé k couleurs, on l'ajoute la
                   couleur actuelle aux candidats retenus sans poser de question */
                closest[number_added] = color;
                number_added++;
                
                if(number_added == k) {
                    Arrays.sort(closest);
                }
            } else {
                /* Sinon, on compare à chaque couleur précédement retenue.
                   Si la couleur actuelle est plus proche de unknown que la ième
                   couleur retenue, on l'utilise à sa place */
                for(int i = 0; i < k; i++) {
                    if(unknown.compareTo(color) < unknown.compareTo(closest[i])) {
                        // On remplace l'ancien ième plus proche par color
                        closest[i] = color;
                        break;
                    }
                }
            }
        }
        
        ArrayList<String> names = new ArrayList<>();
        
        for(ColorLabel color : closest) {
            if(color == null) {
                break;
            }
            
            names.add(color.name);
        }
        
        return ColorClassifier.majority(names);
    }
}
