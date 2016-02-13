package anycolouryoulike;

public class AnyColorYouLike {

    public static void main(String[] args) {
        
        /* Autres exemples avec l'Histogramme (SimpleColorClassifier):
        
        // Incapable de nommer la majorité des réponses
        Window w = new Window(new SimpleColorClassifier(SimpleDataset.colors(), 10));
        
        // Certains résultats sont étranges
        Window w = new Window(new SimpleColorClassifier(BigDataset.colors(), 10));
        
        // Vitesse moyenne, précision moyenne
        Window w = new Window(new SimpleColorClassifier(HugeDataset.colors(), 30));
        
        // Rapide, mais pas très précis
        Window w = new Window(new KNNColorClassifier(SimpleDataset.colors(), 1));
        
        // Très lent, mais donne des très bons résultats
        Window w = new Window(new KNNColorClassifier(HugeDataset.colors(), 30));
        
        // Rapide, mais certains résultats sont étranges
        Window w = new Window(new KNNColorClassifier(BigDataset.colors(), 10)); // Average precision
        */
        
        // Bons résultats, peu précis, incapable de nommer un petit nombre de couleurs
        Window w = new Window(new SimpleColorClassifier(SimpleDataset.colors(), 2));
    }
}
