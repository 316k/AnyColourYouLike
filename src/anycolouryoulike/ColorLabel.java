package anycolouryoulike;


public class ColorLabel implements Comparable<ColorLabel> {
    
    int r;
    int g;
    int b;
    String name;

    public ColorLabel(int r, int g, int b, String name) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.name = name;
    }

    /**
     * Fonction de comparaison à une autre couleur. Retourne la distance
     * pythagorienne des deux couleurs.
     * 
     * @param other
     * @return 
     */
    @Override
    public int compareTo(ColorLabel other) {
        
        // Distance de deux vecteurs : pythagore en 3D
        // 0,0 à 10,20 : sqrt((10 - 0)² + (20 - 0)²)
        // 0,0,0 à 5,5,5 : 
        
        return (int) Math.sqrt(Math.pow(other.r - this.r, 2) +
                Math.pow(other.g - this.g, 2) +
                Math.pow(other.b - this.b, 2));
    }
}
