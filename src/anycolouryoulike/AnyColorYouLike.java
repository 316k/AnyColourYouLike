package anycolouryoulike;

public class AnyColorYouLike {

    public static void main(String[] args) {
        
        Window w = new Window(new KNNColorClassifier(HugeDataset.colors()));
    }
}
