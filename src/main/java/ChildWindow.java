import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.yaml.snakeyaml.Yaml;

public class ChildWindow extends JFrame {
    public static RSyntaxTextArea newPage;
    public static JFrame newWindow;
    public static boolean darkMode = true;
    public static String fontName;
    public static int fontSize;
    public static int fontStyle;

    // Constructor
    ChildWindow () {
        newWindow = new JFrame("TE Text Editor");

        // Adding text area
        newPage = new RSyntaxTextArea();
        newPage.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Set syntax colouring to java conventions
        newPage.setLineWrap(true);
        newPage.setCodeFoldingEnabled(true);

        // Adding scrollable panel with the editor page
        RTextScrollPane scrollPage = new RTextScrollPane(newPage);
        Gutter gutter = scrollPage.getGutter();

        // Loading font settings from yaml configuration file
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.yaml");
            Map<String, String> defaultFontSettings = yaml.load(inputStream);
            fontName = defaultFontSettings.get("fontName");
            fontSize = Integer.parseInt(defaultFontSettings.get("fontSize"));
            fontStyle = getFontStyle(defaultFontSettings.get("fontStyle"));
        } catch (Exception ioExcept) {
            JOptionPane.showMessageDialog(newWindow, "Error reading font from yaml configuration file: " + ioExcept.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Setting background/foreground colours of new window to match the current window
        if (darkMode) {
            // Setting menuBar color to dark theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }

            // Setting syntax highlighting theme to match dark theme
            try {
                Theme theme = Theme.load(getClass().getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
                theme.apply(newPage);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the second RSyntaxTextArea syntax highlighting theme in ChildWindow");
            }
            SwingUtilities.updateComponentTreeUI(newWindow);

            newPage.setFont(new Font(fontName, fontStyle, fontSize));

            newPage.setForeground(new Color(204, 204, 204));
            newPage.setBackground(new Color(58, 58, 58));
            gutter.setBackground(new Color(58, 58, 58));
            newPage.setCurrentLineHighlightColor(new Color(84, 84, 84));// Change colour of highlighted line
        } else {
            // Setting menuBar color to light theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }

            // Setting syntax highlighting theme to match light theme
            try {
                Theme theme = Theme.load(getClass().getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                theme.apply(newPage);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the third RSyntaxTextArea syntax highlighting theme");
            }
            SwingUtilities.updateComponentTreeUI(newWindow);

            newPage.setFont(new Font(fontName, fontStyle, fontSize));

            newPage.setForeground(new Color(58, 58, 58));
            newPage.setBackground(new Color(214, 214, 214));
            gutter.setBackground(new Color(214, 214, 214));
            newPage.setCurrentLineHighlightColor(new Color(189, 189, 189));
        }

        // Creating and displaying menu bar component
        newWindow.setJMenuBar(MenuBar.createMenuBar(newPage, gutter, newWindow));

        newWindow.add(scrollPage);
        newWindow.setSize(600, 400);
        newWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newWindow.setLocation(50,50);
        newWindow.setVisible(true);
        newPage.requestFocusInWindow();
    }

    private int getFontStyle(String style) {
        switch (style.toUpperCase()) {
            case "BOLD":
                return Font.BOLD;
            case "ITALIC":
                return Font.ITALIC;
            default:
                return Font.PLAIN;
        }
    }

// Used to testing Open
//    public JFrame getFrame() {
//        return newWindow;
//    }
}
