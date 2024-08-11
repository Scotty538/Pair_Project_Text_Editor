import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    // Initialising frame and page
    public static JFrame frame;
    public static JTextArea page;
    // Constructor
    TextEditor()
    {
        frame = new JFrame("Alex and Scott's Editor");

        // Adding text area
        page = new JTextArea();
        Font font = new Font("Monospaced",Font.PLAIN,14);
        TextEditor.page.setFont(font);

        // Adding scrollable panel with the editor page
        JScrollPane scrollPage = new JScrollPane(page);
        page.setLineWrap(true); // displays text on new line once reaching end of window
        page.setWrapStyleWord(true); // ensures the full word enters new line (instead of single char)

        TextEditor.page.setForeground(new Color(224, 224, 224));
        TextEditor.page.setBackground(new Color(58, 58, 58));

        // Creating and displaying menu bar component
        frame.setJMenuBar(MenuBar.createMenuBar());

        frame.add(scrollPage);
        frame.setSize(600, 600);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
