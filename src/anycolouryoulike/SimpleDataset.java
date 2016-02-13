package anycolouryoulike;

public class SimpleDataset {

    public static ColorLabel[] colors() {
        return new ColorLabel[]{
            new ColorLabel(0, 0, 0, "noir"),
            new ColorLabel(255, 255, 255, "blanc"),
            new ColorLabel(255, 0, 0, "rouge"),
            new ColorLabel(0, 255, 0, "vert"),
            new ColorLabel(0, 0, 255, "bleu"),
        };
    }
}
