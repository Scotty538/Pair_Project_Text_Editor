import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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

        try {
            Theme theme = Theme.load(getClass().getResourceAsStream(
                    "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
            theme.apply(newPage);
        } catch (IOException ioe) {
            System.out.println("There is a problem with the RSyntaxTextArea theme");
            ioe.printStackTrace();
        }

        // Set font
        Font font = new Font("Consolas",Font.PLAIN,16);
        newPage.setFont(font);

        // Adding scrollable panel with the editor page
        RTextScrollPane scrollPage = new RTextScrollPane(newPage);
        Gutter gutter = scrollPage.getGutter();

        // Setting background/foreground colours to match the main window
        if (darkMode) {
           newPage.setForeground(new Color(204, 204, 204));
           newPage.setBackground(new Color(58, 58, 58));
           gutter.setBackground(new Color(58, 58, 58));
           newPage.setCurrentLineHighlightColor(new Color(84, 84, 84));// Change colour of highlighted line
        } else {
           newPage.setForeground(new Color(58, 58, 58));
           newPage.setBackground(new Color(204, 204, 204));
           gutter.setBackground(new Color(204, 204, 204));
           newPage.setCurrentLineHighlightColor(new Color(199, 199, 199));
        }

        // Creating and displaying menu bar component
        newWindow.setJMenuBar(MenuBar.createMenuBar(newPage, gutter));

        newWindow.add(scrollPage);
        newWindow.setSize(600, 400);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocation(ChildWindow.newWindow.getX() + 50, ChildWindow.newWindow.getY() + 50);

        newWindow.setVisible(true);
    }
}
