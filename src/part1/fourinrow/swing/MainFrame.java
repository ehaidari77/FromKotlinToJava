package part1.fourinrow.swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrame() {
        super("Four in a row");
        setSize(600, 400);
        setLayout(new BorderLayout());
        add(new FieldPanel(), BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
