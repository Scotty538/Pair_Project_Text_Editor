import javax.swing.*;
import java.awt.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class TextEditor extends JFrame {
    // Initialising frame and page
    public static JFrame frame;
    public static RSyntaxTextArea page;
    // Constructor
    TextEditor()
    {
        frame = new JFrame("Alex and Scott's Editor");

        // Adding text area
        page = new RSyntaxTextArea();
        page.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Set syntax colouring to java conventions
        page.setCodeFoldingEnabled(true); // Allows folding/collapsing of code sections

        Font font = new Font("Monospaced",Font.PLAIN,14);
        TextEditor.page.setFont(font);

        // Adding scrollable pane with the editor page
        RTextScrollPane scrollPage = new RTextScrollPane(page);

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
