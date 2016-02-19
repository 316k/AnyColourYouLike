package anycolouryoulike;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class HugeDataset {

    public static ColorLabel[] colors() {
        ArrayList<ColorLabel> colors = new ArrayList<>();
        
        try {
            File f = new File("colors.txt");
            System.out.println(f.getAbsolutePath());
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            String s = "";
            while((s = br.readLine()) != null) {
                try {
                    int r = Integer.parseInt(s.substring(0, s.indexOf(',')));
                    s = s.substring(s.indexOf(',') + 1);
                    int g = Integer.parseInt(s.substring(0, s.indexOf(',')));
                    s = s.substring(s.indexOf(',') + 1);
                    int b = Integer.parseInt(s.substring(0, s.indexOf(',')));
                    s = s.substring(s.indexOf(',') + 1);
                    colors.add(new ColorLabel(r, g, b, s));
                } catch(NumberFormatException e) {
                    System.out.println("NumberFormatException");
                }
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch(IOException e) {
            System.out.println("IOException");
        }
        
        return colors.toArray(new ColorLabel[colors.size()]);
    }
}
