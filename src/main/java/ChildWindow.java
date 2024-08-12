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

        // Setting syntax highlighting color scheme to match initialised dark mode
        try {
            Theme theme = Theme.load(getClass().getResourceAsStream(
                    "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
            theme.apply(newPage);
        } catch (IOException eRSyntax) {
            System.out.println("There is a problem with the first RSyntaxTextArea theme in ChildWindow");
        }

        // Set font
        Font font = new Font("Consolas",Font.PLAIN,14);
        newPage.setFont(font);

        // Adding scrollable panel with the editor page
        RTextScrollPane scrollPage = new RTextScrollPane(newPage);
        Gutter gutter = scrollPage.getGutter();

        // Setting background/foreground colours of new window to match the current window
        if (darkMode) {
            try {
                Theme theme = Theme.load(getClass().getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
                theme.apply(newPage);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the second RSyntaxTextArea syntax highlighting theme in ChildWindow");
            }
            SwingUtilities.updateComponentTreeUI(newPage);
            newPage.setFont(font);

            newPage.setForeground(new Color(204, 204, 204));
            newPage.setBackground(new Color(58, 58, 58));
            gutter.setBackground(new Color(58, 58, 58));
            newPage.setCurrentLineHighlightColor(new Color(84, 84, 84));// Change colour of highlighted line
        } else {
            try {
                Theme theme = Theme.load(getClass().getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                theme.apply(newPage);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the third RSyntaxTextArea syntax highlighting theme");
            }
            SwingUtilities.updateComponentTreeUI(newPage);
            newPage.setFont(font);

            newPage.setForeground(new Color(58, 58, 58));
            newPage.setBackground(new Color(204, 204, 204));
            gutter.setBackground(new Color(204, 204, 204));
            newPage.setCurrentLineHighlightColor(new Color(189, 189, 189));
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
