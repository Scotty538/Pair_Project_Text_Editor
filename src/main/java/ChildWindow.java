import javax.swing.*;
import java.awt.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class ChildWindow extends JFrame {
    public static RSyntaxTextArea newPage;
    public static JFrame newWindow;
    public static boolean darkMode = true;

    // Constructor
    ChildWindow () {
        newWindow = new JFrame("New Text Document");

        // Adding text area
        newPage = new RSyntaxTextArea();
        newPage.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Set syntax colouring to java conventions

        // Set font
        Font font = new Font("Monospaced",Font.PLAIN,14);
        newPage.setFont(font);

        // Adding scrollable panel with the editor page
        RTextScrollPane scrollPage = new RTextScrollPane(newPage);
        Gutter gutter = scrollPage.getGutter();

        // Setting background/foreground colours to match the main window
        if (darkMode) {
           newPage.setForeground(new Color(224, 224, 224));
           newPage.setBackground(new Color(58, 58, 58));
           gutter.setBackground(new Color(58, 58, 58));
           newPage.setCurrentLineHighlightColor(new Color(84, 84, 84));// Change colour of highlighted line
        } else {
           newPage.setForeground(new Color(58, 58, 58));
           newPage.setBackground(new Color(224, 224, 224));
           gutter.setBackground(new Color(58, 58, 58));
           newPage.setCurrentLineHighlightColor(new Color(199, 199, 199));
        }

        // Creating and displaying menu bar component
        newWindow.setJMenuBar(MenuBar.createMenuBar(newPage));

        newWindow.add(scrollPage);
        newWindow.setSize(600, 400);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocation(ChildWindow.newWindow.getX() + 50, ChildWindow.newWindow.getY() + 50);

        newWindow.setVisible(true);
    }
}
