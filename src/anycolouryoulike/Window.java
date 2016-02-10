package anycolouryoulike;

import java.awt.Dimension;
import com.bric.swing.ColorPicker;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Fenêtre simple avec un color picker et un input field pour nommer des
 * couleurs
 */
public class Window extends JFrame {

    private ColorClassifier colorDetector;
    private JLabel label;
    private ColorPicker picker;

    public Window() {
        
        colorDetector = new SimpleColorClassifier();
        
        this.setTitle("Any Colour You Like");
        this.setSize(new Dimension(600, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Text
        label = new JLabel("?");
        Font f = new Font("", Font.PLAIN, 32);
        label.setFont(f);
        label.setAlignmentX(RIGHT_ALIGNMENT);

        // Color Picker
        picker = new ColorPicker();
        picker.setColor(Color.white);

        picker.addPropertyChangeListener(ColorPicker.SELECTED_COLOR_PROPERTY, new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateLabel();
            }
        });

        // Input
        JTextField text = new JTextField();
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    colorDetector.add(picker.getRGB()[0], picker.getRGB()[1], picker.getRGB()[2], text.getText().toLowerCase());
                    text.setText("");
                    updateLabel();
                }
            }
        });

        panel.add(picker);
        panel.add(label);
        panel.add(text);

        updateLabel();

        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void updateLabel() {
        String name = colorDetector.colorName(picker.getRGB()[0], picker.getRGB()[1], picker.getRGB()[2]);
        label.setText(Character.toUpperCase(name.charAt(0)) + name.substring(1));
    }
}
